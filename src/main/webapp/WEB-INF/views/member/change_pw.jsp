<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function pwck(){
	if(fm.pwcheck.value!=fm.pw.value){
		alert("현재 패스워드를 잘못 입력하셨습니다.");
		return false;
	}else if(fm.newpw.value==""){
		alert("새 패스워드를 입려해주세요.");
		return false;
	}else if(fm.newpw.value.length < 8){
		alert("새 패스워드를 8자리 이상 입력해주세요.");
		return false;
	}else if(fm.newpw.value!=fm.newpw2.value){
		alert("새 패스워드가 일치하지 않습니다.");
		return false;
	}
	alert("패스워드가 정상적으로 변경되었습니다.\n새로운 패스워드로 로그인 해주세요.");
	return true;
}
</script>
</head>
<body>
<form action="/member/change_pw" name="fm" onsubmit="return pwck()" style="width: 470px; padding: 30px; margin-left: auto; margin-right: auto;">
  <input type="hidden" name="pwcheck" value="${member.pw}">
  <input type="hidden" name="id" value="${member.id}">
	<div class="mb-3">
		<label class="form-label fw-bolder">현재 패스워드</label>
		<input type="password" name="pw" class="form-control">
	</div>
	<div class="mb-3">
		<label class="form-label fw-bolder">새 패스워드</label>
		<input type="password" name="newpw" class="form-control">
	</div>
	<div class="mb-3">	
		<label class="form-label fw-bolder">새 패스워드 확인</label>
		<input type="password" name="newpw2" class="form-control">
	</div>
	<input type="submit" value="패스워드 변경" class="btn btn-primary" style="width: 100%;">
</form>
</body>
</html>