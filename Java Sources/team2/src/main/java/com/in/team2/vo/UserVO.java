package com.in.team2.vo;

import java.sql.Timestamp;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class UserVO
{
  private long userNum;
  private String userId;
  private String userPw;
  private String userName;
  private String userEmail;
  private String userPhone;
  private Timestamp regDate;
  private Timestamp userBanned;
  
  public long getUserNum()
  {
    return this.userNum;
  }
  
  public void setUserNum(long userNum)
  {
    this.userNum = userNum;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public String getUserPw()
  {
    return this.userPw;
  }
  
  public void setUserPw(String userPw)
  {
    this.userPw = userPw;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserEmail()
  {
    return this.userEmail;
  }
  
  public void setUserEmail(String userEmail)
  {
    this.userEmail = userEmail;
  }
  
  public String getUserPhone()
  {
    return this.userPhone;
  }
  
  public void setUserPhone(String userPhone)
  {
    this.userPhone = userPhone;
  }
  
  public Timestamp getRegDate()
  {
    return this.regDate;
  }
  
  public void setRegDate(Timestamp regDate)
  {
    this.regDate = regDate;
  }
  
  public Timestamp getUserBanned()
  {
    return this.userBanned;
  }
  
  public void setUserBanned(Timestamp userBanned)
  {
    this.userBanned = userBanned;
  }
}
