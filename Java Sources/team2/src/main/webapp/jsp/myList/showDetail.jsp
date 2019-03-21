<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src='/jquery/jquery-3.2.1.js'></script>

<body>




<div>
	<div id='menuDiv'>	
		<jsp:include page="/jsp/menubar/menubar.jsp"></jsp:include>
	</div>	
	<div id='chat'>			
		<jsp:include page="/jsp/chat/chat.jsp"></jsp:include>
	</div>
	
	
	
	
	
	
		
	
	
	<div id='content'>
		<div style='height:40vh; width: 90%; margin-top: 5vh; margin-left: 5%;'>
			<!-- 제목 div 시작 -->
			<div style='height:5vh; width: 90.2%; border: 1px solid black;'>
				<div style="float: left;width: 70%;"><a>제목:	postTitle</a></div>
				<div style="float: left;width: 29%;" align="right"><a>작성자: userId	등록일: regDate</a></div>				
			</div>
			<!-- 제목 div end-->
			
			<!-- photo div start-->
			<div style='height:40vh; width: 60%; border: 1px solid black; float: left'>
				<img src = '/img/sell_example/sell${param.postNum}.jpg' style="width: 100%; height: 40vh;">			
			</div>
			<!-- photo div end-->
			
			<!-- informatoin div start-->
			<form id='auctionOrBuyNow' method='post'>
				<input name='postNum' type="hidden" value='${param.postNum}'>
				<div style='height:40vh; width: 30%; border: 1px solid black; float: left'>
					<input type="text" readonly value='상품 카테고리' style='width:99%; height: 5vh; '><br>
					<input type="text" readonly value='상세 상품명' style='width:99%; height: 5vh;'><br>
					<input type="text" readonly value='상품 등급' style='width:50%; height: 5vh;'><a>등급 기준 보기</a><br>
					<input type="text" readonly value='현재가' style='width:99%; height: 5vh;'><br>
					<input type="text" readonly value='즉시 구매가' style='width:99%; height: 5vh;'><br>
					<input id = 'increasePrice' type="text" placeholder="입찰가를 입력해주세요" style='width:99%; height: 5vh;'><br>
					<button id= 'auctonBtn' type="button" style='width:45%; height: 2.5vh;margin-left: 3%;margin-top: 0.5vh'>입찰하기</button>
					<button id= 'buyNowBtn' type="button" style='width:45%; height: 2.5vh; margin-top: 0.5vh'>즉시구매</button><br>
					<button id= 'actuonCancelBtn' type="button" style='width:45%; height: 2.5vh; margin-left: 3%'>입찰취소</button>
					<button id= 'myListBtn' type="button" style='width:45%; height: 2.5vh;'>관심상품 등록</button>
				</div>
			</form>
			<!-- informatoin div ends-->
		</div>
		
		<!-- post Content div start-->
		<div style='width: 81.5%; margin-top: 5vh; margin-left: 5%;'>		
				<p>게시물 내용: SELECT POST_CONTENT FROM S_POST WHERE POST_NUM = postNum<br>
				게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	
				게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	
				게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	게시물 내용입니다	
				</p>			
		</div>	
		<!-- post Content div end-->
		
		
		<!-- comment Content div start-->
		<div style='margin-top: 5vh;' align="center">
			<h3>댓글 내용입니다.</h3>
				<table style='width: 81.5%;'>
				<%for(int i=1;i<=10;i++){%>
					<tr style='width: 100%;'>
						<td style='width: 10%; border: 1px solid black;'>
							작성자<%=i %>
						</td>
						
						<td style='width: 70%; border: 1px solid black;'>
							작성내용<%=i %>
						</td>
						
						<td style='width: 20%; border: 1px solid black;'>
							작성일자<%=i %>
						</td>
					</tr>
				<%} %>
				
				
				<%if(session.getAttribute("userId")!=null){%>
					<tr style='width: 100%;'>
						<td>
							<input type='text' readonly="readonly" value="${sessionScope.userId}">
						</td>
							
						<td>
							<input type='text' style='width: 99%;' placeholder="댓글 내용입력하세요">
						</td>
						<td align="center">
							<button type='button'>댓글 등록</button>
						</td>						
					</tr>
				<%} %>				
				</table>				
		</div>	
		<!-- comment Content div end-->			
	</div>
	<!-- content div ends-->
		
		
	
	<script>
		$('#auctonBtn').click(function() {
			if(confirm($('#increasePrice').val()+'원에 입찰하시겠습니까?')){
				alert($('#increasePrice').val()+'원에 입찰되었습니다!');
			}
		})
		$('#buyNowBtn').click(function() {
			if(confirm('itemMaxPrice원에 즉시구매 하시겠습니까?')){
				$('#auctionOrBuyNow').attr('action','/action/s_post_buyNow.action');
				$('#auctionOrBuyNow').submit();
			}
		})
		$('#myListBtn').click(function() {
			if(confirm('관심상품 목록에 등록하시겠습니까?')){				
			}
		})
	</script>
	
	
		
		
		
		
		
		
	<div id='commercial' align="center">		
		<jsp:include page="/jsp/ad/ad.jsp"></jsp:include>
	</div>				
	<div id='footer' align="center">		
		<jsp:include page="/jsp/footer/footer.jsp"></jsp:include>
	</div>	
	
</div>
</body>
</html>