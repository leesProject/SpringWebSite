package com.in.team2.controller.auction;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.in.team2.controller.annotation.LogInCheck;
import com.in.team2.service.auction.AuctionService;
import com.in.team2.vo.AuctionVO;
import com.in.team2.vo.PostVO;

@Controller
public class AuctionController {

	@Autowired
	private AuctionService auctionService;

//판매중인 게시물 확인

//판매게시판 입찰 참여자 리스트 보기
	@RequestMapping(value = "/User_showSAuctionList")
	public void showSellingList(HttpServletRequest request, HttpServletResponse res, AuctionVO auction){		
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Headers", "X-Requested-With");

		List list = auctionService.showSellingList(auction);
		
		request.setAttribute("auctionList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ajax/auctionList.jsp");
		
		try {rd.forward(request, res);
		
		}catch(Exception e) {
			
		}

	}

	
	//판매게시판 입찰하기
	@LogInCheck
	@RequestMapping(value = "/S_post_auction",method=RequestMethod.POST)
	public ModelAndView create(HttpServletRequest request, HttpServletResponse res, AuctionVO auction){	
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		auction.setBuyerId(userId);
		
		ModelAndView mav = new ModelAndView();		
		
		try {
			mav.addObject("auction", auctionService.create(auction));
			
			//상세보기로 돌아가기
			res.sendRedirect("/action/S_post_showDetail?postNum="+auction.getPostNum());			
		}catch(Exception e) {
			
		}
		return null;
	}
		
	//판매게시판 입찰취소
	@LogInCheck
	@RequestMapping(value = "/S_post_auctionCancel",method=RequestMethod.POST)
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse res, AuctionVO auction){
		ModelAndView mav = new ModelAndView();		
			
		//session에 들어있는 userId를 buyerId에 삽입.
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		auction.setBuyerId(userId);

		try {
			mav.addObject("post",auctionService.delete(auction));
				//상세보기로 돌아가기
				res.sendRedirect("/action/S_post_showDetail?postNum="+auction.getPostNum());			
			}catch(Exception e) {
					
			}
				return null;
		}
			
}
