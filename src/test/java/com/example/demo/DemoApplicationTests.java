package com.example.demo;

import com.example.demo.jpa.entity.UseBuyerCollect;
import com.example.demo.jpa.repository.UseBuyerCollectRepository;
import com.example.demo.mongo.dao.UserDao;
import com.example.demo.mongo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {


	@Autowired
	UseBuyerCollectRepository repository;

	@Test
	public void test() {
		List<UseBuyerCollect> list  = repository.findByUserId("1");
		System.out.println("*********");
		list.forEach(System.out::println);
		System.out.println("*********");
	}

}
