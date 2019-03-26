package com.example.demo.proxy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("d1")
//@Scope("prototype")
@Scope("singleton")
public class D {

}
