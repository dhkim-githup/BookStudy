package com.study.springboot.ex11;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController11 {

    @RequestMapping("/ex11")
    public @ResponseBody String root() throws Exception{
        return "Valid_initBinder (3)";
    }

    @RequestMapping("/ex11/insertForm")
    public String insert1() {

        return "ex09/createPage";       
    }
     
    @RequestMapping("/ex11/create")
    public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto,
                          BindingResult result)
    {
        String page = "ex09/createDonePage";
        System.out.println(contentDto);
        
        //ContentValidator validator = new ContentValidator();
        //validator.validate(contentDto, result);
        if (result.hasErrors()) {
            System.out.println("getAllErros : " + result.getAllErrors());
            
            if (result.getFieldError("writer") != null) {
                System.out.println("1:"+result.getFieldError("writer").getCode());
            }
            if (result.getFieldError("content") != null) {
                System.out.println("2:"+result.getFieldError("content").getCode());
            }
            
            page = "ex09/createPage";
        }
        
        return page;       
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    	binder.setValidator(new ContentValidator());		
	}
    
}
