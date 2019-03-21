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
            //var title = document.form1.title.value; ==> name속성으로 처리할 경우
            //var content = document.form1.content.value;
            //var writer = document.form1.writer.value;
            var postTitle = $("#postTitle").val();
            var postPhoto = $("#postPhoto").val();
            var itemCategory = $("#itemCategory").val();
            var itemName = $("#itemName").val();
            var itemClass = $("#itemClass").val();
            var writer = $("#postContent").val();
            if(postTitle == ""){
                alert("제목을 입력하세요");
                document.form1.postTitle.focus();
                return;
            }
            if(postPhoto == ""){
                alert("사진을 입력하세요");
                document.form1.postPhoto.focus();
                return;
            }
            if(itemCategory == ""){
                alert("카테고리를 입력하세요");
                document.form1.itemCategory.focus();
                return;
            } if(itemName == ""){
                alert("상품명을 입력하세요");
                document.form1.itemName.focus();
                return;
            }
            if(itemClass == ""){
                alert("상품등급을 입력하세요");
                document.form1.itemClass.focus();
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
		
		<form name="form1" action='/action/B_post_modifyPost/${modify.postNum}' method = 'post' enctype="multipart/form-data">
			
			<div style='height:16.7vh; width: 90%; margin-top: 5vh; margin-left: 5%;'>
				<!-- 제목 div 시작 -->
				<div style='height:5vh; width: 90.2%; border: 1px solid black;'>
					<input name = 'postTitle' id = 'postTitle' type='text' style='width: 99.5%; height: 4.5vh;' placeholder="제목을 입력하세요" value="${modify.postTitle}" >		
				</div>
				<!-- 제목 div end-->
				
				<!-- photo div start-->
				<div style='height:16.7vh; width: 60%; border: 1px solid black; float: left'>
					<input type="file" id="postPhotoFile" name='fileName' style='width:99%; height: 5vh; '>
					<input type='hidden' id='postPhoto' name='postPhoto' >
    
					<script>
    					$('#postPhotoFile').change(function(){
    					$('#postPhoto').val($('#postPhotoFile').val());    		
    					})
    				</script>
    				
					<input id="userId" name='userId' type="hidden" value="user1" >
				</div>
				<!-- photo div end-->
				
				<!-- informatoin div start-->
					
					<div style='height:16.7vh; width: 30%; border: 1px solid black; float: left'>
						<input id="itemCategory" name='itemCategory' type="text" placeholder='상품 카테고리' value="${modify.itemCategory}" style='width:98.8%; height: 5vh; '><br>
						<input id="itemName" name='itemName' type="text" placeholder='상세 상품명' value="${modify.itemName}" style='width:98.8%; height: 5vh;'><br>
						<input type="text" readonly="readonly" value="상품 등급 선택" style='width:45.8%; height: 4.8vh;'>
						<select id="itemClass" name='itemClass' style="width:50.2%; height: 5.5vh;">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</div>			
				<!-- informatoin div ends-->
			</div>
			
			<!-- post Content div start-->
			<div style='width: 81.5%; margin-top: 5vh; margin-left: 5%;'>		
				<textarea id="postContent" name='postContent' placeholder='게시물 설명'  style="width: 99%; height: 25vh; resize: none;">${modify.postContent} </textarea>
				<div style='width: 99.5%' align="center">
					<button type="button" id="btnSave">수정</button>
					<button type="button" onclick="document.location.href='/action/B_post_showList'">목록으로 돌아가기</button>
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