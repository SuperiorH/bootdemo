package com.example.demo.condition.configuration;

import com.example.demo.condition.LinuxCondition;
import com.example.demo.condition.WindowsCondition;
import com.example.demo.condition.service.ListService;
import com.example.demo.condition.service.impl.LinuxListService;
import com.example.demo.condition.service.impl.WindowsListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfiguration {

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windows() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxs() {
        return new LinuxListService();
    }

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ConditionConfiguration.class);
        System.out.println(ac);
        ListService ls = ac.getBean(ListService.class);
        String str = ls.showListCmd();
        System.out.println(str);
        System.out.println(ac.getEnvironment().getProperty("os.name"));

    }


}
