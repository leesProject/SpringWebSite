<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<script>
	function countLength(text){
		var anchor = document.getElementById('length');
		var length = text.value.length;
		anchor.innerHTML=String(length)+'자';
	}
</script>

<form action='/action/CountLength'>
<textarea style="width: 100%;height: 60vh;" onkeyup="countLength(this)" name='letters'></textarea>
	<button type='submit'>go!</button>
</form>
<a id='length'></a>
<body>

</body>
</html>