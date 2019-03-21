package com.in.team2.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.lang.model.type.PrimitiveType;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class MPVO
{
  private String itemCategory;
  private String itemName;
  private char itemClass;
  private long itemCurPrice;
  private Timestamp soldDate;
  private String searchInterval;
  private long showInterval;
  private List<MPVO> resultSet;
  private String start;
  private String end;
  
  
  

public String getStart() {
	return start;
}

public void setStart(String start) {
	this.start = start;
}

public String getEnd() {
	return end;
}

public void setEnd(String end) {
	this.end = end;
}

public List<MPVO> getResultSet() {
	return resultSet;
}

public void setResultSet(List<MPVO> resultSet) {
	this.resultSet = resultSet;
}

public long getShowInterval() {
	return showInterval;
}

public void setShowInterval(long showInterval) {
	this.showInterval = showInterval;
}

public String getSearchInterval() {
	return searchInterval;
}

public void setSearchInterval(String searchInterval) {
	this.searchInterval = searchInterval;
}

public String getItemCategory()
  {
    return this.itemCategory;
  }
  
  public long getItemCurPrice() {
	return itemCurPrice;
}

public void setItemCurPrice(long itemCurPrice) {
	this.itemCurPrice = itemCurPrice;
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
  
  public Timestamp getSoldDate()
  {
    return this.soldDate;
  }
  
  public void setSoldDate(Timestamp soldDate)
  {
    this.soldDate = soldDate;
  }
}
