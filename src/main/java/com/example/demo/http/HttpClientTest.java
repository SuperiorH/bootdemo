package com.example.demo.http;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.elasticsearch.entity.Person;

public class HttpClientTest {
    public static void main(String[] args) {
//        String url = "http://www.baidu.com";
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(url);
//        HttpResponse response = httpClient.execute(httpGet);
//        HttpEntity entity = response.getEntity();
//        byte[] bytes = EntityUtils.toByteArray(entity);
//        String result = new String(bytes,"utf8");
//        System.out.println("***开始***");
//        System.out.println(result);
//        System.out.println("***结束***");
        System.out.println("...........");
        Person p = new Person("1", "Joe","Java开发","开发工程师");
        Object obj = JSONObject.toJSON(p);
        String str = JSONObject.toJSONString(p);
        System.out.println(obj);
        System.out.println(str);
        Person pp = JSONObject.parseObject(str,Person.class);
        System.out.println(pp);
        System.out.println("...........");
    }

}
