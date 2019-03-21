package com.in.team2.dao.user;

import com.in.team2.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Scope("prototype")
@Repository("userInfoDAO")
public class UserInfoDAOImpl
  implements UserInfoDAO
{
	@Autowired
    private SqlSessionTemplate sqlSession;
  
	
	
	
	//아이디 중복 체크
	public int idDuplicatedCheck(UserVO user){
		int result = 0;	
		result=(sqlSession.selectList("login.idDuplicatedCheck",user)).size();
		return result;
	}
		
		
	//이메일 중복 체크
	public int emailDuplicatedCheck(UserVO user){
		int result = 0;	
		result=(sqlSession.selectList("login.emailDuplicatedCheck",user)).size();
		return result;
	}
	
	
	//이메일 중복 체크
		public int emailDuplicatedCheck2(UserVO user){
			int result = 0;	
			result=(sqlSession.selectList("login.emailDuplicatedCheck2",user)).size();
			return result;
		}
	
	
	
	
	
	
	
	@Transactional(rollbackFor={Exception.class})
	public int join(UserVO user) throws Exception
	{
		int result = 0;
		try{
			result = sqlSession.insert("login.join", user);
		}catch(Exception e){System.out.println("ERROR in join method, UserInfoDAO! "+e);}	 
		if(result==0){
			throw new Exception();
		}
		
		return result;
	}
  
  public UserVO logIn(UserVO user)
  {
	  UserVO result = null;
	  try{
		  result = sqlSession.selectOne("login.login", user);
	  }catch(Exception e){System.out.println("ERROR in logIn method, UserInfoDAO! "+e);}	 
	  return result;
  }
  
  public int logOut(UserVO user)
  {
    return 0;
  }
  
  
  public int modify(UserVO user)
  {
    return sqlSession.update("login.modify",user);
  }
  
  public int delete(UserVO user)
  {
    return sqlSession.delete("login.delete",user);
  }

  	@Override
	public UserVO detail(UserVO user) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("login.detail",user);
	}
  	
  	public UserVO searchId(UserVO paramUserVO){
  		UserVO user = (UserVO)sqlSession.selectOne("login.searchId", paramUserVO);
  		return user;
  	}
  	
  	public UserVO searchPw(UserVO user){
  		
  		char ints[]={'1','2','3','4','5','6','7','8','9','0'};
  		char letters[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  		char specials[]={'!','@','#','$','%','^','&'}; 		
  		
  		StringBuilder tempPw = new StringBuilder();  		
  		int pwSize = (int)(Math.random()*15)+6;  		
  		
  		for(int i=0;i<pwSize;i++){
  			if(Math.random()<0.33){
  				tempPw.append(ints[(int)(Math.random()*ints.length)]);
  			}
  			else if(Math.random()<0.67){  				
  				if(Math.random()<0.5){
  					tempPw.append(letters[(int)(Math.random()*letters.length)]);
  				}
  				else{
  					String temp=letters[(int)(Math.random()*letters.length)]+"";
  					tempPw.append(temp.toUpperCase());
  				}
  			}
  			else{
  				tempPw.append(specials[(int)(Math.random()*specials.length)]);
  			}
  		} 
  		
  		user.setUserPw(tempPw.toString());
  		int result = sqlSession.update("login.searchPw", user);  		
  		if(result==1){  				
  		}else{
  			user=null;
  		}  			
  		return user;
  	}
}
