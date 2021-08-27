package com.study.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.ISimpleBbsDao;

@Controller
public class MyControllerEx14 {

	@Autowired
    ISimpleBbsDao dao;

    @RequestMapping("/ex14")
    public String root() throws Exception{
        // JdbcTemplate : SimpleBBS
    	// /ex14가 오면 /ex14/list 컨트롤러를 호출한다.
        return "redirect:/ex14/list";
    }

    @RequestMapping("/ex14/list")
    public String userlistPage(Model model) {
        model.addAttribute("list", dao.listDao());
        return "ex14/list";
    }

    @RequestMapping("/ex14/view")
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
        model.addAttribute("dto", dao.viewDao(sId));
        return "ex14/view";
    }
    
    @RequestMapping("/ex14/writeForm")
    public String writeForm() {
        
        return "ex14/writeForm";
    }
    
    @RequestMapping("/ex14/write")
    public String write(Model model, HttpServletRequest request) {
        dao.writeDao(request.getParameter("writer"),
                     request.getParameter("title"),
                     request.getParameter("content"));
        
         // /ex14/write - 글작성을 마치면, 리스트 컨트롤러를 호출하여 리스트를 보이도록 한다.
        return "redirect:/ex14/list";
    }
    
    @RequestMapping("/ex14/delete")
    public String delete(HttpServletRequest request, Model model) {
        dao.deleteDao(request.getParameter("id"));
        // /ex14/delete - 해당 글을 삭제하면, 리스트 컨트롤러를 호출하여 리스트를 보이도록 한다.
        return "redirect:/ex14/list";
    }
	
}
