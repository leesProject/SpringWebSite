package com.in.team2.controller.post;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.in.team2.controller.annotation.LogInCheck;
import com.in.team2.service.post.BPostService;
import com.in.team2.vo.BoardPager;
import com.in.team2.vo.CommentVO;
import com.in.team2.vo.PostVO;



@Scope("prototype")
@Controller
public class BPostController {
	
	@Autowired
	private BPostService bPostService;
	
	//게시글 리스트
	@RequestMapping(value = "/B_post_showList")
	public ModelAndView showList(@RequestParam(defaultValue="post_Title") String searchOption, @RequestParam(defaultValue="") String keyword,@RequestParam(defaultValue="1") int curPage)throws Exception{
		int count = bPostService.countArticle(searchOption, keyword);
		BoardPager boardPager = new BoardPager(count, curPage);
	    int start = boardPager.getPageBegin();
	    int end = boardPager.getPageEnd();
		
		List<PostVO> list = bPostService.showList(start, end, searchOption, keyword);
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		PostVO post = new PostVO();
		map.put("list", list); 
		map.put("boardPager", boardPager);
		map.put("searchOption", searchOption); 
		map.put("keyword", keyword);
		mav.addObject("map", map);
		mav.setViewName("post/bpost/p_bpost");
		return mav;
	}
	
	//게시글 상세보기
	@RequestMapping(value = "/B_post_showDetail/{postNum}")
	public ModelAndView showDetail(@PathVariable long postNum)throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("detail", bPostService.showDetail(postNum));
		mav.addObject("comment", bPostService.showComment(postNum));
		mav.setViewName("post/bpost/p_bpost_detail");
		return mav;
	}
	 
	
	// 게시글 작성화면
	@LogInCheck
	@RequestMapping(value = "/B_post_insertPost")
	public String insert(Model model)throws Exception{
		return "post/bpost/l_bpost_create";
	}
	
	// 게시글 작성처리
	@LogInCheck
	@RequestMapping(method=RequestMethod.POST, value = "/B_post_createPost")
	public String create(@ModelAttribute PostVO post ,HttpServletRequest request, HttpSession session)throws Exception{
		post.setUserId((String)session.getAttribute("userId"));
		MultipartRequest multiRequest = (MultipartRequest)request;
		MultipartFile file = multiRequest.getFile("fileName");
		String savedFileName=post.getPostPhoto().split("\\\\")[post.getPostPhoto().split("\\\\").length-1];
		post.setPostPhoto(savedFileName);
		try {
			file.transferTo(new File(request.getRealPath("/")+savedFileName));
			bPostService.create(post);
			return "redirect:/action/B_post_showList";
		}catch(Exception e) {
			System.out.println("ERROR in create, bPostController "+e);
			return null;
		}
	}
			
	// 게시글 수정화면
	@LogInCheck
	@RequestMapping(value = "/B_post_updatePost/{postNum}")
	public ModelAndView update(@PathVariable long postNum)throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("modify", bPostService.showDetail(postNum));
		mav.setViewName("post/bpost/l_bpost_update");
	return mav;
	}
		
		
	//게시글 수정처리
	@LogInCheck
	@RequestMapping(value = "/B_post_modifyPost/{postNum}", method=RequestMethod.POST)
	public String modify(@ModelAttribute PostVO post, @PathVariable long postNum, HttpServletRequest request)throws Exception{
		MultipartRequest multiRequest = (MultipartRequest)request;
		MultipartFile file = multiRequest.getFile("fileName");
		String savedFileName=post.getPostPhoto().split("\\\\")[post.getPostPhoto().split("\\\\").length-1];
		post.setPostPhoto(savedFileName);
		try {
			file.transferTo(new File(request.getRealPath("/")+savedFileName));
			bPostService.modify(post);
			return "redirect:/action/B_post_showDetail/"+postNum;
		}catch(Exception e) {
			System.out.println("ERROR in modify, bPostController "+e);
			return null;
		}
	}
	
		
	//게시글 삭제
	@LogInCheck
	@RequestMapping(value = "/B_post_deletePost")
	public String delete(@RequestParam(value= "postNum") long postNum)throws Exception{
		bPostService.delete(postNum);
		return "redirect:/action/B_post_showList";
	}
	
	//////////////////////////////댓글
	
	//댓글 추가
	@LogInCheck
	@RequestMapping(value = "/B_post_createComment/{postNum}", method=RequestMethod.POST)
	public String addComment(@ModelAttribute CommentVO comment, @PathVariable long postNum)throws Exception{
		bPostService.addComment(comment);
		return "redirect:/action/B_post_showDetail/"+postNum;
	}
	
	//댓글 수정
	@LogInCheck
	@RequestMapping(value = "/B_post_modifyComment/{postNum}", method=RequestMethod.POST)
	public String modifyComment(@ModelAttribute CommentVO comment, @PathVariable long postNum)throws Exception{
		bPostService.modifyComment(comment);
		return "redirect:/action/B_post_showDetail/"+postNum;
	}
	
	//댓글 삭제
	@LogInCheck
	@RequestMapping(value = "/B_post_deleteComment/{postNum}", method=RequestMethod.POST)
	public String deleteComment(@ModelAttribute CommentVO comment, @PathVariable long postNum)throws Exception{
		bPostService.deleteComment(comment);
		
		return "redirect:/action/B_post_showDetail/"+postNum;
	}
	
	
	
}

