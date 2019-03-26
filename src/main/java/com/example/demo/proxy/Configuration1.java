package com.example.demo.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.demo.proxy")
public class Configuration1 {

    @Bean
    @Scope("prototype")
    public A a() {
        A a = new A();
        a.setB(b());
        return a;
    }

    @Bean
    @Scope("prototype")
    public B b() {
        B b = new B();
        b.setC(c());
        return b;
    }

    @Bean
    @Scope("prototype")
    public C c() {
        C c = new C();
//        c.setA(a());
        return c;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Configuration1.class);
        System.out.println(ac);
        D d1 = ac.getBean("d1", D.class);
        D d2 = ac.getBean("d1", D.class);
        System.out.println(d1 == d2);
    }

}
