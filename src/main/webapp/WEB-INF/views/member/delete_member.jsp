<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="" name="fm" style="width: 470px; padding: 30px; margin-left: auto; margin-right: auto;">
  <input type="hidden" value="${member.id}" name="id">
  <input type="hidden" value="${member.pw}" name="pw">
	<div class="mb-3">
		<label class="form-label fw-bolder">패스워드 확인</label>
		<input type="password" name="ckpw" id="ck" class="form-control">
		<span id="msg"></span>
	</div>
	<button type="button" id="del" class="btn btn-primary" style="width: 100%;">회원탈퇴</button>
</form>

</body>
<script type="text/javascript">
$("#del").click(function(){
	
	var query = {id : fm.id.value }
	
	$.ajax({
		url : 
		type :
		data :
		error :
		success :
			
	});
	
});

</script>
</html>