package com.in.test;

import org.springframework.stereotype.Repository;

@Repository("parent")
public class Parent {
	
	public Parent(){};
	
	public void r(){
		System.out.println("This is Parent!");
	}
}
