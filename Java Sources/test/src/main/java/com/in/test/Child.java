package com.in.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;



@Scope("prototype")
@Repository("child")
public class Child extends Parent{
	
	
	public Child(){};
	
	public void r(){
		System.out.println("This is Child!");
	}
}
