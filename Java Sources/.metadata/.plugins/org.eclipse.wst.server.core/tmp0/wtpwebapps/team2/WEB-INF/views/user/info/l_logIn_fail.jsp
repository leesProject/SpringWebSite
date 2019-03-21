<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>l_fid_r</title>
</head>

<script src='/jquery/jquery-3.2.1.js'></script>

<script>
$(function(){
	$(document).ready(function(){
		alert('${logInError}');
		document.location.replace('/jsp/logIn/p_logIn.jsp');
	});
})
</script>
<body>
</body>
</html>