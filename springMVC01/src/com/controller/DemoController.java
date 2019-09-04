package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	@RequestMapping("demo")
	public String demo() {
		System.out.println("Ö´ÐÐdemo");
		return "/main.jsp";
	}
}
