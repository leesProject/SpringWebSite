<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src="/jquery/jquery-3.2.1.js"></script>
<script src="http://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script src="/jquery/jquery_validate_additionalREX.js"></script>





<body id='withdrawPopUp'>
	<div align="center">
		<h3>ID,暗証番号、お名前を入力してください。</h3>
	</div>
<div>
<form method="post" id='deleteForm'>	
	<div style="display: table; width: 100%;" align="center">
		<div style="display: table-row; ">
			<div style="display: table-cell; ">
				ID:
			</div>
			<div style="display: table-cell;">
				<input type='text' name="userId" style="width: 99.8%; height: 5vh;" >
			</div>
		</div>
		<div style="display: table-row;">
			<div style="display: table-cell;">
				暗証番号:
			</div>
			<div style="display: table-cell;">
				<input type='password' name="userPw" style="width: 99.8%; height: 5vh;" >
			</div>
		</div>				
		<div style="display: table-row;">
			<div style="display: table-cell;">
				お名前:
			</div>
			<div style="display: table-cell;">
				<input type='text' name="userName" style="width: 99.8%; height: 5vh;" >
			</div>
		</div>
											
	</div>	
		
	<div align="center">
		<button type='button'>脱退する</button>
	</div>
</form>
</div>	
</body>



<script>
	$(function() {
	    $('#deleteForm').validate({
	        debug: false,
	        onfocusout: false,
	        rules: {
	        	userId: {
	                 required: true,
	                 rangelength: [4, 20],
	                 idRex: true 
	             }, userPw: {
	                 required: true,
	                 rangelength: [6, 20],
	                 pwRex:true
	             },  userName: {
	                 required: true,
	                 rangelength: [2, 20],
	                 nameRex: true
	             }
	        }, messages: {
	        	userId: {
	        		required: "IDを入力してください。",
	                rangelength: "IDは４文字から２０文字まで可能です。",
	                idRex:'IDは大文字・小文字の英文、数字、ハングルが可能です。'
	             }, userPw: {
	                 required: "暗証番号を入力してください。",
	                 rangelength: "暗証番号は６文字から２０文字まで可能です。",
	                 pwRex: '暗証番号は大文字・小文字の英文、数字、ハングル、特殊文字!@#$%^&が可能です。'
	             }, userName: {
	                 required: "お名前を入力してください。",
	                 rangelength: "お名前は２文字から２０文字まで可能です。",
	                 nameRex:'暗証番号は大文字・小文字の英文、数字、ハングルが可能です。'
	             }           
	        }, errorPlacement: function(error, element) {
	        	 error.insertAfter(element);	        	
	        }
	    });	
	    
	    
	    
	    
	    $('button').click(function(){
	    	var params = $("#deleteForm").serialize();
	    	$.ajax({
	    		url:'/action/User_delete',
	    		type:'post',
	    		data: params,
	    		dataType:'xml',
	    		success:function(data){
	    			var result = $(data).find('result').text().trim();
	    			result=Number(result);
	    			console.log($(data).find('result').text().trim());
	    			if(result==1){
	    				opener.document.location.href="/jsp/main/p_main.jsp";
	    				alert('脱退しました。');
	    				window.close();
	    				
	    			}
	    			else if(result==0){
	    				alert('脱退に失敗しました。ID、暗証番号、お名前をもう一度確認してください。');
	    			}	 
	    		},
	    		error:function(e){
	    			console.log(e.message);
	    		} 
	    	})
	    	
	    })
	    
	});	
	</script>
</html>