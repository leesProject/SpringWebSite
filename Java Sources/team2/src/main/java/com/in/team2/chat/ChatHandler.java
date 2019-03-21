package com.in.team2.chat;

import java.util.LinkedList;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatHandler extends TextWebSocketHandler{

	private static LinkedList<WebSocketSession> userList;
	private static Object key;
	static{
		key = new Object();
		userList = new LinkedList<WebSocketSession>();
	}
	
	public ChatHandler(){
		System.out.println("WebSocket Started!");
	}
	
	
	/*Session 연결 수립 후 메소드*/
	@Override
	
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		synchronized(key) {		
			// TODO Auto-generated method stub
			userList.add(session);			
		}
	}
	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		synchronized(key) {
			// TODO Auto-generated method stub
			userList.remove(session);
		}
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		//동기화 시작!
		synchronized(key) {
			//입력한 채팅이 있을 경우 시작!	
			if(message.getPayload().length()>0){			
				Map map = session.getAttributes();
				String senderId=null;
				senderId=(String)map.get("userId");
					if(senderId!=null&&!senderId.equals("")){
						String receiverId="";
						TextMessage newMessage = new TextMessage(senderId+": "+message.getPayload());
						
						for(WebSocketSession webSocketSession : userList){		
							map=webSocketSession.getAttributes();
							receiverId=(String)map.get("userId");
							
							if(receiverId!=null&&!receiverId.equals("")){
								if(senderId.equals(receiverId)){
									TextMessage myMessage = new TextMessage("俺: "+message.getPayload());
									webSocketSession.sendMessage(myMessage);
								}
								else{
									webSocketSession.sendMessage(newMessage);
								}
							}							
					}
				}				
			}
			//입력한 채팅이 있을 경우 끝!	
			
			//입력한 채팅이 없을 경우, 아무것도 하지 않는다!
			else{}
		}//동기화 끝!
	}


}
