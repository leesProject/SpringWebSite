package com.in.team2.service.user;

import com.in.team2.dao.user.UserInfoDAO;
import com.in.team2.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("userInfoService")
public class UserInfoServiceImpl
  implements UserInfoService
{
	@Autowired
	private UserInfoDAO userInfoDAO;
  
	
	//아이디 중복 체크
	public int idDuplicatedCheck(UserVO user){
		int result = 0;
		result=userInfoDAO.idDuplicatedCheck(user);		
		return result;
	  }
	
	
	//이메일 중복 체크
	public int emailDuplicatedCheck(UserVO user){
		int result = 0;
		result=userInfoDAO.emailDuplicatedCheck(user);

		return result;
	}
	
	//이메일 중복 체크
		public int emailDuplicatedCheck2(UserVO user){
			int result = 0;
			result=userInfoDAO.emailDuplicatedCheck2(user);

			return result;
		}
	
	
	
	
  public int join(UserVO user)
  {
	  int result = 0;
	  try{
		  result=userInfoDAO.join(user);
	  }catch(Exception e){		  
	  }
	  return result;
  }
  
  public UserVO logIn(UserVO user)
  {
    return userInfoDAO.logIn(user);
  }
  
  public int logOut(UserVO user)
  {
    return 0;
  }
  
  public int modify(UserVO user)
  {
    return userInfoDAO.modify(user);
  }
  
  public int delete(UserVO user)
  {
    return userInfoDAO.delete(user);
  }

	@Override
	public UserVO detail(UserVO paramUserVO) {
		// TODO Auto-generated method stub
		return userInfoDAO.detail(paramUserVO);
	}
	
	public  UserVO searchId(UserVO paramUserVO){
		return userInfoDAO.searchId(paramUserVO);
	}
	
	public  UserVO searchPw(UserVO paramUserVO){
		return userInfoDAO.searchPw(paramUserVO);
	}
}
