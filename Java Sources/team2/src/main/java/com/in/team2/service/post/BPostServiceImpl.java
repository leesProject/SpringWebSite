package com.in.team2.service.post;

import com.in.team2.dao.post.BPostDAO;
import com.in.team2.vo.CommentVO;
import com.in.team2.vo.PostVO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("bPostService")
public class BPostServiceImpl
  implements BPostService
{
	@Autowired
	private BPostDAO bPostDAO;
  
  public List<PostVO> showList(int start, int end, String searchOption, String keyword)
  {
    return bPostDAO.showList(start, end, searchOption, keyword);
  }
  
  public int countArticle(String searchOption, String keyword)
  {
	  return bPostDAO.countArticle(searchOption, keyword);
  }
  
  public ArrayList<PostVO> searchList(String searchOption, String keyword)
  {
    return bPostDAO.searchList(searchOption, keyword);
  }
  
  public PostVO showDetail(long postNum)
  {
    return bPostDAO.showDetail(postNum);
  }
  
  public int modify(PostVO post)
  {
    return bPostDAO.modify(post);
  }
  
  public int delete(long postNum)
  {
    return bPostDAO.delete(postNum);
  }
  
  public int create(PostVO post)
  {
	  String postTitle = post.getPostTitle();
      String postContent = post.getPostContent();
      // *<, > 처리
      postTitle = postTitle.replace("<", "&lt;");
      postTitle = postTitle.replace(">", "&gt;");
      postContent = postContent.replace("<", "&lt;");
      postContent = postContent.replace(">", "&gt;");
      // *공백문자 처리
      postTitle = postTitle.replace("  ",    "&nbsp;&nbsp;");
      postContent = postContent.replace("  ",    "&nbsp;&nbsp;");
      // *줄바꿈 문자처리
      postContent = postContent.replace("\n", "<br>");
      post.setPostTitle(postTitle);
      post.setPostContent(postContent);
      
    return bPostDAO.create(post);
  }
  
  public List<CommentVO> showComment(long postNum) {
	  List<CommentVO> comment = (List<CommentVO>) bPostDAO.showComment(postNum);
	return comment;
  }
  
  public int addComment(CommentVO comment)
  {
    return bPostDAO.addComment(comment);
  }
  
  public int deleteComment(CommentVO comment)
  {
    return bPostDAO.deleteComment(comment);
  }
  
  public int modifyComment(CommentVO comment)
  {
    return bPostDAO.modifyComment(comment);
  }
}

