package com.example.demo.contorller;

import com.example.demo.excel.ExcelImport;
import com.example.demo.excel.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/c1")
public class Controller1 {

    @Autowired
    private ExcelImport excelService;

    @GetMapping("/m2/{token}")
    public String m2(HttpServletResponse response, @PathVariable String token) {
        response.setHeader("token", token);
        return new String("my task！");
    }

    @GetMapping("/m3")
    public List<Student> m3() {
        String file = "D:" + File.separator + "123.xlsx";
        return excelService.importData(file);
    }

    @GetMapping("/m4")
    public Map<String, String> m4(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        Map<String, String> map = new HashMap<>();
        map.put("uri", uri);
        map.put("url", url);
        return map;
    }

}
