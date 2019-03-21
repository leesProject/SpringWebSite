package com.in.team2.controller.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.in.team2.controller.annotation.LogInCheck;
import com.in.team2.service.post.QAPostService;
import com.in.team2.vo.BoardPager;
import com.in.team2.vo.CommentVO;
import com.in.team2.vo.PostVO;

@Scope("prototype")
@Controller
public class QAPostController {
	
	@Autowired
	private QAPostService qaPostService;
	
	@RequestMapping(value = "/QA_post_showList")
	public ModelAndView showList(@RequestParam(defaultValue="post_Title") String searchOption, @RequestParam(defaultValue="") String keyword, @RequestParam(defaultValue="1") int curPage){
		int count = qaPostService.countArticle(searchOption, keyword);
		BoardPager boardPager = new BoardPager(count, curPage);
	    int start = boardPager.getPageBegin();
	    int end = boardPager.getPageEnd();
		
		List<PostVO> list = qaPostService.showList(start, end, searchOption, keyword);
		ModelAndView mav = new ModelAndView();		
		PostVO post = new PostVO();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("boardPager", boardPager);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		mav.addObject("map", map);
		mav.setViewName("post/qapost/p_qapost");
		return mav;
	}
	
	//게시글 상세보기
	@RequestMapping(value = "/QA_post_showDetail/{postNum}")
	public ModelAndView showDetail(@PathVariable long postNum){
		ModelAndView mav = new ModelAndView();
		mav.addObject("detail", qaPostService.showDetail(postNum));
		mav.addObject("comment", qaPostService.showComment(postNum));
		mav.setViewName("post/qapost/p_qapost_detail");
		return mav;
	}
	
	@LogInCheck
	// 게시글 작성화면
	@RequestMapping(value = "/QA_post_insertPost")
	public String insert(Model model){
		return "post/qapost/l_qapost_create";
	}
	
	// 게시글 작성처리
	@LogInCheck
	@RequestMapping(method=RequestMethod.POST, value = "/QA_post_createPost")
	public String create(@ModelAttribute PostVO post,HttpSession session)throws Exception{
		post.setUserId((String)session.getAttribute("userId"));
		qaPostService.create(post);
		return "redirect:/action/QA_post_showList";
	}
	
	//////////////////	
		
	// 게시글 수정화면
	@LogInCheck
	@RequestMapping(value = "/QA_post_updatePost/{postNum}")
	public ModelAndView update(@PathVariable long postNum)throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("modify", qaPostService.showDetail(postNum));
		mav.setViewName("post/qapost/l_qapost_update");
		return mav;
	}
		
		
	//게시글 수정처리
	@LogInCheck
	@RequestMapping(value = "/QA_post_modifyPost/{postNum}", method=RequestMethod.POST)
	public String modify(@ModelAttribute PostVO post, @PathVariable long postNum)throws Exception{
		qaPostService.modify(post);
		return "redirect:/action/QA_post_showDetail/"+postNum;
	}
	
		
	//게시글 삭제
	@LogInCheck
	@RequestMapping(value = "/QA_post_deletePost")
	public String delete(@RequestParam(value= "postNum") long postNum){
		qaPostService.delete(postNum);
		return "redirect:/action/QA_post_showList";
	}
	
	///////////////////////////////
	@LogInCheck
	@RequestMapping(value = "/QA_post_createComment/{postNum}", method=RequestMethod.POST)
	public String addComment(@ModelAttribute CommentVO comment, @PathVariable long postNum)throws Exception{
		qaPostService.addComment(comment);
		return "redirect:/action/QA_post_showDetail/"+postNum;
	}
	
	//댓글 수정
	@LogInCheck
	@RequestMapping(value = "/QA_post_modifyComment/{postNum}", method=RequestMethod.POST)
	public String modifyComment(@ModelAttribute CommentVO comment, @PathVariable long postNum)throws Exception{
		qaPostService.modifyComment(comment);
		return "redirect:/action/QA_post_showDetail/"+postNum;
	}
	
	//댓글 삭제
	@LogInCheck
	@RequestMapping(value = "/QA_post_deleteComment/{postNum}", method=RequestMethod.POST)
	public String deleteComment(@ModelAttribute CommentVO comment, @PathVariable long postNum)throws Exception{
		qaPostService.deleteComment(comment);
		return "redirect:/action/QA_post_showDetail/"+postNum;
	}
}
