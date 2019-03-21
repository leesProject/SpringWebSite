package com.in.team2.service.post;

import com.in.team2.vo.CommentVO;
import com.in.team2.vo.PostVO;
import java.util.ArrayList;
import java.util.List;

public interface QAPostService {
	public abstract int create(PostVO post);	  
	public abstract List<PostVO> showList(int start, int end, String searchOption, String keyword);
	public int countArticle(String searchOption, String keyword);
	public abstract ArrayList<PostVO> searchList(String searchOption, String keyword);
	public abstract PostVO showDetail(long postNum);
	public abstract int modify(PostVO post);
	public abstract int delete(long postNum);
	public abstract List<CommentVO> showComment(long postNum);
	public abstract int addComment(CommentVO comment);
	public abstract int deleteComment(CommentVO comment);
	public abstract int modifyComment(CommentVO comment);
}
