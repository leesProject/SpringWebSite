package com.in.team2.service.user;

import com.in.team2.MSGError;
import com.in.team2.dao.user.UserMsgDAO;
import com.in.team2.vo.MsgVO;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("userMsgService")
public class UserMsgServiceImpl
  implements UserMsgService
{
	@Autowired
	private UserMsgDAO userMsgDAO;
  
	 public MsgVO showReceivedMsg(MsgVO msg)
	  {
		 
		  userMsgDAO.showReceivedMsg(msg);
		  
		  
		  
		  

			/*List<MsgVO> list = msg.getResultSet();
			msg.setDataNum(list.size()+(msg.getPageNum()-1)*msg.getNumbs());*/
	    return msg;
	  }
	
	
	
  public MsgVO showSendedMsg(MsgVO msg)
  {
	userMsgDAO.showSendedMsg(msg);
    return msg;
  }  
 
  
  public MsgVO showSendedMsgDetail(MsgVO msg)
  {
    return userMsgDAO.showSendedMsgDetail(msg);
  }
  
  public MsgVO showReceivedMsgDetail(MsgVO msg)
  {
	  
    return userMsgDAO.showReceivedMsgDetail(msg);
  }
  
  public int deleteSendedMsgDetail(MsgVO msg)
  {
	 int result=0;
	 
	 try{
		 result=userMsgDAO.deleteSendedMsgDetail(msg);
	 }catch(Exception e){
		 System.out.println("Error in deleteSendedMsgDetail, userMsgService: "+e.getMessage());
	 }
	 return result;
  }
  
  public int deleteReceivedMsgDetail(MsgVO msg) {
	  
	  int result=0;
	  
	  try{
		  	result=userMsgDAO.deleteReceivedMsgDetail(msg);
	  }catch(Exception e){
		 System.out.println("Error in deleteSendedMsgDetail, userMsgService: "+e.getMessage());
	  }
	  
	  
	  
	  return result;
  }

	@Override
	public int createMsg(MsgVO paramMsgVO) {
		// TODO Auto-generated method stub
		int result=0; 
		try{
			result= userMsgDAO.createMsg(paramMsgVO);					
		}catch(MSGError e){
			if(e.getErrorCode()==-1){
				result=-1;
			}		
		}
		catch(Exception e){
			System.out.println(e.getMessage());			
		}		
		return result;
		
	}
}
