<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.txt-box {
 text-align: center;
}
#txt {
	width: 90%;
	height: 200px;
	border-color: #FF3399;
	outline: none;
}
#tts_btn {
	background-color: #FF3399;
	border-radius: 10px;
	outline: none;
	font-size: large;
	color: white;
	border-color: #FF3399;
}
</style>
</head>
<body>
<br>
<h3 style="text-align: center;">음성합성</h3>
<div class="txt-box">
	<div>
		<textarea rows="4" cols="" id="txt" placeholder="듣고 싶은 음성을 작성해주세요"></textarea>
	</div>
	<button id="tts_btn">음성합성</button>
	<audio autoplay="autoplay" src="" id="audio"></audio>
</div>
</body>

<script type="text/javascript">
$("#tts_btn").click(function(){
	alert($("#txt").val());
	var query = { txt_content : $("#txt").val() }
	
	if($("#txt").val()!=""){
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
	}
})
</script>
</html>