package com.in.team2.vo;

import java.sql.Timestamp;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class AuctionVO
{
	private long itemCurPrice;
	private String sellerId;
	private String buyerId;
	private long postNum;
	private Timestamp itemExpireDate;
	private long itemIncrease;
	private long auctionCnt;	
	
	
	
	public long getAuctionCnt() {
		return auctionCnt;
	}


	public void setAuctionCnt(long auctionCnt) {
		this.auctionCnt = auctionCnt;
	}


	public void setItemExpireDate(String itemExpireDate) {
		String now = itemExpireDate; // 형식을 지켜야 함
		java.sql.Timestamp t = java.sql.Timestamp.valueOf(now);
		this.itemExpireDate = t;
	}
  
  
  public Timestamp getItemExpireDate() {
		return itemExpireDate;
	}

	public void setItemExpireDate(Timestamp itemExpireDate) {
		this.itemExpireDate = itemExpireDate;
	}
	

public long getItemIncrease() {
		return itemIncrease;
	}

	public void setItemIncrease(long itemIncrease) {
		this.itemIncrease = itemIncrease;
	}

public long getItemCurPrice() {
	return itemCurPrice;
}

public void setItemCurPrice(long itemCurPrice) {
	this.itemCurPrice = itemCurPrice;
}

	
  


  
  public String getSellerId()
  {
    return this.sellerId;
  }
  
  public void setSellerId(String sellerId)
  {
    this.sellerId = sellerId;
  }
  
  public String getBuyerId()
  {
    return this.buyerId;
  }
  
  public void setBuyerId(String buyerId)
  {
    this.buyerId = buyerId;
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
