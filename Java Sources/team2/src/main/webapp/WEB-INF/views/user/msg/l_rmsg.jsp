<%@page import="com.in.team2.vo.MsgVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>

<style>
.pageIndex:HOVER {cursor: pointer}
.msgTitleList:HOVER {background-color: gray; cursor: pointer;}
</style>


<script src='/jquery/jquery-3.2.1.js'></script>

<script>
	var pageNum = 1;
	
	<%if(request.getAttribute("pageNum")!=null){%>
		pageNum=<%=request.getAttribute("pageNum")%>
	<%}%>
	
	$(function(){
		$(window).ready(function(){
			$('#pageNum').val(pageNum);
		
		})
		$('.pageIndex').click(function(){
			$('#pageNum').val($(this).text());
			document.location.href='/action/Msg_showRMsgList?pageNum='+$(this).attr('id');
			
			
			/* $('#receivedMSGPost').attr('action','');
			console.log($('#pageNum').val()); */
			/* $('#receivedMSGPost').submit(); */
			
		})
		$('.msgTitleList').click(function(){
			$('#pageNum').val(pageNum);
			$('#msgNum').val($(this).attr('id'));
			$('#receivedMSGPost').attr('action','/action/Msg_showRMsgDetail');
			$('#receivedMSGPost').submit();
		})
		
		$('#sendMsgBtn').click(function(){
			document.location.href='/jsp/user/msg/l_msg_create.jsp?pageNum='+pageNum;
		})
		
		$('.deleteMsgBtn').click(function(){
			if(confirm("このメールを消しますか。")){
				$('#pageNum').val(pageNum);
				$('#msgNum').val($(this).val());
				$('#receivedMSGPost').attr('action','/action/Msg_deleteRMsg');
				$('#receivedMSGPost').submit();
			}
		})
		
	})
	
</script>

<body>

