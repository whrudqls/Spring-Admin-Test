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
				id="maid" placeholder="���̵� �Է�" name="maid" maxlength="20"
				required="required" pattern=".{2,10}">
			<button type="button" class="btn btn-primary" id="idchk">�ߺ�Ȯ��</button>
			<div id="target"></div>
		
		</div>
		
		<div class="form-group">
			<label for="mapwd">PWD</label> <input type="password"
				class="form-control" id="mapwd" placeholder="******" name="mapwd"
				maxlength="20" required="required" pattern=".{2,10}">
		</div>
		
		<!-- �ڵ�����ȣ �޴� �������� �ޱ� -->
		<div class="form-group">
			<label for="maphone">����ó</label> <input type="text"
				class="form-control" id="maphone" placeholder="����ó �Է�"
				name="maphone" maxlength="15" required="required">
		</div>
		
		<div class="form-group">
			<label for="maemail">�̸���</label> <input type="text"
				class="form-control" id="maemail" placeholder="�̸��� �Է�"
				name="maemail" maxlength="100" required="required">
		</div>
		
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">���</button>
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
												'������� ���̵� �Դϴ�.');
							} else {
								$('#target').css('background-color', 'blue')
										.css('color', 'white').html(
												'��� ������ ���̵� �Դϴ�.');
							}
						}
					});
				});
	});
</script>



