package com.example.demo.elasticsearch.controller;


import com.example.demo.elasticsearch.entity.Person;
import com.example.demo.elasticsearch.entity.Product;
import com.example.demo.elasticsearch.query.QueryTemplate;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.stats.InternalStats;
import org.elasticsearch.search.aggregations.metrics.sum.InternalSum;
import org.elasticsearch.search.aggregations.metrics.sum.SumAggregationBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

@RestController
@RequestMapping("/es1")
@Slf4j
public class AnotherPersonController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/search")
    public Object search() {
        //创建查询条件，这里表示查询所有文档
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        //构造sql组装容器
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //创建聚合条件，求和函数
        SumAggregationBuilder sumAgg = AggregationBuilders.sum("sum_num").field("num");
        //将查询条件和聚合条件放入sql组装容器中
        nativeSearchQueryBuilder.withQuery(queryBuilder);
        nativeSearchQueryBuilder.addAggregation(sumAgg);
        //封装sql组装容器
        SearchQuery query = nativeSearchQueryBuilder.build();
        //执行sql,此时容器中的sql1为
        //select SUM(num) from zoo
        Aggregations aggregations = elasticsearchTemplate.query(query, SearchResponse::getAggregations);
        //将aggregations转换成map集合
        Map<String, Aggregation> aggregationMap = aggregations.asMap();
        //得到聚合的值，参数是自己定义的别名
        InternalSum internalSum = (InternalSum) aggregationMap.get("sum_num");
        return internalSum.getValue();
    }

    @GetMapping("/search1/{user}")
    public List<Person> search1(@PathVariable String user) {
        // 默认，价格升序（为了支持丰富的排序场景，建议将所有可能的排序规则放到统一的enum中
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (!user.equals("all")) {
            queryBuilder.must(matchQuery("user", user));
        }
        return elasticsearchTemplate.queryForList(QueryTemplate.withQuery(queryBuilder), Person.class);
    }

    @GetMapping("/search2/{name}")
    public List<Product> search2(@PathVariable String name) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (!name.equals("all")) {
            queryBuilder.must(termQuery("name", name));
        }
        SortBuilder sortBuilder = SortBuilders.fieldSort("price").order(SortOrder.ASC);  //排序方式
        return elasticsearchTemplate.queryForList(QueryTemplate.withQueryAndSort(queryBuilder, sortBuilder), Product.class);
    }

    @GetMapping("/search3/{name}")
    public Map<String, Object> search3(@PathVariable String name) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (!name.equals("all")) {
            queryBuilder.must(termQuery("name", name));
        }
        AbstractAggregationBuilder aggregationBuilder = AggregationBuilders.stats("my_count").field("price");
        Aggregations aggregations = elasticsearchTemplate.query(QueryTemplate.withQueryAndAddAggregation(queryBuilder, aggregationBuilder), (e) -> e.getAggregations());
        log.info("计数:{}" + aggregations.get("my_count"));
        InternalStats stats = aggregations.get("my_count");
        Map<String, Object> map = new HashMap<>();
        map.put("count", stats.getCount());
        map.put("min", stats.getMin());
        map.put("max", stats.getMax());
        map.put("avg", stats.getAvg());
        map.put("sum", stats.getSum());
        return map;
    }


    @GetMapping("/search4/{name}")
    public Map<String, Object> search4(@PathVariable String name) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (!name.equals("all")) {
            queryBuilder.must(termQuery("name", name));
        }
        //构建聚合函数(不明白可以先去kibana上面对比)
        AbstractAggregationBuilder tb = AggregationBuilders.terms("my_terms").field("price");
        AbstractAggregationBuilder sb = AggregationBuilders.sum("my_sum").field("price");
        tb.subAggregation(sb);

        Aggregations aggregations = elasticsearchTemplate.query(QueryTemplate.withQueryAndAddAggregation(queryBuilder, tb), SearchResponse::getAggregations);
        log.info("计数:{}" + aggregations.get("my_terms"));
        Terms term = aggregations.get("my_terms");
        Map<String, Object> map = new HashMap<>();
        if (term.getBuckets().size() > 0) {
            term.getBuckets().forEach((e) -> {
                        long count = e.getDocCount();
                        Object key = e.getKey();
                        //得到所有子聚合
                        Map<String, Aggregation> subaggmap = e.getAggregations().asMap();
                        //sum值获取方法
                        double amount = ((InternalSum) subaggmap.get("my_sum")).getValue();
                        log.info("count:{},key:{},amount:{}", count, key, amount);
                    }
            );
        }
        return map;
    }

}
