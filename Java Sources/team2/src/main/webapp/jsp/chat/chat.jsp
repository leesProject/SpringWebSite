<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src="/jquery/sockjs.js"></script>


<body>
<div id='chattingApp'>	
	<textarea id='receivedChat' readonly="readonly" ></textarea>
	<input type='text' id='chatText'>
	
	<div>
		<a id='chatSendBtn'>send</a>
	</div>
</div>	


<script>
	
	var chatLineNum=0;
	var socket = new SockJS('/action/l_chat');;
	
	$(document).ready(function(){
		
		<c:if test='${empty sessionScope.userId}'>
			$('#receivedChat').append("おしゃべりはログインしてから可能！\n");	
		</c:if>
		
		
		
		<c:if test='${!empty sessionScope.userId}'>
			var tempInt=sessionStorage.getItem('chatLineNum');
			
			if(tempInt!=null){
				chatLineNum=parseInt(tempInt);
				 for(i=0;i<tempInt;i++){
					$('#receivedChat').append(sessionStorage.getItem('chatLine'+i)+"\n"); 
				} 
				 
				 
				var textarea = document.getElementById("receivedChat");			
				textarea.scrollTop=textarea.scrollHeight;			 
			}
		</c:if>		
	})
	
	
	socket.onmessage = function(data){		

        		var textarea = document.getElementById("receivedChat");
        		$(textarea).append(data.data+"\n");			
        		textarea.scrollTop=textarea.scrollHeight;
        		
        				
        		
        		sessionStorage.setItem('chatLine'+chatLineNum,data.data);
        		chatLineNum=chatLineNum+1;
        		sessionStorage.setItem('chatLineNum',chatLineNum);
        	}
		
	
	
	$('#chatSendBtn').click(function(){
		sendChat();
	})
	
	
	$( "#chatText" ).keypress(function(e) {
		if(e.keyCode==13){
			sendChat();
		}
	});


	
	
	function sendChat(){
		if($('#chatText').val().length>0){
			socket.send($('#chatText').val());
			$('#chatText').val('');
			$('#chatText').focus();
		}
	}
	
	
	
	
	

</script>
</body>
</html>