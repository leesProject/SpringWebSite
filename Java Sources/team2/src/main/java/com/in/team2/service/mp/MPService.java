package com.in.team2.service.mp;

import com.in.team2.vo.MPVO;
import java.sql.Timestamp;
import java.util.ArrayList;

public abstract interface MPService
{
  public abstract MPVO search(MPVO paramMPVO);
}
