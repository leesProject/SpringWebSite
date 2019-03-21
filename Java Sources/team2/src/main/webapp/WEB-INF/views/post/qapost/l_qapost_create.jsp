<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src='/jquery/jquery-3.2.1.js'></script>
<script>
    $(document).ready(function(){
        $("#btnSave").click(function(){
            var postTitle = $("#postTitle").val();
            var writer = $("#postContent").val();
            if(postTitle == ""){
                alert("제목을 입력하세요");
                document.form1.postTitle.focus();
                return;
            }
            if(postContent == ""){
                alert("내용을 입력하세요");
                document.form1.postContent.focus();
                return;
            }
            document.form1.submit();
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
		<form name="form1" action='/action/QA_post_createPost' method = 'post'>
			<div style='width: 90%; margin-top: 5vh; margin-left: 5%;'>
				<!-- 제목 div 시작 -->
				<div style='height:5vh; width: 90.2%;'>
					<input name = 'postTitle' id = 'postTitle' type='text' style='width: 99.5%; height: 4vh;' placeholder="제목을 입력하세요">		
				</div>
				<!-- 제목 div end-->				
			</div>
			
			<input id="userId" name='userId' type="hidden" value="user1" >
			
			<!-- post Content div start-->
			<div style='width: 81.5%; margin-top: 1vh; margin-left: 5%;'>		
				<textarea name= 'postContent' id="postContent" placeholder="내용을 입력하세요" style="resize: none; width: 99%; height: 60vh;" ></textarea>
				<div style='width: 99.5%' align="center">
					<button type="button" id="btnSave">등록</button>
					<button type="button" onclick="document.location.href='/action/QA_post_showList'">목록으로 돌아가기</button>
				</div>
			</div>	
			<!-- post Content div end-->
		
		</form>
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
		$('window').resize(function() {
			$('#footer').css('margin-top',$('#content').css('height'));
		})		
	</script>
</div>
</body>
</html>