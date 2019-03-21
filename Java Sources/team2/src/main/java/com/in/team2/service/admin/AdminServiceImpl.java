package com.in.team2.service.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.team2.dao.admin.AdminDAO;
import com.in.team2.vo.UserVO;

@Transactional
@Service("adminService")
@Scope("prototype")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public ArrayList<UserVO> showList(int paramInt1, int paramInt2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO showDetail(UserVO paramUserVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(UserVO paramUserVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UserVO paramUserVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
