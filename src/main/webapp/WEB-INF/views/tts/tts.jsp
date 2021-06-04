<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<textarea rows="4" cols="" id="txt"></textarea>
<button id="tts_btn">음성합성</button>
<audio autoplay="autoplay" src="" id="audio"></audio>
</body>

<script type="text/javascript">
$("#tts_btn").click(function(){
	alert($("#txt").val());
	var query = { txt_content : $("#txt").val() }
	
	$.ajax({
		url : "/tts/action", 
		type : "post",
		data : query,
		error : function(){
			alert("ajax 통신에러");
		},
		success : function(data){
			$("#audio").attr("src",data);
		} 
	})
})
</script>
</html>