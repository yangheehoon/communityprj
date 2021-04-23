<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/member/join" name="fm" onsubmit="return check()" style="width: 470px; padding: 30px; margin-left: auto; margin-right: auto;">
	
	<div class="mb-3">
		<label class="col-form-label-sm fw-bolder" style="width: 100%;">아이디</label>
		<input type="text" name="id" id="userid" class="form-control form-control-sm" style="width: 63.6%; display: inline-block;">
		<button type="button" id="idcheck" class="btn btn-primary">아이디 중복검사</button>
	</div>
	<div class="mb-3">
		<label class="col-form-label-sm fw-bolder">패스워드</label>
		<input type="password" name="pw" class="form-control form-control-sm">		
	</div>
	<div class="mb-3">
		<label class="col-form-label-sm fw-bolder">패스워드 확인</label>
		<input type="password" name="pw2" class="form-control form-control-sm">		
	</div>
	<div class="mb-3">
		<label class="col-form-label-sm fw-bolder">닉네임</label>
		<input type="text" name="nickname" class="form-control form-control-sm">
	</div>
	<div class="mb-3">
		<label class="col-form-label-sm fw-bolder">이름</label>
		<input type="text" name="name" class="form-control form-control-sm">
	</div>
	<div class="mb-3">
		<label class="col-form-label-sm fw-bolder">생년원일</label>
		<input type="text" name="birth" class="form-control form-control-sm">
	</div>
	<div class="mb-3">
		<label class="col-form-label-sm fw-bolder">이메일</label>
		<input type="email" name="email" class="form-control form-control-sm">
	</div>
	<div class="mb-3">
		<label class="col-form-label-sm fw-bolder">성별</label>
		<select name="gender" class="form-select form-select-sm">
			<option>성별</option>
			<option>남자</option>
			<option>여자</option>
		</select>
	</div>
	<div class="mb-3">
		<label class="col-form-label-sm fw-bolder">전화번호</label>
		<input type="text" name="phone" id="ph" class="form-control form-control-sm">
	</div>
	<input type="submit" value="회원가입" class="btn btn-primary" style="width: 100%;">
</form>



</body>
</html>