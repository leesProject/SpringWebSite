package com.in.team2.controller.admin;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.in.team2.service.admin.AdminService;
import com.in.team2.vo.UserVO;

@Scope("prototype")
@Controller("Test")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	
	@RequestMapping(value = "/fileUploadTest")
	public ModelAndView showList(HttpServletRequest pararequest,HttpServletResponse response/*,@RequestParam(required=true) CommonsMultipartFile parafileName*/){
		
		MultipartHttpServletRequest reuqest=(MultipartHttpServletRequest)pararequest;
		Iterator<String> iter = reuqest.getFileNames();
		MultipartFile file=null;
		System.out.println("실제 경로: "+pararequest.getRealPath(""));
		while(iter.hasNext()){
			String fileName = iter.next();
			System.out.println("파일 이름은: "+fileName);
			System.out.println("실제 경로: "+pararequest.getRealPath(""));
			file=reuqest.getFile(fileName);
			File getFile = new File(pararequest.getRealPath("")+fileName+".jpg");
			try{
				file.transferTo(getFile);				
			}catch(Exception e){System.out.println(e);}	
		}
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("home");
		return mav;
	}
	
	
	
	@RequestMapping(value = "/Admin_showList")
	public ModelAndView showList(@RequestParam(required = true) int pageNum, int numbs){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("userList",adminService.showList(pageNum, numbs));
		mav.setViewName("A_USER_LIST");
		return mav;
	}
	
				
	@RequestMapping(value = "/Admin_showDetail")
	public ModelAndView showDetail(UserVO user){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("user",adminService.showDetail(user));
		mav.setViewName("A_USER_DETAIL");
		return mav;
	}
	
	@RequestMapping(value = "/Admin_modify")
	public ModelAndView modify(UserVO user){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("user",adminService.modify(user));
		mav.setViewName("A_USER_DETAIL");
		return mav;
	}
	
	@RequestMapping(value = "/Admin_delete")
	public ModelAndView delete(UserVO user){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("user",adminService.delete(user));
		mav.setViewName("A_USER_LIST");
		return mav;
	}
	
	
	
}