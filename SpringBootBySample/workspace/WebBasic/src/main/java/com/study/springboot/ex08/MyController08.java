package com.study.springboot.ex08;

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
public class MyController08 {

	@RequestMapping("/ex08")
	public @ResponseBody String doEx06() {
		System.out.println("ex08");
		return "ex08 , Lombok 사용히기";
	}
	
	
	@RequestMapping("/ex08/test3")
	public String doTest3(Member08 member, Model model) {
		System.out.println("ex08");
		// 파라미터와 일치하는 빈을 만들어서 사용할 수 있다.
		// View 페이지에서 model을 사용하지 않고 member를 사용한다.
				
		return "ex08/test3";		
	}
	
}
