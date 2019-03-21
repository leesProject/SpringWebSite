<%@page import="com.in.team2.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src='/jquery/jquery-3.2.1.js'></script>
<script>
$(document).ready(function(){
	$('#postBtn').click(function(){
	location.href="/action/QA_post_insertPost";
	})	;
});
</script>
<style>
.postBoard {border-collapse: collapse;}
.postBoard tr{cursor:pointer;}
.postBoard tr:HOVER {background-color: gray;}
.tableHead td{border: 1px solid black;width: 10%;}
</style>
<body>




<div>
	<div id='menuDiv' style='width: 100%; height: 10vh; border-color: black; border-style: solid; border-width: 1px;'>		
		<jsp:include page="/jsp/menubar/menubar.jsp"></jsp:include>
	</div>	
	<div id='chat' style='width: 20%; height: 80vh; border-color: black; border-style: solid; border-width: 1px; float: left;' align="center">			
		<jsp:include page="/jsp/chat/chat.jsp"></jsp:include>
	</div>
		
	
	
	<div id='content' style='width: 60%; border-color: black; border-style: solid; border-width: 1px; float: left; min-height: 80vh;overflow: auto;'>		
		<form name="formfor" method="post" action="/action/QA_post_showList">
		<div style='border-bottom-color: black; border-bottom-style: solid; border-bottom-width: 1px; margin-top: 2vh; margin-left: 2%;'>
			
			<select name="searchOption" style="height: 3vh;">
				<option value="all"<c:out value="${map.searchOption == 'all'?'selected':''}"/>>전체검색</option>
				<option value="postTitle"<c:out value="${map.searchOption == 'postTitle'?'selected':''}"/>>게시물 제목</option>
				<option value="postContent"<c:out value="${map.searchOption == 'postContent'?'selected':''}"/>>게시물 내용</option>
				<option value="userId"<c:out value="${map.searchOption == 'userId'?'selected':''}"/>>작성자</option>
			</select>
			<input name="keyword" value="${map.keyword}" style="height: 3vh; width: 30%;" placeholder="검색 키워드를 입력해주세요.">
			<input value="검색" type="submit" style="height: 3vh;">
			<%if(session.getAttribute("userId")!=null){ %>
			<button id = 'postBtn' type="button" style="height: 3vh;">등록</button>
			<%} %>
		</div>
		</form>
					
		<div>
			<h1 align="center">Q/A 게시판</h1>
			<div style="width: 100%" align="center">
				<table class='postBoard'>
					<thead>
						<tr class='tableHead'>
							<td align="center" style='width: 8% '>등록 번호</td>						
							<td align="center" style='width: 27% '>제목</td>
							<td align="center" style='width: 10% '>작성자</td>
							<td align="center" style='width: 10% '>등록일자</td>				
						</tr>
					</thead>
					
					<tbody>
					<c:forEach var="postList" items="${map.list}">
						<tr onclick="getPost(this)" id="${postList.postNum}">
							<td align="center" id='postNum' style='border: 1px solid black;'>${postList.postNum}</td>
							<td align="center" id='postTitle' style='border-bottom: 1px solid black;'><a href="/action/QA_post_showDetail/${postList.postNum }">${postList.postTitle}</a></td>
							<td align="center" id='userId' style='border: 1px solid black;'>${postList.userId}</td>
							<td align="center" id='regDate' style='border: 1px solid black;'>${postList.regDate}</td>
						</tr>
					</c:forEach>
					</tbody>
					
					
					<tr>
						<td colspan="5"><c:if test="${map.boardPager.curPage > 1}">
								<a href="javascript:list('1')">[처음]</a>
							</c:if> <c:if test="${map.boardPager.curBlock > 1}">
								<a href="javascript:list('${map.boardPager.prevPage}')">[이전]</a>
							</c:if> <c:forEach var="num" begin="${map.boardPager.blockBegin}"
								end="${map.boardPager.blockEnd}">
								<c:choose>
									<c:when test="${num == map.boardPager.curPage}">
										<span style="color: red">${num}</span>&nbsp;
                        </c:when>
									<c:otherwise>
										<a href="javascript:list('${num}')">${num}</a>&nbsp;
                        </c:otherwise>
								</c:choose>
							</c:forEach> <c:if
								test="${map.boardPager.curBlock <= map.boardPager.totBlock}">
								<a href="javascript:list('${map.boardPager.nextPage}')">[다음]</a>
							</c:if> <c:if test="${map.boardPager.curPage <= map.boardPager.totPage}">
								<a href="javascript:list('${map.boardPager.totPage}')">[끝]</a>
							</c:if></td>
					</tr>
				</table>
				
				<script >
				var postNum ;
				function getPost(data){
					postNum=data.id;
					document.location.href='/action/QA_post_showDetail/'+postNum;
				}
				function list(page) {
					location.href = "/action/QA_post_showList?curPage="
							+ page + "&searchOption-${map.searchOption}"
							+ "&keyword=${map.keyword}";
				}
				</script>
			</div>
			
		</div>
	</div>
	<!-- content div ends-->
		
		
		
		
		
		
		
		
		
	<div id='commercial' style='width: 19.5%; height: 80vh; border-color: black; border-style: solid; border-width: 1px; float: left;' align="center">		
		<jsp:include page="/jsp/ad/ad.jsp"></jsp:include>
	</div>				
	<div id='footer' style='width: 99.8%; height: 10vh; border-color: black; border-style: solid; border-width: 1px; float: none;' align="center" >		
		<jsp:include page="/jsp/footer/footer.jsp"></jsp:include>
	</div>		
	<script>
		$('#footer').ready(function() {
			$('#footer').css('margin-top',$('#content').css('height'));
		})		
	</script>
</div>
</body>
</html>