package com.in.team2.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("testDAO")
public class TestDAO {	
	
	@Autowired
    private SqlSessionTemplate sqlSession;
	
	
	public int testInsert(){
		return sqlSession.insert("test.testInsert");
	}
	
}
