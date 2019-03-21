package com.in.team2.vo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class MsgVO
{
  private long msgNum;
  private String msgTitle;
  private String msgContent;
  private String senderId;
  private String receiverId;
  private char msgCheck;
  private Timestamp regDate;
  private long pageNum;
  private long numbs;
  private List resultSet;
  private long dataNum;
  private int result;/*It confirms if the insert query into both RECEIVED_MSG and SENT_MSG is executed well. 
   						It gets 2 when both are good, get less than 1 in other cases*/
     
  
  
  
  
  
  public int getResult() {
	return result;
}

public void setResult(int result) {
	this.result = result;
}

public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
  
  
  
  public long getPageNum() {
	return pageNum;
}

public void setPageNum(long pageNum) {
	this.pageNum = pageNum;
}

public long getNumbs() {
	return numbs;
}

public void setNumbs(long numbs) {
	this.numbs = numbs;
}



public long getMsgNum()
  {
    return this.msgNum;
  }
  
  public void setMsgNum(long msgNum)
  {
    this.msgNum = msgNum;
  }
  
  public String getMsgContent()
  {
    return this.msgContent;
  }
  
  public void setMsgContent(String msgContent)
  {
    this.msgContent = msgContent;
  }
  
  public String getSenderId()
  {
    return this.senderId;
  }
  
  public void setSenderId(String senderId)
  {
    this.senderId = senderId;
  }
  
  public String getReceiverId()
  {
    return this.receiverId;
  }
  
  public void setReceiverId(String receiverId)
  {
    this.receiverId = receiverId;
  }
  
  public char getMsgCheck()
  {
    return this.msgCheck;
  }
  
  public void setMsgCheck(char msgCheck)
  {
    this.msgCheck = msgCheck;
  }
  
  public Timestamp getRegDate()
  {
    return this.regDate;
  }
  
  public void setRegDate(Timestamp regDate)
  {
    this.regDate = regDate;
  }
  
  public List getResultSet() {
	return resultSet;
  }

  public void setResultSet(List resultSet) {
	this.resultSet = resultSet;
  }
  
  public long getDataNum() {
	return dataNum;
  }

  public void setDataNum(long dataNum) {
	this.dataNum = dataNum;
  }
}
