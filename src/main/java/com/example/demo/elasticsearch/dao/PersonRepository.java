package com.example.demo.elasticsearch.dao;

import com.example.demo.elasticsearch.entity.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ElasticsearchCrudRepository<Person,String> {
}
