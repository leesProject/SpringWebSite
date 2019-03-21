package com.in.team2.service.user;

import com.in.team2.dao.user.UserMyListDAO;
import com.in.team2.vo.AuctionVO;
import com.in.team2.vo.PostVO;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("userMyListService")
public class UserMyListServiceImpl
  implements UserMyListService
{
	@Autowired
	private UserMyListDAO userMyListDAO;
  
  public ArrayList<PostVO> showMyList(PostVO post)
  {
    return userMyListDAO.showMyList(post);
  }
  //마이리스트 추가
  public int addMyList(AuctionVO auction)
  {
	  int result = userMyListDAO.addMyList(auction);
	  System.out.println("너 맞냐2	"+result);
    return result;
  }
  //마이리스트 삭제
  public int deleteMyList(AuctionVO auction)
  {
    return userMyListDAO.deleteMyList(auction);
  }


}
