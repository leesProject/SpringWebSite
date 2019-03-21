package com.in.team2.service.admin;

import java.util.ArrayList;

import com.in.team2.vo.UserVO;

public interface AdminService {
	public abstract ArrayList<UserVO> showList(int paramInt1, int paramInt2);
	public abstract UserVO showDetail(UserVO paramUserVO);
	public abstract int modify(UserVO paramUserVO);
	public abstract int delete(UserVO paramUserVO);
}
