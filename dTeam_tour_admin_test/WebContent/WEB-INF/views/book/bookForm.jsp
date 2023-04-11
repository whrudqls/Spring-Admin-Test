<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<header>
	<h1>ReservProcess Demo</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="container">
	<h3>국내예약등록</h3>
	<form action="bookProcess" method="post" enctype="multipart/form-data"
		id="bookInfo">
		<!-- 국내여행 출력 시작 -->
		<input type="hidden" name="lid" value="${vo.lno }">

		<div class="form-group">
			<label for="larea">larea</label> <input type="text"
				class="form-control" id="larea" value="${vo.larea }"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="ltitle">ltitle</label> <input type="text"
				class="form-control" id="ltitle" value="${vo.ltitle }"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="lcontent">lcontent</label> <input type="text"
				class="form-control" id="lcontent" value="${vo.lcontent }"
				readonly="readonly">
		</div>
		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">*이미지</label>
			<div class="col-sm-10">
				<img id="imgx" src="${ctrpath}/resources/imgfile/${vo.limg }">
			</div>
		</div>
		<!--  
		<div class="form-group">
			<label for="htcode">htcode</label> <input type="number" class="form-control"
				id="htcode" placeholder="htcode 입력" name="htcode" maxlength="15"
				required="required">
		</div>
	-->
		<div class="form-group">
			<label for="lprice">lprice</label> <input type="number"
				class="form-control" id="lprice" value="${vo.lprice }"
				readonly="readonly">
			<hr>
		</div>
		<!-- 국내여행 출력 끝 -->

		<div id="target">
			<h2>Item</h2>
			<hr>
			<input type="hidden" name="index" id="index">
			<!-- index = 0, 1, 2, 3, 4 -->
			<c:forEach var="e" items="${vo.item }">
				<input type="hidden" name="oprice" class="form-control"
					value="${e.oprice }" readonly="readonly">
				<div class="form-check">
					<input name="item" class="form-check-input item" type="radio">
					<label class="form-check-label"></label>
				</div>
				<div class="form-group">
					<input type="text" name="otitle" class="form-control"
						value="${e.otitle }" readonly="readonly">
					<div style="text-align: right;">oprice: ${e.oprice }원</div>
				</div>
			</c:forEach>
			<hr>
		</div>

		<div class="form-group">
			<label for="mid">예약자</label> ${sessionID } <input type="hidden"
				id="mid" name="mid" value=${sessionNum }>
		</div>

		<div class="form-group">
			<label for="sdate">입실날짜</label> <input type="date"
				class="form-control" id="sdate" placeholder="sdate 입력" name="sdate">
		</div>

		<div class="form-group">
			<label for="edate">퇴실날짜</label> <input type="date"
				class="form-control" id="edate" placeholder="edate 입력" name="edate">
		</div>

		<!--		
		<div class="form-group">
			<label for="tsort">tsort</label> <input type="number" class="form-control"
				id="tsort" placeholder="tsort 입력" name="tsort"
				required="required">
		</div>
-->
		<div class="form-group">
			<label for="chtype">결제타입</label> <input type="text"
				class="form-control" id="chtype" name="chtype" required="required">
		</div>
		<div class="form-group">
			<label for="chpay">결제금액</label> <input type="number"
				class="form-control" id="chpay" name="chpay" required="required">
		</div>

		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">예약하기</button>
		</div>
	</form>

</div>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
	//javascript는 클라이언트 측 언어
	//HTML, CSS를 동적으로 제어하는 목적으로 주로 사용
	//html5부터 제공하는 filereader()함수를 사용해 이미지 미리보기 구현
	//함수는 메서드와 비슷

	/*
	 * 메서드: pulic void readURL(String input){}
	 * 변수: String reader => var reader
	 */

	$(function() {
		$('#target > .form-group > input').each(function(i, element) {
			$(this).attr('id', 'otitle' + i);
		})
		$('#target > .form-check > label').each(function(i, element) {
			$(this).attr('for', 'otitle' + i);
			$(this).html('<h3>otitle' + (i + 1) + '</h3>');
		})
		$('.item').click(function() {
			let c = this;
			$('.item').each(function(i, element) {
				if (this == c) {
					$('#index').attr('value', i);
					console.log($('#index').attr('value'));
				}
			})
		})
	})
</script>