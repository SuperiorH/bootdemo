package com.example.demo;

import com.example.demo.jpa.entity.UseBuyerCollect;
import com.example.demo.jpa.repository.UseBuyerCollectRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class DemoApplicationTests {

	private  final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Autowired
	UseBuyerCollectRepository repository;

	@Test
	public void test() {
		List<UseBuyerCollect> list = repository.findByUserId("1");
		System.out.println("*********");
		list.forEach(System.out::println);
		System.out.println("*********");
	}

	@Test
	public  void test1(){
		System.out.println("*******************************");
		logger.debug("debug message");
		logger.warn("warn message");
		logger.info("info message");
		logger.error("error message");
		logger.trace("trace message");
		System.out.println("*******************************");
	}

	@Test
	public void test2(){
		System.out.println("*******************************");
		log.info("debug message");
		log.warn("warn message");
		log.info("info message");
		log.error("error message");
		log.info("trace message");
		System.out.println("*******************************");
	}
}
