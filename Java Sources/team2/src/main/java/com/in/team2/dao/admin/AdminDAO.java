package com.in.team2.dao.admin;

import com.in.team2.vo.UserVO;
import java.util.ArrayList;

public abstract interface AdminDAO
{
  public abstract ArrayList<UserVO> showList(int paramInt1, int paramInt2);
  
  public abstract UserVO showDetail(UserVO paramUserVO);
  
  public abstract int modify(UserVO paramUserVO);
  
  public abstract int delete(UserVO paramUserVO);
}
