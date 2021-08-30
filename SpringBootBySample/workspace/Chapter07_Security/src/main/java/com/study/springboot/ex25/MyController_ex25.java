package com.study.springboot.ex25;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex25")
public class MyController_ex25 {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "Security (1)";
    }

    @RequestMapping("/guest/welcome")
    public String welcome1() {

        return "guest/welcome1";
    }
    
    @RequestMapping("/member/welcome")
    public String welcome2() {

        return "member/welcome2";
    }
    
    @RequestMapping("/admin/welcome")
    public String welcome3() {
        
        return "admin/welcome3";
    }

}
