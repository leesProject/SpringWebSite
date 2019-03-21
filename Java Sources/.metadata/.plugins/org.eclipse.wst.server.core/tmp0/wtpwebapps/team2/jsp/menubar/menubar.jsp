<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>

<link rel="stylesheet" type="text/css" href="/resources/css/team2Style.css"/>
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/earlyaccess/notosanskr.css"/> 

<style>
.menu {cursor:pointer}
body {
	font-family: 'Noto Sans KR';
}
</style>





<body>

	<div align="center" style="width: 85%; float: left">
		<div style='padding-top: 10vh'>
			<a class = 'menu' onclick="document.location.href='/jsp/main/p_main.jsp'"><span>メーンページへ</span></a>
			<a class = 'menu' style='margin-left: 3%' onclick="document.location.href='/action/S_post_showList'"><span>販売掲示板へ</span></a>
			<a class = 'menu' style='margin-left: 3%' onclick="document.location.href='/action/B_post_showList'"><span>購買掲示板へ</span></a>
			<a class = 'menu' style='margin-left: 3%' onclick="document.location.href='/action/QA_post_showList.action'"><span>Q/A掲示板へ</span></a>
			<a class = 'menu' style='margin-left: 3%' onclick="document.location.href='/jsp/marketprice/p_mp.jsp'"><span>平均相場を見る</span></a>
			<%if(session.getAttribute("userId")!=null){%>
				<a class = 'menu' style='margin-left: 3%' onclick="document.location.href='/action/User_showMyList'"><span>マイリスト</span></a>
			 <%} %>
		 </div>
	</div>


	<div align="center" style="width: 15%; float: left; height: 10vh; ">
		<div style='margin-top: 3vh; margin-right: 3%;'>
			<%if(session.getAttribute("userId")==null){%>
				<button onclick="document.location.href='/jsp/logIn/p_logIn.jsp'">ログイン</button >
				<button onclick="document.location.href='/jsp/logIn/p_join.jsp'">加入</button>
			<%} else{ %>
				<a>いらっしゃいませ、${sessionScope.userId}様!</a><br>				
				<button onclick="document.location.href='/action/User_logOut'">ログアウト</button>		
				<button  onclick="document.location.href='/action/User_showDetail'">個人情報</button>
				<a href='/action/Msg_showRMsgList' style="margin-right: 7%;">メール</a>
			<%} %>
		</div>
		</div><br>	
</body>

<script>	
		$('#footer').ready(function() {
			var contentHeight = $('#content').css('height');
			contentHeight = contentHeight.split("px")[0];		
			contentHeight = Number(contentHeight);
			contentHeight = contentHeight+0;
			contentHeight = String(contentHeight)+"px";
			
			$('#footer').css('margin-top',contentHeight);
		})		
		
		$(window).resize(function(){
			relocateFooter();
			relocateChatingApp();
		})
	
				
		$('#footer').ready(function() {
			relocateFooter();
		})
		
		
		
		function relocateFooter(){
			var contentHeight = $('#content').css('height');
			contentHeight = contentHeight.split("px")[0];
			contentHeight = Number(contentHeight);
			contentHeight = contentHeight+0;
			contentHeight = String(contentHeight);
			contentHeight = String(contentHeight)+"px";			
			$('#footer').css('margin-top',contentHeight);
		}
		
		
		$('#receivedChat').ready(function() {
			relocateChatingApp();
		})
		
		
		function relocateChatingApp(){
			var chatAppHeight = $('#chattingApp').css('height');
			chatAppHeight = chatAppHeight.split("px")[0];
			chatAppHeight = Number(chatAppHeight);
			
			
			var chatAppPaddingTop = chatAppHeight*0.1;
			
			if(chatAppPaddingTop<41){
				chatAppPaddingTop=41;
			}
			
			$('#chattingApp').css('padding-top',chatAppPaddingTop.toString()+"px");			
			
			
			
			var receivedChatHeight = chatAppHeight*0.7;
			if(receivedChatHeight>343){
				receivedChatHeight=343;
			}
			receivedChatHeight = receivedChatHeight.toString()+"px";			
			$('#receivedChat').css('height',receivedChatHeight);
			
			
			
			
			var chatTextHeight = chatAppHeight*0.08;
			chatTextHeight = chatTextHeight.toString()+"px";
			$('#chatText').css('height',chatTextHeight);
			
			if(chatAppHeight>535){
				chatAppHeight=535;
			}
			$('#chattingApp').css('background-size','100% '+chatAppHeight.toString()+'px');	
			
			
			var chatSendBtnParentPaadingTop = chatAppHeight*0.02;
			var chatSendBtnParent = $('#chatSendBtn').parent();
			$(chatSendBtnParent).css('padding-top',chatSendBtnParentPaadingTop.toString()+'px');
			
		}
	</script>


</html>