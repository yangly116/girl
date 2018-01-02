package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/girl")
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;
    @Autowired
    private GirlProperties girlProperties;
    //@RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    @GetMapping(value = "/hello/{id}")
    public String say(@PathVariable("id") Integer id,@RequestParam(value = "age" , required = false , defaultValue = "20") Integer age){
        return  "id：" + id+",age："+age;
       // return  girlProperties.getCupSize();
    }
    @RequestMapping(value = {"/hello2","hi"},method = RequestMethod.GET)
    public String hi(){
        return  girlProperties.getCupSize();
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return  "index";
    }
}
