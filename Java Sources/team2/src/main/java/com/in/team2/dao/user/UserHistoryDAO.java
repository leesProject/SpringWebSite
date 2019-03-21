package com.in.team2.dao.user;

import com.in.team2.vo.HistoryVO;
import java.sql.Timestamp;
import java.util.ArrayList;

public abstract interface UserHistoryDAO
{
  public abstract ArrayList<HistoryVO> showSellHistory(String userId, int paramInt1, int paramInt2);
  
  public abstract ArrayList<HistoryVO> showBuyHistory(String userId, int paramInt1, int paramInt2);
  
  public abstract ArrayList<HistoryVO> searchSellHistory(String userId, Timestamp paramTimestamp1, Timestamp paramTimestamp2, int paramInt1, int paramInt2);
  
  public abstract ArrayList<HistoryVO> searchBuyHistory(String userId, Timestamp paramTimestamp1, Timestamp paramTimestamp2, int paramInt1, int paramInt2);
}
