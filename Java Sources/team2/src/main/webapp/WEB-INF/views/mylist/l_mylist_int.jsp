<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.in.team2.vo.PostVO"%>
<%@page import="com.in.team2.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src='/jquery/jquery-3.2.1.js'></script>
<style>
.postBoard {border-collapse: collapse;}
.postBoard tr{cursor:pointer;}
.postBoard tr:HOVER {background-color: gray;}
.tableHead td{border: 1px solid black;width: 10%;}
</style>
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
								
			<select style="height: 3vh;">
				<option value="category">상품 카테고리</option>
				<option value="item_name">상품명</option>
				<option value="title">게시물 제목</option>
				<option value="content">게시물 내용</option>
				<option value="userId">작성자</option>
				<option value="titleAndContent">제목+내용</option>
			</select>
				
			<input type="text" style="height: 3vh; width: 30%;" placeholder="검색 키워드를 입력해주세요.">
			<button id = 'searchBtn' type="button" style="height: 3vh;">검색</button>
			<a href = "/jsp/post/s_post/l_spost_create.jsp"><button id = 'searchBtn' type="button" style="height: 3vh;">글쓰기</button></a>
		
		<%if(session.getAttribute("userId")!=null){%>
			<a class = 'menu' onclick="document.location.href='/action/S_post_showMySellList'"><button type="button" style="height: 3vh;">내 판매게시물 보기</button></a>
		 <%} %>
		
		
		</div>
			
		<div>
			<h1>MyInterestList page</h1>
	
	<form class="MyList">
		<input name='postNum' type="hidden" id='postNum'>
			<table class='postBoard'>
				
				<thead>
					<tr class='tableHead'>
						<td align="center" style='width: 8% '>등록 번호</td>
						<td align="center" style='width: 20% '>사진</td>
						<td align="center" style='width: 10% '>카테고리</td>
						<td align="center" style='width: 10% '>상품명</td>
						<td align="center" style='width: 5% '>상품 등급</td>
						<td align="center" style='width: 27% '>제목</td>
						<td align="center" style='width: 10% '>작성자</td>
						<td align="center" style='width: 10% '>등록일자</td>				
						<td></td>
					</tr>
				</thead>
			
				<tbody>
<%
	List<PostVO> postMyList = (List)request.getAttribute("myListList");
		if(postMyList.size()>0){
			for(int i=0;i<postMyList.size();i++){
				PostVO post = postMyList.get(i);
%>
	<tr onclick="getPost(this)" id ='<%=post.getPostNum() %>'>
		<td align="center" id='postNum'><%=post.getPostNum() %></td>
		<td align="center" id='postPhoto'> <img src="<%="/"+post.getPostPhoto() %>" style='width: 100%;height: 10vh'> </td>
		<td align="center" id='itemCategory'><%=post.getItemCategory()%></td>
		<td align="center" id='itemName'><%=post.getItemName()%></td>
		<td align="center" id='itemClass'><%=post.getItemClass()%></td>
		<td align="center" id='postTitle'><%=post.getPostTitle() %></td>
		<td align="center" id='userId'><%=post.getUserId()%></td>
		<td align="center" id='regDate'><%=post.getRegDate()%></td>	
	</tr>	
<%}}%>		

			
				</tbody>
			</table>
		</form>
			
			<script >
		/* onclick 상세보기로 넘어가기 */	
			var postNum = -1;
			function getPost(data){
				postNum=data.id;
				document.location.href='/action/S_post_showDetail?postNum='+postNum;
			}
			</script>
		
		</div>
	</div>
	<!-- content div ends-->
		
		
		
		
		
		
		
		
		
	<div id='commercial' align="center">		
		<jsp:include page="/jsp/ad/ad.jsp"></jsp:include>
	</div>				
	<div id='footer' align="center">		
		<jsp:include page="/jsp/footer/footer.jsp"></jsp:include>
	</div>
	
	<script>			
	
	/* 관심목록 삭제 */
		$('.DeleteMyList').click(function(){
			$('#postNum').val($(this).attr('id'));
		 	$('.MyList').attr('action','/action/User_deleteMyList')
		 	$('.MyList').attr('method','post');
		 	$('.MyList').submit();
		})

	</script>
</div>
</body>
</html>