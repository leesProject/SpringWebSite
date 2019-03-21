package com.in.team2.controller.post;



import java.io.File;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.soap.Detail;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.in.team2.controller.annotation.LogInCheck;
import com.in.team2.service.post.PostService;
import com.in.team2.vo.CommentVO;
import com.in.team2.vo.PostVO;


@Scope("prototype")
@Controller
public class SPostController {
	//1. service로 넘어감
	@Autowired
	private PostService sPostService;
		
//판매게시판 전체리스트 보기
	
	@RequestMapping(value = "/S_post_showList")//요청받은 url주소
	public ModelAndView showList(PostVO post){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("postList",sPostService.showList(post));//addObject(어트리뷰트이름,어트리뷰트밸류) view에서 가져올수있음
		mav.setViewName("post/spost/p_spost");//넘어갈 화면 주소
		return mav;
	}

//특정유저가 등록한 판매글 리스트 보기
	@LogInCheck
	@RequestMapping(value = "/S_post_showMySellList")
	public ModelAndView showMySellList(HttpServletRequest request, PostVO post){
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		post.setUserId(userId);
		
		System.out.println(post.getUserId());
		
		ModelAndView mav = new ModelAndView();		
		mav.addObject("postMySellList",sPostService.showMySellList(post));
		mav.setViewName("mylist/l_mylist_spost");
		return mav;
	}
	
	
	
//검색해야 하는데..뺄 예정
	@RequestMapping(value = "/S_post_searchList")
	public ModelAndView searchList(@RequestParam(required = true) int pageNum,int numbs, String category, String search){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("postList",sPostService.searchList(pageNum, numbs, category, search));
		mav.setViewName("P_SPOST");
		return mav;
	}

//게시글 상세보기
	@RequestMapping(value = "/S_post_showDetail")
	public ModelAndView showDetail(@RequestParam(required=false)String myListError, PostVO post){
		ModelAndView mav = new ModelAndView();
		mav.addObject("detail",sPostService.showDetail(post));
		if(myListError!=null && !myListError.equals("")) {
			mav.addObject("myListError",myListError);
		}
		mav.setViewName("post/spost/p_spost_detail");
		return mav;
	}
	
//게시글 생성
	@LogInCheck
	@RequestMapping(value = "/S_post_createPost" ,method=RequestMethod.POST)
	public ModelAndView create(HttpServletRequest request, HttpServletResponse res,PostVO post){
		ModelAndView mav = null;
		MultipartRequest multiRequest = (MultipartRequest)request;
		MultipartFile file = multiRequest.getFile("fileName");
				
		String savedFileName=post.getPostPhoto().split("\\\\")[post.getPostPhoto().split("\\\\").length-1];
		post.setPostPhoto(savedFileName);
		
		sPostService.create(post);
		
		try {
			file.transferTo(new File(request.getRealPath("/")+savedFileName));			
			mav= new ModelAndView("redirect:/action/S_post_showList");
			return mav;
		}catch(Exception e) {
			System.out.println("ERROR in create, sPostController "+e);
			return null;
		}
		
	}
	
//게시글 수정전 화면 보기 
	@LogInCheck
	@RequestMapping(value = "/l_spost_UpdateView")
	public ModelAndView showDetailModify(PostVO post){
		ModelAndView mav = new ModelAndView();	
		mav.addObject("detail",sPostService.showDetail(post));
		mav.setViewName("post/spost/l_spost_update");
		return mav;
	}
	
//게시글 수정
	@LogInCheck
	@RequestMapping(value = "/l_spost_update",method=RequestMethod.POST)
	public ModelAndView modify(HttpServletRequest request, HttpServletResponse res,PostVO post){
		
		ModelAndView mav = null;
		MultipartRequest multiRequest = (MultipartRequest)request;
		MultipartFile file = multiRequest.getFile("fileName");
				
		String savedFileName=post.getPostPhoto().split("\\\\")[post.getPostPhoto().split("\\\\").length-1];
		post.setPostPhoto(savedFileName);
		
		sPostService.modify(post);
		
		try {
			file.transferTo(new File(request.getRealPath("/")+savedFileName));			
			mav= new ModelAndView("redirect:/action/S_post_showList");
			return mav;
		}catch(Exception e) {
			System.out.println("ERROR in create, sPostController "+e);
			return null;
		}

	}
	
//게시글 삭제
	@LogInCheck
	@RequestMapping(value = "/S_post_deletePost",method=RequestMethod.POST)
	public ModelAndView delete(HttpServletResponse res,PostVO post){
		
		ModelAndView mav = new ModelAndView();		
		mav.addObject("post",sPostService.delete(post));
		try {
			res.sendRedirect("/action/S_post_showList");			
		}catch(Exception e) {
			
		}
		
		return null;
	}
	
	
	
//댓글 생성
	@LogInCheck
	@RequestMapping(value = "/S_post_createComment", method=RequestMethod.POST)
	public ModelAndView addComment(HttpServletResponse res,CommentVO comment){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("comment",sPostService.addComment(comment));		
		
		try {
			res.sendRedirect("/action/S_post_showDetail?postNum="+comment.getPostNum());			
		}catch(Exception e) {
			
		}
		
		return null;
	}
	
//댓글 수정
	@LogInCheck
	@RequestMapping(value = "/S_post_modifyComment", method=RequestMethod.POST)
	public ModelAndView modifyComment(HttpServletResponse res, CommentVO comment, PostVO post){
		ModelAndView mav = new ModelAndView();		
		mav.addObject("comment",sPostService.modifyComment(comment, post));
		try {
			res.sendRedirect("/action/S_post_showDetail?postNum="+comment.getPostNum());			
		}catch(Exception e) {
			
		}
		
		return null;
	}
	
//댓글 삭제
	@LogInCheck
	@RequestMapping(value = "/S_post_deleteComment",method=RequestMethod.POST)
	public ModelAndView deleteComment(HttpServletResponse res,CommentVO comment){
		ModelAndView mav = new ModelAndView();	
		
		mav.addObject("comment",sPostService.deleteComment(comment));
		try {
			res.sendRedirect("/action/S_post_showDetail?postNum="+comment.getPostNum());			
		}catch(Exception e) {
			
		}
		
		return null;
		
	}
	
	
	
}
