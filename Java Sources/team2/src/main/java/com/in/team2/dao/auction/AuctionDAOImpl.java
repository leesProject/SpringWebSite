package com.in.team2.dao.auction;

import com.in.team2.vo.AuctionVO;
import com.in.team2.vo.PostVO;
import com.in.team2.vo.UserVO;
import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("auctionDAO")
public class AuctionDAOImpl
  implements AuctionDAO
{
	@Autowired
    private SqlSessionTemplate sqlSession;


  @Override
  public ArrayList<AuctionVO> showBuyingList(PostVO post) {
  	// TODO Auto-generated method stub
  	return null;
  }

  @Override
  public ArrayList<AuctionVO> showSellingList(AuctionVO auction) {
  	
	  ArrayList<AuctionVO> list = (ArrayList)sqlSession.selectList("JH.showSellingList", auction);
  	
  	return list;
  }
  
  //아마 안쓸듯
	@Override
	public AuctionVO showDetail(AuctionVO auction) {
		// TODO Auto-generated method stub
		return null;
	}
//입찰하기
	@Override
	public int create(AuctionVO auction) {
		
		
		int result=1;//삭제대기중
		 try{
			 sqlSession.selectOne("JH.postAuction", auction);
		 }
		 catch(Exception e) {
			 System.out.println("Auction create: "+e);
		 }
		return result;
	}
	
	@Override
	public int delete(AuctionVO auction) {
		
		int result = 1;//삭제대기중
		try {
			sqlSession.selectOne("JH.postAuctionCancel", auction);
		}catch(Exception e) {
			System.out.println("ERROR! "+e);
		}
		return result;
	}
	 
  
}
