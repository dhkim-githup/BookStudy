package com.study.springboot.ex15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.ex15.jdbc.IMyUserDao;

@Controller
@RequestMapping("/ex15")
public class Controller_ex15 {
	
	@Autowired
	private IMyUserDao userDao;
	
	@RequestMapping("/")
	public @ResponseBody String doRoot() {
		return "MyBatis ex15";
	}
	
	@RequestMapping("/user")
	public String userListPage(Model model) {
		model.addAttribute("users",userDao.list());
		return "ex15/userList";
	}
	

}
