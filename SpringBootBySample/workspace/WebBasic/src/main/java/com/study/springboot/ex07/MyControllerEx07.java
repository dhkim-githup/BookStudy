package com.study.springboot.ex07;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyControllerEx07 {

	@RequestMapping("/ex07")
	public @ResponseBody String doEx06() {
		return "ex07 , Form 데이타 전달받아 사용히기";
	}
	
	@RequestMapping("/ex07/test1")
	public String doTest1(HttpServletRequest request, Model model) {
		
		String strId = request.getParameter("id");
		String strName = request.getParameter("name");
		
		
		// Model 객체를 이용해서, View로 Data 전달
		model.addAttribute("id", strId);
		model.addAttribute("name", strName);
		
		
		return "ex07/test1";		
	}
	
	@RequestMapping("/ex07/test2")
	public String doTest2(@RequestParam("id") String strId,
						  @RequestParam("name") String strName,
						  Model model) {
		
				
		// Model 객체를 이용해서, View로 Data 전달
		model.addAttribute("id", strId);
		model.addAttribute("name", strName);
				
		return "ex07/test2";		
	}
	
	@RequestMapping("/ex07/test3")
	public String doTest3(Member member, Model model) {
		// 파라미터와 일치하는 빈을 만들어서 사용할 수 있다.
		// View 페이지에서 model을 사용하지 않고 member를 사용한다.
				
		return "ex07/test3";		
	}
	
	@RequestMapping("/ex07/test4/{studentId}/{name}")
	public String doTest4(@PathVariable String studentId,
						  @PathVariable String name,
						  Model model) {
		
				
		// Model 객체를 이용해서, View로 Data 전달
		model.addAttribute("id", studentId);
		model.addAttribute("name", name);
				
		return "ex07/test4";		
	}
	
}
