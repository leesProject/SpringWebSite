package com.in.team2.vo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.annotation.Scope;
@Scope("prototype")
public class CommentVO
{
  private long commentNum;
  private String commentContent;
  private Timestamp regDate;
  private String userId;
  private long postNum;
  private List<CommentVO> resultSet;
  
  
  
  public List<CommentVO> getResultSet() {
	return resultSet;
}

public void setResultSet(List<CommentVO> resultSet) {
	this.resultSet = resultSet;
}

public long getCommentNum()
  {
    return this.commentNum;
  }
  
  public void setCommentNum(long commentNum)
  {
    this.commentNum = commentNum;
  }
  
  public String getCommentContent()
  {
    return this.commentContent;
  }
  
  public void setCommentContent(String commentContent)
  {
    this.commentContent = commentContent;
  }
  
  public Timestamp getRegDate()
  {
    return this.regDate;
  }
  
  public void setRegDate(Timestamp regDate)
  {
    this.regDate = regDate;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public long getPostNum()
  {
    return this.postNum;
  }
  
  public void setPostNum(long postNum)
  {
    this.postNum = postNum;
  }
}
