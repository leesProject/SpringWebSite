package com.in.team2.vo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class PostVO
{
  private long postNum;
  private String userId;
  private String postTitle;
  private String postContent;
  private String postPhoto;
  private Timestamp regDate;
  private String itemCategory;
  private String itemName;
  private char itemClass;
  private long itemCurPrice;
  private long itemIncrease;
  private Timestamp itemExpireDate;
  private char msgSended;
  
  
  
  //댓글리스트
  private List<CommentVO> commentList;
  
  public List<CommentVO> getCommentList() {
	return commentList;
  }

  public void setCommentList(List<CommentVO> commentList) {
	this.commentList = commentList;
  }

public long getPostNum()
  {
    return this.postNum;
  }
  
  public void setPostNum(long postNum)
  {
    this.postNum = postNum;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public long getItemCurPrice() {
	return itemCurPrice;
}

public void setItemCurPrice(long itemCurPrice) {
	this.itemCurPrice = itemCurPrice;
}

public String getPostTitle()
  {
    return this.postTitle;
  }
  
  public void setPostTitle(String postTitle)
  {
    this.postTitle = postTitle;
  }
  
  public String getPostContent()
  {
    return this.postContent;
  }
  
  public void setPostContent(String postContent)
  {
    this.postContent = postContent;
  }
  
  public String getPostPhoto()
  {
    return this.postPhoto;
  }
  
  public void setPostPhoto(String postPhoto)
  {
    this.postPhoto = postPhoto;
  }
  
  public Timestamp getRegDate()
  {
    return this.regDate;
  }
  
  public void setRegDate(Timestamp regDate)
  {
    this.regDate = regDate;
  }
  
  public String getItemCategory()
  {
    return this.itemCategory;
  }
  
  public void setItemCategory(String itemCategory)
  {
    this.itemCategory = itemCategory;
  }
  
  public String getItemName()
  {
    return this.itemName;
  }
  
  public void setItemName(String itemName)
  {
    this.itemName = itemName;
  }
  
  public char getItemClass()
  {
    return this.itemClass;
  }
  
  public void setItemClass(char itemClass)
  {
    this.itemClass = itemClass;
  }
  
 
  
  
  
  public long getItemIncrease() {
	return itemIncrease;
}

public void setItemIncrease(long itemIncrease) {
	this.itemIncrease = itemIncrease;
}

public Timestamp getItemExpireDate()
  {
    return this.itemExpireDate;
  }
  
  public void setItemExpireDate(Timestamp itemExpireDate)
  {
    this.itemExpireDate = itemExpireDate;
  }
  
  public char getMsgSended()
  {
    return this.msgSended;
  }
  
  public void setMsgSended(char msgSended)
  {
    this.msgSended = msgSended;
  }


}
