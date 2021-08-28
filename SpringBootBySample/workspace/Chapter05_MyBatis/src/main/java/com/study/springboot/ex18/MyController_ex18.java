package com.study.springboot.ex18;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.ex18.dao.ISimpleBbsDao_ex18;



@Controller
@RequestMapping("/ex18")
public class MyController_ex18 {

    @Autowired
    ISimpleBbsDao_ex18 dao;

    @RequestMapping("/")
    public String root() throws Exception{
        // MyBatis : SimpleBBS
        return "redirect:/ex18/list";
    }

    @RequestMapping("/list")
    public String userlistPage(Model model) {
        model.addAttribute("list", dao.listDao());
        
        int iCount = dao.articleCount();
        System.out.println("userlistPage Count : "+ iCount);
        
        return "ex18/list";
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
        model.addAttribute("dto", dao.viewDao(sId));
        return "ex18/view";
    }
    
    @RequestMapping("/writeForm")
    public String writeForm() {
        
        return "ex18/writeForm";
    }
    
    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {
        String sName  = request.getParameter("writer");
        String sTitle = request.getParameter("title");
        String sContent = request.getParameter("content");
        
        Map<String, String> map = new HashMap<String, String>();
        	map.put("param1", sName);
        	map.put("param2", sTitle);
        	map.put("param3", sContent);
        
        int nResult = dao.writeDao(map);
        System.out.println("write nResult =>" +nResult);
        
        return "redirect:/ex18/list";
    }
    
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        
    	int nResult = dao.deleteDao(request.getParameter("id"));
    	System.out.println("delete nResult =>" +nResult);
    	
        return "redirect:/ex18/list";
    }

}
