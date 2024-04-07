package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
	
	@Value("${dbservername}") private String dbservername;
	  
	@Value("${dbserveruserid}") private String dbserveruserid;
	  
	@GetMapping("/{name}") 
	public @ResponseBody String helloUser(@PathVariable String name) { 
	  System.out.println(dbservername);
	  System.out.println(dbserveruserid); return "Hello,welcome" + name;
	  
	}
	 
	@GetMapping("/helloworld")
	public @ResponseBody String helloworld() {
		return "Hello java spring boot";
	}
}
