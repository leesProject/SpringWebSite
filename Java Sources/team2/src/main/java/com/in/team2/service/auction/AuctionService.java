package com.in.team2.service.auction;

import java.util.ArrayList;

import com.in.team2.vo.AuctionVO;
import com.in.team2.vo.PostVO;
import com.in.team2.vo.UserVO;

public interface AuctionService {
	public abstract ArrayList<AuctionVO> showBuyingList(PostVO post);
	public abstract ArrayList<AuctionVO> showSellingList(AuctionVO auction);
	public abstract AuctionVO showDetail(AuctionVO auction);	  
	public abstract int create(AuctionVO auction);	  
	public abstract int delete(AuctionVO auction);	  

}
