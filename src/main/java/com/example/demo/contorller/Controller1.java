package com.example.demo.contorller;

import com.example.demo.excel.ExcelImport;
import com.example.demo.excel.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/c1")
@Slf4j
public class Controller1 {

    @Autowired
    private ExcelImport excelService;

    @GetMapping("/m2/{token}")
    @ResponseBody
    public String m2(HttpServletResponse response, @PathVariable String token) {
        response.setHeader("token", token);
        return new String("my task！");
    }

    @GetMapping("/m3")
    @ResponseBody
    public List<Student> m3() {
        String file = "D:" + File.separator + "123.xlsx";
        return excelService.importData(file);
    }

    @GetMapping("/m4")
    @ResponseBody
    public Map<String, String> m4(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
//        String uri = request.getRequestURI();
//        String url = request.getRequestURL().toString();
//        map.put("uri", uri);
//        map.put("url", url);
        Cookie[] cookies = request.getCookies();
        Arrays.stream(cookies).forEach((e) ->
            map.put(e.getName(), e.getValue())
        );
        map.put("liuwei","dog");
        return map;
    }

    @GetMapping("/m5")
//    @ResponseBody
    public String m5(HttpServletResponse response) {
        Cookie cookie1 = new Cookie("c1", "m1");
        Cookie cookie2 = new Cookie("c2", "m2");
        Cookie cookie3 = new Cookie("c3", "m3");
        cookie1.setMaxAge(10);
        cookie2.setMaxAge(20);
        cookie3.setMaxAge(30);
        cookie1.setHttpOnly(true);
        cookie2.setHttpOnly(true);
        cookie3.setHttpOnly(true);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        return "m4";
    }

}
