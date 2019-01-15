package com.example.demo.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.UUID;

@Configuration
public class DemoConfig {

    @Bean
    @Profile("dev")
    public DemoBean bean1() {
        return new DemoBean("bean1");
    }

    @Bean
    @Profile("!dev")
    public DemoBean bean2() {
        return new DemoBean("bean2");
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoBean db = ac.getBean(DemoBean.class);
        System.out.println(db);
//        ac.getEnvironment().setActiveProfiles("dev");
//        ac.register(DemoConfig.class);
//        ac.refresh();
//        DemoBean bean = ac.getBean(DemoBean.class);
//        System.out.println(bean);
        System.out.println(UUID.randomUUID());
    }

}
