package com.in.team2;

import java.util.HashMap;

public class SpecialLetters {
	private static HashMap<String, String> specialLetters;
	
	static {
		specialLetters=new HashMap<String, String>();
		specialLetters.put("space", "&s{;");
	}
	
	public static String get(String letters) {
		return specialLetters.get(letters);
	}
	
	
}
