package com.in.team2.service.post;

import java.util.ArrayList;
import java.util.List;

import com.in.team2.vo.CommentVO;
import com.in.team2.vo.PostVO;

public interface BPostService {
	 public List<PostVO> showList(int start, int end, String searchOption, String keyword)
	  ;
	  
	  public int countArticle(String searchOption, String keyword);
	  
	  public ArrayList<PostVO> searchList(String searchOption, String keyword);
	  public PostVO showDetail(long postNum);
	  
	  public int modify(PostVO post);
	  
	  public int delete(long postNum);
	  
	  public int create(PostVO post);
	  
	  public List<CommentVO> showComment(long postNum);
	  
	  public int addComment(CommentVO comment);
	  public int deleteComment(CommentVO comment);
	  
	  public int modifyComment(CommentVO comment);
}
