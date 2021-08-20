package com.study.springboot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController
public class MyController {
	
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
	

		@RequestMapping("/gradle")
		@ResponseBody
		public String root() {
			return "Jsp in Gradle";
		}
		
		@RequestMapping("/list")
		@ResponseBody
		public List<String> doList() {
			
			List<String> list = new ArrayList<>();
					
		    list.add("a");
			list.add("b");
			list.add("c");
			list.add("d");
			
			return list;
		}
		
		@RequestMapping("/listhash")
		@ResponseBody
		public List<Map<String,String>> doListHash() {
			
			List<Map<String,String>> list = new ArrayList<>();
			
			Map<String, String> map = new HashMap<>();
			
			map.put("1","a");
			map.put("2","b");			
		    list.add(map);
		    
		    map.clear();
		    
		    map.put("1","a");
			map.put("2","b");			
		    list.add(map);
		    
		    map.clear();
		    
		    map.put("1","a");
			map.put("2","b");			
		    list.add(map);		    		    
			
			return list;
		}		
	
}
