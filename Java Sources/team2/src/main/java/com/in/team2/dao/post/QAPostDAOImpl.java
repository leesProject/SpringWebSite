package com.in.team2.dao.post;

import com.in.team2.vo.CommentVO;
import com.in.team2.vo.PostVO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("qaPostDAO")
public class QAPostDAOImpl
  implements QAPostDAO
{
	@Autowired
    private SqlSessionTemplate sqlSession;
  
  public List<PostVO> showList(int start, int end, String searchOption, String keyword)
  {
	  Map<String, Object> map = new HashMap<String, Object>();
	    map.put("searchOption", searchOption);
	    map.put("keyword", keyword);
	    map.put("start", start);
	    map.put("end", end);
	  return sqlSession.selectList("qapost.listAll", map);
  }
  
  public int countArticle(String searchOption, String keyword){
      Map<String, String> map = new HashMap<String, String>();
      map.put("searchOption", searchOption);
      map.put("keyword", keyword);
      return sqlSession.selectOne("qapost.countArticle", map);
  }
  
  public ArrayList<PostVO> searchList(String searchOption, String keyword)
  {
	  Map<String, String> map = new HashMap<String, String>();
	    map.put("searchOption", searchOption);
	    map.put("keyword", keyword);
	  ArrayList<PostVO> list = (ArrayList)sqlSession.selectList("qapost.search", map);
    return list;
  }
  
  public PostVO showDetail(long postNum)
  {
	  return sqlSession.selectOne("qapost.view", postNum);
  }
  
  public int modify(PostVO post)
  {
    return sqlSession.update("qapost.update", post);
  }
  
  public int delete(long postNum)
  {
    return sqlSession.delete("qapost.delete", postNum);
  }
  
  public int create(PostVO post)
  {
    return sqlSession.insert("qapost.create", post);
  }
  
  /////////////////////////////
  public List<CommentVO> showComment(long postNum) 
  {
	  
	  List<CommentVO> comment =sqlSession.selectList("qapost.listComment", postNum);
	 
    return comment;
  }
  
  public int addComment(CommentVO comment)
  {
	 return sqlSession.insert("qapost.Commentset", comment);
  }
  
  public int deleteComment(CommentVO comment)
  {
	 return sqlSession.delete("qapost.Commentdelete", comment);
  }
  
  public int modifyComment(CommentVO comment)
  {
	 return sqlSession.update("qapost.Commentupdate", comment);
  }
}