<div>
<div id='menuDiv'>	
		<jsp:include page="/jsp/menubar/menubar.jsp"></jsp:include>
	</div>	
	<div id='chat'>			
		<jsp:include page="/jsp/chat/chat.jsp"></jsp:include>
	</div>

		
	
	
	
	
	
	
	
	<div id='content'>
		
		
		
		
		
		
		
		
		
		
		
		<div style='border-bottom-color: black; border-bottom-style: solid; border-bottom-width: 1px; margin-top: 2vh; margin-left: 2%;'>
			
			<div>
			<button id='showRMsgList'>受信箱</button>
			<button id='showSMsgList'>送信箱</button>
			<button id='sendMsgBtn'>メール作成</button>
		</div><br>
		
		<script>
		$('#showRMsgList').click(function(){
			
				document.location.href='/action/Msg_showRMsgList';
			
		})
		
		
		$('#showSMsgList').click(function(){
			
				document.location.href='/action/Msg_showSMsgList';
			
		})
		</script>
			
			
			
			<h3>受信メール</h3>
		</div>	
		
			
		<div class='msgDiv'>
			<form id='receivedMSGPost' method='post'>
				
			
				 <%/*메세지가 있을 경우 테이블 생성 시작!*/
				 ArrayList<MsgVO> msgList = (ArrayList)request.getAttribute("msgList");
				
				 if(msgList.size()>0){%>
				<table class='msgBoard'>
					<thead class='tableHead'>
						<tr>
							<td>メール番号</td>									
							<td>タイトル</td>
							<td>送信人</td>
							<td>受信日</td>							
							<td>削除</td>
						</tr>
					</thead>
				
					<tbody>
						<%					
						MsgVO msg=null;
						for(int i=0;i<msgList.size();i++){
							msg=msgList.get(i);
						%>
						
						
						<tr>
							<td><%=msg.getMsgNum()%></td>									
							<td class='msgTitleList' id='<%=msg.getMsgNum()%>'><%=msg.getMsgTitle()%><%
								if(msg.getMsgCheck()=='F'){%>
									<%="(新しいメール)" %>
								<%} %></td>
							<td><%=msg.getSenderId()%></td>
							<td><%=msg.getRegDate()%></td>							
							<td><button type="button" value='<%=msg.getMsgNum()%>' class='deleteMsgBtn'>削除</button></td>
						<tr>				
						<%}%>
						
						</tbody>
					</table>
					<%						
				}/*메세지가 있을 경우 테이블 생성 끝!*/
				
				/*메세지가 없을 때 시작!*/
				else{%>
					受信箱が空いています。
				<%} %> 
								
					
							
				
				<input type='hidden' name='pageNum' id='pageNum'>			
				<input type='hidden' name='msgNum' id='msgNum'>		
			</form>
			
			
			
			
			
			
			
			
			
			
			<!-- PAGING START! -->		
	
			<%
		 	long pageNum=(long)request.getAttribute("pageNum");
			long dataNum=(long)request.getAttribute("dataNum");
			long numbs=(long)request.getAttribute("numbs");
			long numbOfPageIndex=10; //한 페이지에 들어가는 페이지 인덱스의 수
			%>
			
			
			
			<!-- 페이지 번호가 numbOfPageIndex의 배수가 아닐 떄 시작! -->			
			<%if(pageNum%numbOfPageIndex!=0){%>
				
				<%	long firstPage=(long)(pageNum/numbOfPageIndex)*numbOfPageIndex+1;
					long lastPage=(long)(pageNum/numbOfPageIndex)*numbOfPageIndex+numbOfPageIndex;					
					
					long endPage=dataNum/numbs;
					if(dataNum%numbs!=0){
						endPage+=1;
					}					
					if(lastPage>endPage){
						lastPage=endPage;
					}
				%>
				
				<%if(pageNum>numbOfPageIndex){%>
					<a class='pageIndex' id='<%=firstPage-1%>'>前に</a>				
				<%}%>
								
				<%for(long i=firstPage;i<=lastPage;i++){%>
				 	<a class='pageIndex' id='<%=i %>'
				 	
				 	<%//현재 페이지일 때 붉게 표시!
				 	if(pageNum==i){%>				 		
				 		style='color: red;'				 					 	
				 	<%} %>
				 	
				 	><%=i%></a>			
				<%}%>
				
				<%if(dataNum>lastPage*numbs){%>
				 	<a class='pageIndex' id='<%=lastPage+1 %>'>次に</a>			
				<%}%>
			<!-- 페이지 번호가 numbOfPageIndex의 배수가 아닐 떄 끝! -->
			
			
			<!-- 페이지 번호가 numbOfPageIndex의 배수일 때 시작! -->		
			<%}else{%>			
				<%if(pageNum>numbOfPageIndex){%>
					<a class='pageIndex' id='<%=pageNum-numbOfPageIndex %>'>이전 페이지로</a>				
				<%} %>
				
				<%for(long i=pageNum-(numbOfPageIndex-1);i<=pageNum;i++){%>
					<a class='pageIndex' id='<%=i%>'
					<%//현재 페이지일 때 붉게 표시!
					if(pageNum==i){%>
				 		style='color: red;'				 	
				 	<%} %>
					><%=i%></a>					
				<%}%>
				
				<%if(dataNum>pageNum*numbs){%>
					<a class='pageIndex' id='<%=pageNum+1%>'>다음 페이지로</a>				
				<%} %>				
			<%}%>			
			<!-- 페이지 번호가 numbOfPageIndex의 배수일 때 끝! -->
			
							
			<!-- PAGING END! -->
		</div>
		
		
		
	
		
	</div>
		<!-- content div ends-->
		
		
		
		
		
		
		
		
		
	<div id='commercial' align="center">		
		<jsp:include page="/jsp/ad/ad.jsp"></jsp:include>
	</div>				
	<div id='footer' align="center">		
		<jsp:include page="/jsp/footer/footer.jsp"></jsp:include>
	</div>	
	
</div>

</body>
</html>