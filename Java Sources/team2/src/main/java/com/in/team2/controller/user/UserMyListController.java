package com.in.team2.controller.user;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.in.team2.controller.annotation.LogInCheck;
import com.in.team2.service.user.UserMyListService;
import com.in.team2.vo.AuctionVO;
import com.in.team2.vo.PostVO;

@Controller
@Scope("prototype")
public class UserMyListController {

	@Autowired
	private UserMyListService userMyListService;
	//관심상품 리스트 출력
	
	@LogInCheck
	@RequestMapping(value = "/User_showMyList")
	public ModelAndView showMyList(HttpSession session){
		
		ModelAndView mav = new ModelAndView();		
		PostVO post = new PostVO();
		post.setUserId((String)session.getAttribute("userId"));
		
		mav.addObject("myListList",userMyListService.showMyList(post));
		mav.setViewName("mylist/l_mylist_int");
		
		return mav;
	}
	//관심상품 등록하기
	
	@LogInCheck
	@RequestMapping(value = "/User_addMyList",method=RequestMethod.POST)
	public ModelAndView addMyList(HttpServletRequest request, HttpServletResponse res, AuctionVO auction){
		
		//AuctionVO의 BuyerId안에 session의 userId값 집어넣기
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		auction.setBuyerId(userId);
		
		
		ModelAndView mav = new ModelAndView();		
		int result = userMyListService.addMyList(auction);
	
		try {
			if(result==1) {//정상적인 관심상품 등록후 이동
				mav= new ModelAndView("redirect:/action/S_post_showDetail?postNum="+auction.getPostNum());
				return mav;
			}
			else if (result==-1) {//관심상품 중복등록되었을때 이동
				mav= new ModelAndView("redirect:/action/S_post_showDetail?postNum="+auction.getPostNum()+"&myListError="+URLEncoder.encode("이미 등록된 상품입니다.", "utf-8"));
				return mav;
			}
			
		}catch(Exception e) {
			System.out.println("ERROR in addMyList, UserMyListController "+e);
			
		}
		return null;
	}
	
	//관심상품 삭제
	@LogInCheck
	@RequestMapping(value = "/User_deleteMyList",method=RequestMethod.POST)
	public ModelAndView deleteMyList(HttpServletRequest request,HttpServletResponse res, AuctionVO auction){
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		auction.setBuyerId(userId);
		
		ModelAndView mav = new ModelAndView();		
		mav.addObject("myListList",userMyListService.deleteMyList(auction));
		try {			
			res.sendRedirect("/action/User_showMyList");
		}catch(Exception e) {
			System.out.println("ERROR in deleteMyList, UserMyListController "+e);
		}
		return null;
	}	
}
