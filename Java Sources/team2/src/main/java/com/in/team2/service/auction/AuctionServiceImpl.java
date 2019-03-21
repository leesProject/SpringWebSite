package com.in.team2.service.auction;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.team2.dao.auction.AuctionDAO;
import com.in.team2.vo.AuctionVO;
import com.in.team2.vo.PostVO;


@Transactional
@Service("auctionService")
@Scope("prototype")
public class AuctionServiceImpl implements AuctionService{

	@Autowired
	private AuctionDAO auctionDAO;
	
	
	@Override
	public ArrayList<AuctionVO> showBuyingList(PostVO post) {
		// TODO Auto-generated method stub
		return null;
	}
//게시물에 해당하는 상품의 입찰자 리스트 출력
	@Override
	public ArrayList<AuctionVO> showSellingList(AuctionVO auction) {
		
		return auctionDAO.showSellingList(auction);
	}
	
	

	@Override
	public AuctionVO showDetail(AuctionVO auction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(AuctionVO auction) {
		
		return auctionDAO.create(auction);
	}

	@Override
	public int delete(AuctionVO auction) {
		
		return auctionDAO.delete(auction);
	}

}
