package com.itxiaobai.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Autowired
	private Environment environment;
	
	@Value("${name}")
	private String name;
	
	@Value("${url}")
	private String url;
	
	//响应格式为json格式:http://localhost:8080/hello
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		
		System.out.println(environment.getProperty("name"));
		System.out.println(environment.getProperty("url"));
		System.out.println(name);
		System.out.println(url);
		
		return "Hello World";
	}
	
	//响应数据为静态HTML页面: http://localhost:8080/user
	
	@GetMapping("/user")
	public String user() {
		return "/html/user.html";
	}
}
