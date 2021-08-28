package com.study.springboot.ex20;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.ex20.service.ISimpleBbsService_ex20;


@Controller
@RequestMapping("/ex20")
public class MyController_ex20 {

//    @Autowired
//    ISimpleBbsDao dao;
    
    @Autowired
    ISimpleBbsService_ex20 bbs;

    @RequestMapping("/")
    public String root() throws Exception{
        // Service vs DAO
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String userlistPage(Model model) {
//        model.addAttribute("list", dao.listDao());
        model.addAttribute("list", bbs.list());
        
        int nTotalCount = bbs.count();
        System.out.println("Count : " + nTotalCount);
        
        return "ex20/list";
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
        model.addAttribute("dto", bbs.view(sId));

        return "ex20/view";
    }
    
    @RequestMapping("/writeForm")
    public String writeForm() {
        
        return "ex20/writeForm";
    }
    
    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {
        
        String sName = request.getParameter("writer");
        String sTitle = request.getParameter("title");
        String sContent = request.getParameter("content");
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("item1", sName);
        map.put("item2", sTitle);
        map.put("item3", sContent);
        
        int nResult = bbs.write(map);
        System.out.println("Write : " + nResult);

        return "redirect:list";
    }
    
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
        int nResult = bbs.delete(sId);
        System.out.println("Delete : " + nResult);

        return "redirect:list";
    }

}
