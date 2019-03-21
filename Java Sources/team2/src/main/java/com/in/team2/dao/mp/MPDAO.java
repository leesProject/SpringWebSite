package com.in.team2.dao.mp;

import com.in.team2.vo.MPVO;
import java.sql.Timestamp;
import java.util.ArrayList;

public abstract interface MPDAO
{
  public abstract MPVO search(MPVO paramMPVO);
}
