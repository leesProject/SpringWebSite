package com.in.team2.dao.user;

import com.in.team2.MSGError;
import com.in.team2.vo.MsgVO;
import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Scope("prototype")
@Repository("userMsgDAO")
public class UserMsgDAOImpl
  implements UserMsgDAO
{
	@Autowired
    private SqlSessionTemplate sqlSession;
  
  public MsgVO showSendedMsg(MsgVO msg)
  {
	sqlSession.selectOne("msg.showSMSGList",msg);
    return null;
  }
  
  public MsgVO showReceivedMsg(MsgVO msg)
  {
	sqlSession.selectOne("msg.showRMSGList",msg);
    return msg;
  }
  
  public MsgVO showSendedMsgDetail(MsgVO paramsg)
  {
	MsgVO msg=sqlSession.selectOne("msg.showSMSGDetail",paramsg);
    return msg;
  }
  
  
  public MsgVO showReceivedMsgDetail(MsgVO msg)
  {
	  sqlSession.selectOne("msg.showRMSGDetail",msg);
	  return msg;
  }
  
  
  
  
  @Transactional(rollbackFor={Exception.class})
  public int deleteSendedMsgDetail(MsgVO msg) throws Exception{
	  int result = 0;
	  result=sqlSession.delete("msg.deleteSendedMsgDetail",msg);
	  if(result==0){
		  MSGError msgError=new MSGError();
			msgError.setMessage(1, result);
			throw msgError;
	  }
	  
	  
	  
	  return result;
  }
  
  
  
  
  
  
  @Transactional(rollbackFor={Exception.class})
  public int deleteReceivedMsgDetail(MsgVO msg) throws Exception{
	  
	  int result = 0;
	  result=sqlSession.delete("msg.deleteReceivedMsgDetail",msg);
	  if(result==0){
		  MSGError msgError=new MSGError();
			msgError.setMessage(1, result);
			throw msgError;
	  }
	  return result;
  }

  
  
  
  
  
  
  
	@Override
	@Transactional(rollbackFor={Exception.class})
	public int createMsg(MsgVO paramMsgVO) throws Exception{
		// TODO Auto-generated method stub
		MSGError msgError=new MSGError();
		int result=0;
		
		try{
			sqlSession.selectOne("msg.createMsg",paramMsgVO);			
			
		}catch(Exception e){
			System.out.println("ERROR IN createMsg, UserMsgDAO: "+e.getClass());
			System.out.println("ERROR IN createMsg, UserMsgDAO: "+e.getMessage());
			if(e.getClass()==org.springframework.dao.DataIntegrityViolationException.class){
				msgError.setErrorCode(-1);
			}
		}
		result=paramMsgVO.getResult();		
				
		if(result!=2){			
			msgError.setMessage(2, result);		
			throw msgError;
		}
		
		return result;
	}
}
