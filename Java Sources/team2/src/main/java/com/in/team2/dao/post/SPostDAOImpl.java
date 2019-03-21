package com.in.team2.dao.post;

import com.in.team2.vo.CommentVO;
import com.in.team2.vo.PostVO;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("sPostDAO")
@Scope("prototype")
public class SPostDAOImpl
  implements PostDAO
{
	@Autowired
    private SqlSessionTemplate sqlSession;
  
  public ArrayList<PostVO> showList(PostVO post)
  {
   //*_SQL.xml중에서 namespace가 맞는걸 찾아줌
	  ArrayList<PostVO> list = (ArrayList)sqlSession.selectList("JH.spostList");
	  
	  return list;
  }
  
  public ArrayList<PostVO> showMySellList(PostVO post)
  {
	  
	  ArrayList<PostVO> list = (ArrayList)sqlSession.selectList("JH.spostMySellList",post);
	    
	  return list;
  }
  
  public ArrayList<PostVO> searchList(int pageNum, int numbs, String category, String search)
  {
    return null;
  }
  
  public PostVO showDetail(PostVO post)
  {
	 
	  PostVO detail = (PostVO)sqlSession.selectOne("JH.showDetail",post);
	  detail.setCommentList((List)sqlSession.selectList("JH.commentList", post));
	  
	  return detail;
	  
  }
  
  public PostVO showDetailModify(PostVO post)
  {
	 
	  PostVO detail = (PostVO)sqlSession.selectOne("JH.showDetail",post);
	  
	  return detail;
	  
  }
  
  public int modify(PostVO post)
  {
	  
/*	  값 테스트용
 * 	  System.out.println("NUM: "+post.getPostNum());
	  System.out.println("TITLE: "+post.getPostTitle());
	  System.out.println("CATEGORY: "+post.getItemCategory());
	  System.out.println("NAME: "+post.getItemName());
	  System.out.println("CLASS: "+post.getItemClass());
	  System.out.println("Content: "+post.getPostContent());
	  System.out.println("phto: "+post.getPostPhoto());
*/
    int result = sqlSession.update("JH.spostUpdate", post);
	  return result;
  }
  
  public int delete(PostVO post)
  {
    int result = sqlSession.delete("JH.spostDelete", post);
	  return result;
  }
  
  public int create(PostVO post)
  {
    //매개변수 post 입력
	  int result = sqlSession.insert("JH.spostInsert", post);
	  return result;
  }
  
  public int addComment(CommentVO comment)
  {
    int result = sqlSession.insert("JH.addComment", comment);
	  return result;
  }
  
  public int deleteComment(CommentVO comment)
  {
	  int result = sqlSession.delete("JH.deleteComment", comment);
	  return result;
  }
  
  public int modifyComment(CommentVO comment, PostVO post)
  {
    int result = sqlSession.update("JH.modifyComment", comment);
	  return result;
  }
}
