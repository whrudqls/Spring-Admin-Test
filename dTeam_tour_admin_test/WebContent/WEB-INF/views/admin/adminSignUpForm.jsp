<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<!-- 
	private int manum;
	private String maid, mapwd, maphone, maemail, sysdate;
 -->

<header>
	<h1>LoginProcess Demo</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="container">
	<form action="signUpProcess" method="post" id="signUpInfo">
		<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
		
		<div class="form-group">
			<label for="maid">ID</label> <input type="text" class="form-control"
				id="maid" placeholder="아이디 입력" name="maid" maxlength="20"
				required="required" pattern=".{2,10}">
			<button type="button" class="btn btn-primary" id="idchk">중복확인</button>
			<div id="target"></div>
		
		</div>
		
		<div class="form-group">
			<label for="mapwd">PWD</label> <input type="password"
				class="form-control" id="mapwd" placeholder="******" name="mapwd"
				maxlength="20" required="required" pattern=".{2,10}">
		</div>
		
		<!-- 핸드폰번호 받는 형식으로 받기 -->
		<div class="form-group">
			<label for="maphone">연락처</label> <input type="text"
				class="form-control" id="maphone" placeholder="연락처 입력"
				name="maphone" maxlength="15" required="required">
		</div>
		
		<div class="form-group">
			<label for="maemail">이메일</label> <input type="text"
				class="form-control" id="maemail" placeholder="이메일 입력"
				name="maemail" maxlength="100" required="required">
		</div>
		
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">등록</button>
			 &nbsp;			
		</div>

	</form>

</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		$('#idchk').click(
				function() {
					let param = $('#maid').val();
					$.ajax({
						url : "../idcheck?maid=" + param,
						success : function(data) {
							console.log(data);
							if (data == 1) {
								$('#target').css('background-color', 'red')
										.css('color', 'white').html(
												'사용중인 아이디 입니다.');
							} else {
								$('#target').css('background-color', 'blue')
										.css('color', 'white').html(
												'사용 가능한 아이디 입니다.');
							}
						}
					});
				});
	});
</script>



