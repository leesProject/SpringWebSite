package com.in.team2.bot;

import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class SellPostManager2 extends Thread{
	@Autowired
    private SqlSessionTemplate sqlSession;
	
	int sleepTime=1000*60*10;
	
	
	public SellPostManager2(){				
		this.start();
	}
	
	
	public void run(){	
		try {
			Thread.sleep(1000*10);
		}catch(Exception e) {}	
		while(true){
			System.out.println("Old Post Removed... "+(new Date(System.currentTimeMillis()))+"\t "+this.hashCode());
			try{
				deleteExpiredPost();				
			}catch(Exception e){
				if(e.getClass()!=java.lang.NullPointerException.class){
					System.out.println("ERROR in SellPostManager2: "+e);
				}
				
				else{
					try{
						System.out.println("No data to delete in SellPostManager2: "+e);
						Thread.sleep(sleepTime);
					}catch(Exception e2){
						System.out.println("ERROR2 in SellPostManager2: "+e2);
					}
				}
			}
			try {
				Thread.sleep(sleepTime);
			}catch(Exception e) {}	
		}		
	}
	
	public void deleteExpiredPost(){
		sqlSession.delete("macro.deleteExpiredSellPost");
	}
	
}
