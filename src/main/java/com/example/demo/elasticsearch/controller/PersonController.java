package com.example.demo.elasticsearch.controller;

import com.example.demo.elasticsearch.dao.PersonRepository;
import com.example.demo.elasticsearch.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/es")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/save")
    public String save(@RequestBody Person person){
        personRepository.save(person);
        return "success";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable String id){
        personRepository.deleteById(id);
        return "success";
    }

    @PostMapping("update")
    public String update(@RequestBody Person person){
        personRepository.save(person);
        return "success";
    }

    @GetMapping("get/{id}")
    public Person getOne(@PathVariable String id){
        Person person = personRepository.findById(id).get();
        return person;
    }


    //每页数量
    private Integer PAGESIZE=10;
    //http://localhost:8888/getGoodsList?query=商品
    //http://localhost:8888/getGoodsList?query=商品&pageNumber=1
    //根据关键字"商品"去查询列表，name或者description包含的都查询
//    @GetMapping("getGoodsList")
//    public List<GoodsInfo> getList(Integer pageNumber,String query){
//        if(pageNumber==null) pageNumber = 0;
//        //es搜索默认第一页页码是0
//        SearchQuery searchQuery=getEntitySearchQuery(pageNumber,PAGESIZE,query);
//        Page<GoodsInfo> goodsPage = goodsRepository.search(searchQuery);
//        return goodsPage.getContent();
//    }
//
//
//    private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
//        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
//                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                .add(QueryBuilders.matchPhraseQuery("description", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                //设置权重分 求和模式
//                .scoreMode("sum")
//                //设置权重分最低分
//                .setMinScore(10);
//
//        // 设置分页
//        Pageable pageable = new PageRequest(pageNumber, pageSize);
//        return new NativeSearchQueryBuilder()
//                .withPageable(pageable)
//                .withQuery(functionScoreQueryBuilder).build();
//    }
}
