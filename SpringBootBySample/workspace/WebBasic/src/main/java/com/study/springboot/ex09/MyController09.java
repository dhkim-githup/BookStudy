package com.study.springboot.ex09;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController09 {

	@RequestMapping("/ex09")
	public @ResponseBody String doEx09() {
		System.out.println("ex09");
		return "ex09 , Validator";
	}
	
	@RequestMapping("/ex09/insertForm")
	public String doInsert() {
		System.out.println("ex09");
		return "ex09/createPage";
	}
	

	@RequestMapping("/ex09/create")
	public String doCreated(@ModelAttribute("dto") ContentDto contentDto, 
			                BindingResult result) {
		System.out.println("ex09");
		
		String page ="ex09/createDonePage";
		System.out.println("contentDto");
		
		ContentValidator validator = new ContentValidator();
		validator.validate(contentDto, result);
		if(result.hasErrors()) {
			page = "ex09/createPage";
		}
		
		
		return page;
	}
	
	
	
}
