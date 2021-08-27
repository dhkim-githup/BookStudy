package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.MyUserDAO;
import com.study.springboot.jdbc.MyUserDTO;

@Controller
public class MyControllerEx13 {

	@Autowired
	private MyUserDAO userDao;
	
	@RequestMapping("/ex13")
	public @ResponseBody String root04() {
		return "JdbcTemplate 사용하기";
	}
	
	//@GetMapping("/ch04/user")
	@RequestMapping(value="/ex13/user", method = RequestMethod.GET)
	public String userListPage(Model model) {
		
		model.addAttribute("users",userDao.list());
		
		return "ex13/userlist";
	}
	
}
