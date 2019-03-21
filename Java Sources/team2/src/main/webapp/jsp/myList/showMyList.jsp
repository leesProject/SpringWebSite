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
		
		</div>
			
		<div>
			<h1>MyList page</h1>
		
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
					</tr>
				</thead>
			
				<tbody>
				<%for(int i=1;i<=3;i++){%>
					<tr onclick="getPost(this)" id ='<%=i%>'>
						<td align="center" id='postNum'><%=i %></td>
						<td align="center" id='postPhoto'><img src='/img/sell_example/sell<%=i%>.jpg' style="width: 50%;height: 5vh;"></td>
						<td align="center" id='itemCategory'>카테고리</td>
						<td align="center" id='itemName'>관심상품<%=i %></td>
						<td align="center" id='itemClass'>s+</td>
						<td align="center" id='postTitle'><%="이거 판다"+i %></td>
						<td align="center" id='userId'>판매자<%=i %></td>
						<td align="center" id='regDate'>등록일자<%=i %></td>
					</tr>	
				<%}%>
				</tbody>
			</table>
		
			<script >
				var postNum = -1;
				function getPost(data){
					postNum=data.getAttribute('id');
					document.location.href='/action/myList_showDetail.action?postNum='+postNum;
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
	
</div>
</body>
</html>