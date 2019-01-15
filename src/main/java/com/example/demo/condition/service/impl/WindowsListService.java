package com.example.demo.condition.service.impl;

import com.example.demo.condition.service.ListService;

public class WindowsListService implements ListService{
    @Override
    public String showListCmd() {
        return "dir";
    }
}
