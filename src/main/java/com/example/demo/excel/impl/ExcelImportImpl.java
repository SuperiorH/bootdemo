package com.example.demo.excel.impl;

import com.example.demo.excel.ExcelImport;
import com.example.demo.excel.entity.Student;
import com.example.demo.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelImportImpl implements ExcelImport {

    @Override
    public List<Student> importData(String file) {
        Workbook wb;
        List<Student> list = new ArrayList();
        try {
            if (ExcelUtil.isExcel2007(file)) {
                wb = new XSSFWorkbook(new FileInputStream(file));
            } else {
                wb = new HSSFWorkbook(new FileInputStream(file));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Sheet sheet = wb.getSheetAt(0);//获取第一张表
        int sumRows = sheet.getLastRowNum();
        for (int i = 1; i < sumRows; i++) {
            Row row = sheet.getRow(i);//获取索引为i的行，以0开始
            Cell cell0 = row.getCell(0);
            Cell cell1 = row.getCell(1);
            Cell cell2 = row.getCell(2);
            if (null == cell0 && null == cell1 && null == cell2) {
                break;
            }
            String name = getStrByCell(cell0);//获取第i行的索引为0的单元格数据
            Integer age = cell1 == null ? null : (int) (cell1.getNumericCellValue());
            String $class = getStrByCell(cell2);
            Student stu = new Student();
            stu.setName(name);
            stu.setAge(age);
            stu.setClasses($class);
            list.add(stu);
        }
        return list;
    }

    private String getStrByCell(Cell cell) {
        if (null == cell) {
            return null;
        }
        return cell.getStringCellValue();
    }

}
