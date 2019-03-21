<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="/jquery/jquery-3.2.1.js"></script>
<script src="http://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script src="/jquery/jquery_validate_additionalREX.js"></script>


<script>	
	var emailDuplicated = false;
</script>
<c:if test='${!empty param.modifyError}'>
<script>	
	alert('${param.modifyError}');
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
			<div style='margin-top: 30vh;'>	
			
			<form method="post" id='modifyForm' action='/action/User_modify'>				
				<div style="display: table; width: 40%;">
				
					<div style="display: table-row;">
						<div style="display: table-cell;">
							暗証番号 : 
						</div>
						<div style="display: table-cell;">
							<input type='password' style="width: 99.8%; height: 2vh;"  id="userPw" name="userPw"  >
						</div>
					</div>
					
					<div style="display: table-row;">
						<div style="display: table-cell;">
							暗証番号確認 : 
						</div>
						<div style="display: table-cell;">
							<input type='password' style="width: 99.8%; height: 2vh;"  id="confirmPw" name="confirmPw"  >
						</div>
					</div>
				
													
					<div style="display: table-row;">
						<div style="display: table-cell;">
							お名前 : 
						</div>
						<div style="display: table-cell;">
							<input type='text' style="width: 99.8%; height: 2vh;"   value="${user.userName }" name="userName"  >
						</div>
					</div>
					<div style="display: table-row;">
						<div style="display: table-cell;">
							メール : 
						</div>
						<div style="display: table-cell;">
							<input type="text" style="width: 99.8%; height: 2vh;" value="${user.userEmail }" name="userEmail" id='userEmail'>
							
						</div>						
					</div>
					
					
					<div style="width: 250%" align="center">
						<button type='button' id='emailDuplicatedCheck' style='min-width: 100px'>重複確認</button>
					</div>
			
					
					<div style="display: table-row;">
						<div style="display: table-cell;">
							連絡先 : 
						</div>
						<div style="display: table-cell;">
							<input type="text" style="width: 99.8%; height: 2vh;" value="${user.userPhone }" name="userPhone"  >
						</div>
					</div>
				</div>			
				
				<div align="center">
					<button type="button" id='modifyBtn' style='margin-top:2vh;'>完了</button>
				</div>		
</form>				
			</div>	
		</div>			
	</div>	
			
	
	
	
	<div id='commercial' align="center">		
		<jsp:include page="/jsp/ad/ad.jsp"></jsp:include>
	</div>				
	<div id='footer' align="center">		
		<jsp:include page="/jsp/footer/footer.jsp"></jsp:include>
	</div>	
	
	
	
	<script>
	$(function() {
	    $('#modifyForm').validate({
	        debug: false,
	        onfocusout: false,
	        rules: {
	        	userPw: {
	                 required: true,
	                 rangelength: [6, 20],
	                 pwRex:true
	             }, confirmPw: {
	                 required: true,
	                 rangelength: [6, 20],
	                 equalTo: '#userPw'
	             },
	           	 userName: {
	                 required: true,
	                 rangelength: [2, 20],
	                 nameRex: true
	             }, userEmail: {
	                 required: true,
	                 emailRex: true,
	                 rangelength: [6, 30],
	             }, userPhone: {
	            	 required: true,
	            	 rangelength: [6, 20],
	            	 phoneRex: true
	             }
	        }, messages: {
	        	userPw: {
	                 required: "暗証番号を入力してください。",
	                 rangelength: "暗証番号は６文字から２０文字まで可能です。",
	                 pwRex: '暗証番号は大文字・小文字の英文、数字、ハングル、特殊文字!@#$%^&が可能です。'
	             }, confirmPw: {
	                 required: "暗証番号を確認してください。",
	                 rangelength: "暗証番号は６文字から２０文字まで可能です。",
	                 equalTo: '暗証番号一致しません。確認してください。'
	             },	userName: {
	                 required: "お名前を入力してください。",
	                 rangelength: "お名前は２文字から２０文字まで可能です。",
	                 nameRex:'暗証番号は大文字・小文字の英文、数字、ハングルが可能です。'
	             }, userEmail: {
	                 required: "メールを入力してください。",
	                 emailRex: "正しい形式ではございません。",
	                 maxlength: "メールは６文字から３０文字まで可能です。"
	             }, userPhone: {
	            	 required: "連絡先を入力してください。",
	            	 rangelength: "６文字から２０文字まで可能です。",
	            	 phoneRex: "数字のみ入力してください。"
	             } 	
	        	
	           
	        }, errorPlacement: function(error, element) {
	        	 error.insertAfter(element);	        	
	        }
	    });
	    
	    
	    //이메일 중복 확인 했는지//
	    $('#modifyBtn').click(function(){	    	
	    	if(emailDuplicated==true){
	    		$('#modifyForm').submit();
	    	}	    	
	    	else if(emailDuplicated==false){
	    		alert('メール重複検査してください！');
	    	}
	    })
	    
	    
	    
	    //이메일 변화 시 중복확인 초기화//	  	    
	    $('#userEmail').change(function(){
	    	emailDuplicated=false;
	    })
	    
	    
	    
	    $('#emailDuplicatedCheck').click(function(){
	    	console.log('DDD');
	    	var userEmail=$('#userEmail').val();
	    	if(userEmail.match(/^[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+)$/)){
	    		
	    		if(userEmail.length>=6&userEmail.length<=30){
	    			$.ajax({
			    		url:'/action/User_emailDuplicatedCheck2',
			    		type:'post',
			    		data: {userEmail:userEmail},
			    		dataType:'xml',
			    		success:function(data){
			    			var result = $(data).find('result').text().trim();
			    			result=Number(result);
			    			console.log($(data).find('result').text().trim());
			    			if(result==0){
			    				emailDuplicated=true;			    			
			    				alert('使用可能なメールです。');
			    			}
			    			else if(result==1){
			    				alert('すでに使用中でございます。他のメールを入力してください。');
			    			}
			    			else{
			    				console.log('WTF!!!!');
			    			}
			    		},
			    		error:function(e){
			    			console.log(e.message);
			    		}
			    	})
	    		}
	    		else{
	    			alert('メールは６文字から３０文字まで可能です。');
	    		}	    		
	    	}
	    	else{
	    		alert('正しい形式ではございません。');
	    	}
	    	
	    })
	    
	});
	</script>
	
</div>

</body>
</html>