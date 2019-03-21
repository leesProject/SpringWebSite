package com.in.team2.dao.auction;

import com.in.team2.vo.AuctionVO;
import com.in.team2.vo.PostVO;
import java.util.ArrayList;

public abstract interface AuctionDAO
{
  public abstract ArrayList<AuctionVO> showBuyingList(PostVO post);
  
  public abstract ArrayList<AuctionVO> showSellingList(AuctionVO auction);
  
  public abstract AuctionVO showDetail(AuctionVO auction);
  
  public abstract int create(AuctionVO auction);
  
  public abstract int delete(AuctionVO auction);
    
}
