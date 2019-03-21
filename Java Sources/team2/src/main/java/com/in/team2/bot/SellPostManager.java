package com.in.team2.bot;

import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class SellPostManager extends Thread{
	@Autowired
    private SqlSessionTemplate sqlSession;
	
	int sleepTime=1000*60*10;
	
	
	public SellPostManager(){			
		this.start();
	}
	
	
	public void run(){
		try {
			Thread.sleep(1000*10);
		}catch(Exception e) {}	
		
		while(true){
			System.out.println("Informing to sellers and buyers... "+(new Date(System.currentTimeMillis()))+"\t "+this.hashCode());
			try{
				informUsers();
				
				
			}catch(Exception e){
				if(e.getClass()!=java.lang.NullPointerException.class){
					System.out.println("ERROR in SellPostManager: "+e);
				}
				
				else{
					try{
						System.out.println("No data to inform in SellPostManager: "+e);
					}catch(Exception e2){
						System.out.println("ERROR2 in SellPostManager: "+e2);
					}
				}
			}
			try {
				Thread.sleep(sleepTime);
			}catch(Exception e) {}			
		}		
	}
	
	
	public void informUsers(){
		sqlSession.selectOne("macro.informSellerAndBuyer");
	}
}
