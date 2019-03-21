<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>

table {border: 1px solid black; margin-left: 10px;}
td {border: 1px solid black;}
</style>

<script src='/jquery/jquery-3.2.1.js'></script>

<script>
/* 게시물 입찰자 리스트 팝업 */

var postNum=${param.postNum};

$(function(){
	$(window).ready(function(){
		$.ajax({
			url:'/action/User_showSAuctionList',	
			type:'POST',					
			dataType:'xml',
			data:{postNum:postNum},
			success:function(data){
				var buyers=$(data).find('buyerId');
				var itemCurPrices=$(data).find('itemCurPrice');
				
				
				$('body').append("<h3>입찰 참여자 목록</h3>");
				$('body').append("<table>");
				$('table').append("<tr><td>입찰자</td><td>입찰가격</td></tr>");
				
				for(i=0;i<buyers.length;i++){
						var buyer=buyers[i];
						var price=itemCurPrices[i];
					$('table').append("<tr><td>"+$(buyer).text()+"</td><td>"+$(price).text()+"</td></tr>");
				}			
				$('body').append("</table>");
			},
			
			error:function(e){
					
			}
		})
	})
})
</script>


<body>

</body>
</html>