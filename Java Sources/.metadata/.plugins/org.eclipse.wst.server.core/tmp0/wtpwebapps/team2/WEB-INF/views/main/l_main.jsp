<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>l_main</title>
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
		<div style='border-bottom-color: black; border-bottom-style: solid; border-bottom-width: 1px; margin-top: 2vh; margin-left: 2%;'>
	<select style='height: 3vh;'>
		<option value='sell'>판매물 검색</option>
		<option value='buy'>구매물 검색</option>
		<option value='both'>모두 검색</option>
	</select>
				
	<select style='height: 3vh;'>
		<option value='category'>상품 카테고리</option>
		<option value='item_name'>상품명</option>
		<option value='title'>게시물 제목</option>
		<option value='content'>게시물 내용</option>
		<option value='userId'>작성자</option>
		<option value='titleAndContent'>제목+내용</option>
	</select>
				
	<input type='text' style='height: 3vh; width: 30%;' placeholder='검색 키워드를 입력해주세요.'>
	<button id = 'searchBtn' type="button" style='height: 3vh;'>검색</button>
</div>
			
<div>
	
		<%if(session.getAttribute("userId")==null){%>
		<div align="center" >
			<h3>아이디나 비밀번호를 다시 한번 확인해 주세요</h3>
			<button style="width: 15%" onclick="document.location.href='/jsp/logIn/logIn.jsp'">로그인</button >
		</div>
		<%} else{ %>
			<a>${sessionScope.userId}님, 환영합니다!</a>
			<h3>loged-in</h3>
		<%} %>

	
</div>
	</div>
		
		
		
		
	<div id='commercial' align="center">		
		<jsp:include page="/jsp/ad/ad.jsp"></jsp:include>
	</div>				
	<div id='footer' align="center">		
		<jsp:include page="/jsp/footer/footer.jsp"></jsp:include>
	</div>	
	
	
</div>

</body>
</html>