package com.study.springboot.ex06;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyControllerEx06 {

	@RequestMapping("/ex06")
	public @ResponseBody String doEx06() {
		return "Model & View";
	}
	
	@RequestMapping("/ex06/test1")
	public String doTest1(Model model) {
		// Model 객체를 이용해서, View로 Data 전달
		model.addAttribute("name","홍길동");
		
		return "ex06/test1";		
	}
	
	@RequestMapping("/ex06/mv")
	public ModelAndView doTest2(Model model) {
		// 데이터와 뷰를 동시에 설정 
		ModelAndView mv = new ModelAndView();
		
		List<String> lists = new ArrayList<>();
		lists.add("test1");
		lists.add("test2");
		lists.add("test3");
		
		mv.addObject("lists",lists);
		mv.addObject("ObjectTest","테스트입니다.");
		mv.addObject("name","홍길동.");
		
		mv.setViewName("/ex06/myView");
		
		
		model.addAttribute("name","홍길동");
		
		return mv;		
	}
	
	
}
