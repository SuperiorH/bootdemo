package com.example.demo.util;

import java.io.File;

public class ExcelUtil {

    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    public static void main(String[] args) {
        String path1 = "D:" + File.separator + "123.xlsx";
        String path2 = "D:" + File.separator + "1234.xlsx";
        File file1 = new File(path1);
        File file2 = new File(path2);
        System.out.println(file1.exists());
        System.out.println(file2.exists());
        System.out.println("**********分割线************");
        System.out.println(isExcel2003(path1));
        System.out.println(isExcel2007(path1));

    }

}
