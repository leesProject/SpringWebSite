package com.in.team2.dao.admin;

import com.in.team2.vo.UserVO;
import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("adminDAO")
public class AdminDAOImpl
  implements AdminDAO
{
	@Autowired
    private SqlSessionTemplate sqlSession;
  
  public ArrayList<UserVO> showList(int pageNum, int numbs)
  {
    return null;
  }
  
  public UserVO showDetail(UserVO user)
  {
    return null;
  }
  
  public int modify(UserVO user)
  {
    return 0;
  }
  
  public int delete(UserVO user)
  {
    return 0;
  }
}
