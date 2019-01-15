package com.example.demo.excel;

import com.example.demo.excel.entity.Student;

import java.util.List;

public interface ExcelImport {
    List<Student> importData(String file);
}
