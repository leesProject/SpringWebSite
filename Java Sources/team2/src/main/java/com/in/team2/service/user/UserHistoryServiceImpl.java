package com.in.team2.service.user;

import com.in.team2.dao.user.UserHistoryDAO;
import com.in.team2.vo.HistoryVO;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("userHistoryService")
public class UserHistoryServiceImpl
  implements UserHistoryService
{
	@Autowired
	private UserHistoryDAO userHistoryDAO;
  
  public ArrayList<HistoryVO> showSellHistory(String userId, int pageNum, int numbs)
  {
    return null;
  }
  
  public ArrayList<HistoryVO> showBuyHistory(String userId,int pageNum, int numbs)
  {
    return null;
  }
  
  public ArrayList<HistoryVO> searchSellHistory(String userId, Timestamp startDate, Timestamp endDate, int pageNum, int numbs)
  {
    return null;
  }
  
  public ArrayList<HistoryVO> searchBuyHistory(String userId, Timestamp startDate, Timestamp endDate, int pageNum, int numbs)
  {
    return null;
  }
}
