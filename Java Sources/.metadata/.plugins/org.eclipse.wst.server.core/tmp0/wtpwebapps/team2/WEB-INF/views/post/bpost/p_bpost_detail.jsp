<%@page import="com.in.team2.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.in.team2.vo.CommentVO"%>
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
        $("#modify").click(function(){
            document.form1.action="/action/B_post_updatePost/${detail.postNum}";
            document.form1.submit();
        });
        $("#delete").click(function(){
        	if(confirm("삭제하시겠습니까?")){
        	document.form1.action="/action/B_post_deletePost" ;
            document.form1.submit();
        	}
        });
       
    });
</script>

<body>


<div>
	<div id='menuDiv' style='width: 100%; height: 10vh; border-color: black; border-style: solid; border-width: 1px;'>		
		<jsp:include page="/jsp/menubar/menubar.jsp"></jsp:include>
	</div>	
	<div id='chat' style='width: 20%; height: 80vh; border-color: black; border-style: solid; border-width: 1px; float: left;' align="center">			
		<jsp:include page="/jsp/chat/chat.jsp"></jsp:include>
	</div>
	
	
	
	<div id='content' style='width: 60%; border-color: black; border-style: solid; border-width: 1px; float: left; min-height: 80vh;overflow: auto;'>		
		
		<form name="form1" method = 'post'>
		
		<div style='height:40vh; width: 90%; margin-top: 5vh; margin-left: 5%;'>
			<!-- 제목 div 시작 -->
			<div style='height:5vh; width: 90.2%; border: 1px solid black;'>
				<div style="float: left;width: 50%;"><a>제목: ${detail.postTitle}</a></div>
				<div style="float: left;width: 14%;" align="right"><a>작성자: ${detail.userId}</a></div>	
				<div style="float: left;width: 35%;" align="right"><a>등록일: <fmt:formatDate value="${detail.regDate}" pattern="yyyy-MM-dd a HH:mm:ss"/></a></div>			
			</div>
			<!-- 제목 div end-->
			
			<!-- photo div start-->
			<div style='height:40vh; width: 60%; border: 1px solid black; float: left'>
				<img src = '/${detail.postPhoto }' style="width: 100%; height: 40vh;">			
			</div>
			<!-- photo div end-->
			
			<!-- informatoin div start-->
			<input name='postNum' type="hidden" value='${detail.postNum}'>
			<div style='height:40vh; width: 30%; border: 1px solid black; float: left;'>
				<input type="text" readonly value='상품 카테고리 : ${detail.itemCategory}' style='width:98.81%; height:25%; '><br>
				<input type="text" readonly value='상세 상품명 : ${detail.itemName}' style='width:98.81%; height: 25%; '><br>
				<input type="text" readonly value='상품 등급 : ${detail.itemClass}' style='width:49%; height: 25%;' ><a>등급 기준 보기</a><br>
				<input type="text" readonly value='쪽지 보내기' style='width:98.81%; height: 7.6vh; '><br>				
			</div>		
			<!-- informatoin div ends-->
		</div>
		<!-- post Content div start-->
		
		<div style='width: 81.2%; margin-top: 5.3vh; margin-left: 5%; border: 1px solid black'>		
				<div style="padding-top: 2vh;">
				${detail.postContent}				
				</div>
				
			<%
			PostVO detail = (PostVO)request.getAttribute("detail");
			if(session.getAttribute("userId")!=null&&session.getAttribute("userId").equals(detail.getUserId())){
			 %>
			<button id = 'modify' type="button" style="height: 3vh; float: right;">게시글 수정</button>
			<%} %>
			<%if(session.getAttribute("userId")!=null&&(session.getAttribute("userId").equals(detail.getUserId())||session.getAttribute("userId").equals("ADMIN"))){%>
			<button id = 'delete' type="button" style="height: 3vh; float: right;">게시글 삭제</button>
			<%} %>
		</div>	
		</form>
		<%
			List <CommentVO> commentList =(List)request.getAttribute("comment");
			if(commentList.size()>0){
			%>
		<!-- post Content div end-->
		<div style='margin-top: 5vh;' align="center">
			<h3>댓글</h3>
		</div>
		<%} %>
		<!-- comment Content div start-->
		<%
			for(int t=0;t<commentList.size();t++){
				CommentVO result = commentList.get(t);
				
			%>
		<div style='margin-top: 5vh;' align="center">
				
			<div style='height:15vh; width: 90%; border: 1px solid black; '>	
				<div>
					<input id="userId" name='userId' readonly value="<%=result.getUserId() %>" style='height:5vh; width: 10%;  float: left'>
				</div>
				<div>
					<input value="<%=result.getRegDate() %> " readonly="readonly" id="regDate" name='regDate' type="text" style='height:5vh; width: 79.2%;  float: left'>
				</div>
			
			
				<div>
					<%if(session.getAttribute("userId")!=null&&session.getAttribute("userId").equals(result.getUserId())){ %>
					<button id='<%=result.getCommentNum()%>' class="update" type="button" style='height:54px; width: 5%; float: left;' >댓글 수정</button>
					<%}%>
					<%if(session.getAttribute("userId")!=null&&(session.getAttribute("userId").equals(result.getUserId())||session.getAttribute("userId").equals("ADMIN"))){%>
					<button id='<%=result.getCommentNum()%>' class = 'deletebtn' type="button" style='height:54px; width: 5%; float: left' >댓글 삭제</button>
					<%}%>
				</div>
			
			  
				<div>
			 	<textarea id="comment<%=result.getCommentNum()%>" readonly style='height:83px; width: 99.4%; resize: none; float: left'><%=result.getCommentContent() %></textarea>
				
				</div>
			</div>
				
		</div>	
		<%
		}
		%> 
		
		<%if(session.getAttribute("userId")!=null){ %>
		<form id="form3" name="form3" method = 'post' >
		<div style='margin-top: 5vh; margin-bottom: 5vh; '  align="center">
		
			<h3>댓글 입력</h3>
			<input id="userId" name='userId' type="hidden" value=${sessionScope.userId }>
			<input id="postNum" name='postNum' type="hidden" value=${detail.postNum } >
			<input type='hidden' name='commentNum' id='commentNum' value=0>
			<table style='width: 81.5%;'>
				<tr style='width: 100%;'>
					<td>
						<textarea rows="5" cols="80" id="commentContent" name="commentContent" style='width: 99%;
						resize: none; ' placeholder="댓글을 작성해주세요"></textarea>
					</td>
					<td align="center">
						<button type='button' id = 'createbtn'>댓글 등록</button>
					</td>						
				</tr>	
			</table>
		</div>
		</form>
		<% }%>
		<!-- comment Content div end-->			
	</div>
	
	<!-- content div ends-->
	<script type="text/javascript">
		$(".deletebtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
			$('#commentNum').val($(this).attr('id'));
			document.form3.action="/action/B_post_deleteComment/${detail.postNum}";
			document.form3.submit();
			}
		});
		
		 var flag = false;
		
		 $(".update").click(function(){
			 var id = $(this).attr('id');
			var comment = $("#comment"+id).val();
			
			if(flag == false){
			 /* $("#comment"+id).attr("readonly", false);  */
			  $("#comment"+id).removeAttr("readonly")  
			 flag=true;
			}
			
			else if(flag == true){
			  if (comment == ""){
					alert("제목을 입력하세요");
					return;
				} 
				$("#commentNum").val(id);
				$("#commentContent").val(comment);
				/* 
				$("#form3").attr('action', '/action/B_post_modifyComment/${detail.postNum}')
				$("#form3").attr('method', 'post');
				$("#form3").submit();   
				*/
				document.form3.action="/action/B_post_modifyComment/${detail.postNum}";
				document.form3.submit(); 
			}
			
		});
			 
		$("#createbtn").click(function(){
			var commentContent = $("#commentContent").val();
	        if(commentContent == ""){
	        	alert("제목을 입력하세요");
	            document.form3.commentContent.focus();
	            return;
	        }
	    document.form3.action="/action/B_post_createComment/${detail.postNum}";
	    document.form3.submit();
		});
		</script>
	
		
		
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
		$('window').resize(function() {
			$('#footer').css('margin-top',$('#content').css('height'));
		})		
	</script>
</div>
</body>
</html>