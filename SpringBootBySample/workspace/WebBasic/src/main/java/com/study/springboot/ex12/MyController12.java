package com.study.springboot.ex12;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController12 {

    @RequestMapping("/ex12")
    public @ResponseBody String root() throws Exception{
        return "Valid_Annotation (4)";
    }

    @RequestMapping("/ex12/insertForm")
    public String insert1() {

        return "ex09/createPage";       
    }
     
    @RequestMapping("/ex12/create")
    public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto,
            BindingResult result)
	{
		String page = "ex09/createDonePage";
		System.out.println(contentDto);

		
		if (result.hasErrors()) {
		
			if (result.getFieldError("writer") != null) {
			  System.out.println("1:"+result.getFieldError("writer").getDefaultMessage());
			}
			if (result.getFieldError("content") != null) {
			  System.out.println("2:"+result.getFieldError("content").getDefaultMessage());
			}
		
			page = "ex09/createPage";
		}
		
		
		return page;       
	}
  
    
}
