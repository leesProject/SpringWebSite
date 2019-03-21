package com.in.team2.vo;

import java.sql.Timestamp;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class HistoryVO
{
  private String itemCategory;
  private String itemName;
  private char itemClass;
  private long itemCurPrice;
  private Timestamp date;
  private String buyerId;
  private String sellerId;
  
  public long getItemCurPrice() {
	return itemCurPrice;
}

public void setItemCurPrice(long itemCurPrice) {
	this.itemCurPrice = itemCurPrice;
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
  
  
  public Timestamp getDate()
  {
    return this.date;
  }
  
  public void setDate(Timestamp date)
  {
    this.date = date;
  }

	public String getBuyerId() {
		return buyerId;
	}
	
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	
	public String getSellerId() {
		return sellerId;
	}
	
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
  
  
}
