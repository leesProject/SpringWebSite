package com.in.team2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.in.team2.dao.TestDAO;

@Controller
@Scope("prototype")
public class TestController {
	@Autowired
	TestDAO testDAO;
	
	@RequestMapping("/testInsert")
	public void testInsert(){
		testDAO.testInsert();		
	}
	
	@RequestMapping("/selectTest")
	public void selectTest(String itemName, String itemCategory){
		/*System.out.println(itemCategory+"사의 "+itemName);*/
	}
	
}
