package com.study.springboot.ex10;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController10 {

    @RequestMapping("/ex10")
    public @ResponseBody String root() throws Exception{
        return "ValidationUtils (2)";
    }

    @RequestMapping("/ex10/insertForm")
    public String insert1() {

        return "ex09/createPage";       
    }
     
    @RequestMapping("/ex10/create")
    public String insert2(@ModelAttribute("dto") ContentDto contentDto,
                          BindingResult result)
    {
        String page = "ex09/createDonePage";
        System.out.println(contentDto);
        
        ContentValidator validator = new ContentValidator();
        validator.validate(contentDto, result);
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
}
