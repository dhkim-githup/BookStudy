package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

		@RequestMapping("/gradle")
		public @ResponseBody String root() {
			return "Jsp in Gradle";
		}
		
		@RequestMapping("/test1")
		public String test1() {
			System.out.println("test1");
			return "test1";
		}
	
		@RequestMapping("/test2")
		public String test2() {
			System.out.println("test2");
			return "sub/test2";
		}
		
}
