package com.example.demo.proxy.observer;

import java.util.ArrayList;
import java.util.List;

public class Beauty {

    List<People> list = new ArrayList<>();

    public void addPeople(People people){
        list.add(people);
    }

    public void notifyPeople(){
       list.forEach((e)->e.getMessage("你们过来吧，谁先过来谁就能陪我一起玩儿游戏!"));
    }


}
