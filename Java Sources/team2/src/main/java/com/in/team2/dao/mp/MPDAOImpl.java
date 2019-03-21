package com.in.team2.dao.mp;

import com.in.team2.vo.MPVO;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("mpDAO")
public class MPDAOImpl
  implements MPDAO
{
	@Autowired
    private SqlSessionTemplate sqlSession;
  
  public MPVO search(MPVO mp)
  {
	 
	  
	 if(mp.getSearchInterval().equals("week")){
		sqlSession.selectList("search1",mp);
		
	 }
	 else if(mp.getSearchInterval().equals("month")){
		sqlSession.selectList("search2",mp);
		
	 }
	 else if(mp.getSearchInterval().equals("3months")){
		 sqlSession.selectList("search3",mp);
		
	 }
	 else if(mp.getSearchInterval().equals("6months")){
		sqlSession.selectList("search4",mp);
		
	 }
	 else if(mp.getSearchInterval().equals("year")){
		sqlSession.selectOne("search5",mp);
	
	 }
    return mp;
  }
}