package com.in.team2.controller.user;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.in.team2.service.user.UserHistoryService;

@Scope("prototype")
@Controller
public class UserHistoryController {
	@Autowired
	private UserHistoryService userHistoryService;
	
	
	@RequestMapping(value = "/User_showSHistory")
	public ModelAndView showSellHistory(@RequestParam(required = true) String userId,int pageNum, int numbs){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("history",userHistoryService.showSellHistory(userId,pageNum, numbs));
		mav.setViewName("L_SHISTORY");
		return mav;
	}
	
	@RequestMapping(value = "/User_showBHistory")
	public ModelAndView showBuyHistory(@RequestParam(required = true) String userId,int pageNum, int numbs){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("history",userHistoryService.showBuyHistory(userId,pageNum, numbs));
		mav.setViewName("L_BHISTORY");
		return mav;
	}
	
	@RequestMapping(value = "/User_searchSHistory")
	public ModelAndView searchSellHistory(@RequestParam(required = true) String userId, Timestamp startDate, Timestamp endDate, int pageNum, int numbs){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("history",userHistoryService.searchSellHistory(userId, startDate, endDate, pageNum, numbs));
		mav.setViewName("L_SHISTORY");
		return mav;
	}
	
	@RequestMapping(value = "/User_searchBHistory")
	public ModelAndView searchBuyHistory(@RequestParam(required = true) String userId, Timestamp startDate, Timestamp endDate, int pageNum, int numbs){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("history",userHistoryService.searchBuyHistory(userId, startDate, endDate, pageNum, numbs));
		mav.setViewName("L_BHISTORY");
		return mav;
	}
	
}
