package com.in.team2.service.user;

import com.in.team2.vo.AuctionVO;
import com.in.team2.vo.PostVO;
import java.util.ArrayList;

public abstract interface UserMyListService
{
  public abstract ArrayList<PostVO> showMyList(PostVO post);
  
  public abstract int addMyList(AuctionVO auction);
  
  public abstract int deleteMyList(AuctionVO auction);
}
