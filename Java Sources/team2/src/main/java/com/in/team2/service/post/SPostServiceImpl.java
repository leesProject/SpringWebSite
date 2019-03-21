package com.in.team2.service.post;

import com.in.team2.dao.post.PostDAO;
import com.in.team2.vo.CommentVO;
import com.in.team2.vo.PostVO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("sPostService")
@Scope("prototype")
public class SPostServiceImpl
  implements PostService
{
	@Autowired
	private PostDAO sPostDAO;
  
  public ArrayList<PostVO> showList(PostVO post)
  {
    return sPostDAO.showList(post);
  }
  
  public ArrayList<PostVO> showMySellList(PostVO post)
  {	  
	  return sPostDAO.showMySellList(post);
  }
  
  public ArrayList<PostVO> searchList(int pageNum, int numbs, String category, String search)
  {
    return null;
  }
  
  public PostVO showDetail(PostVO post)
  {
    return sPostDAO.showDetail(post);
  }
  
  public PostVO showDetailModify(PostVO post) {
	  
	  return sPostDAO.showDetail(post);
  }
  
  public int modify(PostVO post)
  {
    return sPostDAO.modify(post);
  }
  
  public int delete(PostVO post)
  {
    return sPostDAO.delete(post);
  }
  
  public int create(PostVO post)
  {
    return sPostDAO.create(post);
  }
  
  public int addComment(CommentVO comment)
  {
    return sPostDAO.addComment(comment);
  }
  
  public int deleteComment(CommentVO comment)
  {
    return sPostDAO.deleteComment(comment);
  }
  
  public int modifyComment(CommentVO comment, PostVO post)
  {
    return sPostDAO.modifyComment(comment, post);
  }

@Override
public List<CommentVO> showComment(long postNum) {
	// TODO Auto-generated method stub
	return null;
}
}
