<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>l_fid.jsp</title>
</head>
<script src='/jquery/jquery-3.2.1.js'></script>

<c:if test="${!empty param.searchIdError}">

<script>
$(function(){
	$(window).ready(function(){
		alert('${param.searchIdError}');
	})
})


</script>
</c:if>

<body>




<div>
	<div id='menuDiv'>	
		<jsp:include page="/jsp/menubar/menubar.jsp"></jsp:include>
	</div>	
	<div id='chat'>			
		<jsp:include page="/jsp/chat/chat.jsp"></jsp:include>
	</div>
		
		
			
	<div id='content'>
		<div style='width: 99.8%; height: 50vh;' align='center'>
		
		<form method="post" action="/action/User_searchId" >
			<div style='width:100%;margin-top: 30vh;'>	
				<div style="display: table; width: 60%;">
					<div style="display: table-row; ">
						<div style="display: table-cell; " align="center">
							가입하신 이메일을 입력해 주세요.
						</div>
					</div>
				<div style="display: table-row; ">
					<div style="display: table-cell; padding-top: 2vh;">
						<input type="email" id="userEmail" name="userEmail" style="width: 99.8%; height: 5vh;">
					</div>
				</div>				
			</div>
		</div>
		
		
		<button type="submit" style="margin-top: 2vh;">확인</button>
		</form>
	
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