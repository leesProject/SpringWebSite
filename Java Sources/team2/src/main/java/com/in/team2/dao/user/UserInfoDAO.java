package com.in.team2.dao.user;

import com.in.team2.vo.UserVO;

public abstract interface UserInfoDAO
{
	public abstract int idDuplicatedCheck(UserVO user);

	public abstract int emailDuplicatedCheck(UserVO user);	
	
	public abstract int emailDuplicatedCheck2(UserVO user);	
	
	public abstract int join(UserVO paramUserVO) throws Exception;
	  
	public abstract UserVO logIn(UserVO paramUserVO);
	  
	public abstract int logOut(UserVO paramUserVO);
	  
	public abstract UserVO detail(UserVO paramUserVO);
	  
	public abstract int modify(UserVO paramUserVO);
	  
	public abstract int delete(UserVO paramUserVO);
	
	public abstract UserVO searchId(UserVO paramUserVO);
	
	public abstract UserVO searchPw(UserVO paramUserVO);
}
