package com.example.demo.elasticsearch.query;

import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

/**
 * 构建查询条件
 */
public class QueryTemplate {


    public static NativeSearchQueryBuilder initQuery(){
        NativeSearchQueryBuilder nbq = new NativeSearchQueryBuilder().withIndices("ecommerce").withTypes("product").withSearchType(SearchType.DEFAULT);
        return nbq;
    }

    /**
     * 一般查询条件
     * @param queryBuilder
     * @return
     */
    public static NativeSearchQuery withQuery(BoolQueryBuilder queryBuilder){
        return initQuery().withQuery(queryBuilder).build();
    }

    /**
     * 一般查查询条件加排序
     * @param queryBuilder
     * @param sortBuilder
     * @return
     */
    public static NativeSearchQuery withQueryAndSort(BoolQueryBuilder queryBuilder, SortBuilder sortBuilder){
        return initQuery().withQuery(queryBuilder).withSort(sortBuilder).build();
    }

    public static NativeSearchQuery withQueryAndAddAggregation(BoolQueryBuilder queryBuilder,AbstractAggregationBuilder aggregationBuilder){
        return initQuery().withQuery(queryBuilder).addAggregation(aggregationBuilder).build();
    }


}
