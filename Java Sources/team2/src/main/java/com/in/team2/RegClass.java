package com.in.team2;

public class RegClass {
	private static String userId="^[A-Za-z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{4,20}$";
	private static String userPw="^[A-Za-z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣!@#$%^&]{6,20}$";
	private static String userName="^[A-Za-z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{2,20}$";
	private static String userEmail="^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+{3,30}$";
	private static String userPhone="^[0-9]{6,20}$";
	
	public static String getUserId() {
		return userId;
	}
	public static String getUserPw() {
		return userPw;
	}
	public static String getUserName() {
		return userName;
	}
	public static String getUserEmail() {
		return userEmail;
	}
	public static String getUserPhone() {
		return userPhone;
	}
	
	
	
}
