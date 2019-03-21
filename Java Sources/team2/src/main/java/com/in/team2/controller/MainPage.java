package com.in.team2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Scope("prototype")
public class MainPage {
	
	
	
	@RequestMapping(value = "/main")
	public ModelAndView  getMain(HttpServletRequest request, HttpServletResponse response){		
		ModelAndView mav = new ModelAndView();
		
		if(request.getSession().getAttribute("userId")==null){
			/*request.getSession().setAttribute("userId", "N.회원"+UserNumber.getUserNum());*/
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10*60);
		}
		
		mav.setViewName("main/p_main");
		return mav;
	}
	
	
	
	/*@RequestMapping(value = "/main")
	public ModelAndView  getMain(HttpServletRequest request, HttpServletResponse response){
		
		request.getSession().setAttribute("userId", "그냥 회원");
		RequestDispatcher rd = request.getRequestDispatcher("/action/main2");
		try{
			rd.forward(request, response);			
		}catch(Exception e){}
		
		return null;
	}*/
	
	/*@RequestMapping(value = "/main2")
	public ModelAndView getMain2(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/p_main");
		return mav;
	}*/
	
}
