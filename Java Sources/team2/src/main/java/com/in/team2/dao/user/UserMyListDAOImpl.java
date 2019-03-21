package com.in.team2.dao.user;

import com.in.team2.vo.AuctionVO;
import com.in.team2.vo.PostVO;
import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("userMyListDAO")
public class UserMyListDAOImpl
  implements UserMyListDAO
{
	@Autowired
    private SqlSessionTemplate sqlSession;
//관심상품 전체 리스트 출력 
  public ArrayList<PostVO> showMyList(PostVO post)
  {
	  ArrayList<PostVO> list = (ArrayList)sqlSession.selectList("JH.postMyList",post);
	  return list;
  }
//관심상품 추가
  public int addMyList(AuctionVO auction){
	  
	  int result = 0;
	//관심상품에 같은 상품 중복 등록 체크
	  try {
		  result=sqlSession.insert("JH.postAddMyList", auction);}
	  
	  catch(Exception e) {//중복이라면
		  
		  if(e.getClass()==org.springframework.dao.DuplicateKeyException.class) {
			  result=-1;  
		  }
	  }
    return result;
  }
//관심상품 삭제
  public int deleteMyList(AuctionVO auction)
  {
    return sqlSession.insert("JH.postDeleteMyList", auction);
  }
}
