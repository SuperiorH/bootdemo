package com.example.demo.designpattern.strategy;

import java.util.HashMap;
import java.util.Map;

public class Context {
    public static Map<String, Strategy> map = new HashMap<>();

    static {
        map.put("bus", new StrategyImpl1());
        map.put("subway", new StrategyImpl2());
        map.put("bike", new StrategyImpl3());
    }

    private String type;

    public Context(String type) {
        this.type = type;
    }

    public void selectResult() {
        Strategy strategy = map.get(type);
        strategy.select();
    }

}
