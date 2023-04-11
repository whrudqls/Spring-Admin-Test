<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
a:link {
	text-decoration: none;
}

table img {
	width: 80px;
}
/* paging */
table tfoot ol.paging {
	margin-left: 30%;
	list-style: none;
}

table tfoot ol.paging li {
	float: left;
	margin-right: 8px;
}

table tfoot ol.paging li a {
	display: block;
	padding: 3px 7px;
	border: 1px solid #00B3DC;
	color: #2f313e;
	font-weight: bold;
}

table tfoot ol.paging li a:hover {
	background: #00B3DC;
	color: white;
	font-weight: bold;
}

.disable {
	padding: 3px 7px;
	border: 1px solid silver;
	color: silver;
}

.now {
	padding: 3px 7px;
	border: 1px solid #ff4aa5;
	background: #ff4aa5;
	color: white;
	font-weight: bold;
}
</style>
<article>
	<header>
		<h1>UpBoard Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>								
					<th>폰번호</th>
					<th>주소</th>
					<th>이메일</th>
					<th>비상 연락망</th>
					<th>보유 계좌</th>
					<th>hnum</th>				
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<%-- for start --%>
				<c:forEach var="e" items="${list }">
					<tr>
						<td class="align-middle">${e.hnum }</td>
						<td class="align-middle"><a href="upDetail?num=${e.hnum }">${e.hid }</a></td>
						<td class="align-middle">${e.hname }</td>										
						<td class="align-middle">${e.hphone }</td>
						<td class="align-middle">${e.haddr }</td>
						<td class="align-middle">${e.hemail }</td>
						<td class="align-middle">${e.hcall }</td>
						<td class="align-middle">${e.haccount }</td>
						<td class="align-middle">${e.hnum }</td>	
						<td class="align-middle">${e.hdate }</td>				
				</c:forEach>
				<%-- for end --%>
			</tbody>


			<tfoot>
				<c:set var="pageurl"
					value="?searchType=${searchType}&searchValue=${searchValue}&cPage" />
				<tr>
					<td colspan="5"><%@include file="../page/pageModule.jsp"%>
					</td>
				</tr>

				<tr>
					<td colspan="5">
						<form class="d-flex">
							<div class="row g-3 align-middle text-center">
								<div class="col-auto">
									<select class="form-select" name="searchType" id="searchType"
										aria-label="Default select example">
										<option selected value="">검색</option>
										<option value="1">아이디</option>
										<option value="2">이름</option>
									</select>
								</div>
								<div class="col-auto">
									
									<input type="text" class="form-control" id="searchValue"
										name="searchValue" placeholder="searchValue">
								</div>
								<div class="col-auto">
									<button type="submit" class="btn btn-primary mb-3">Search</button>
								</div>
							</div>
						</form>
					</td>
				</tr>

				<c:if test="${searchType == 1 or searchType == 2}">
						${totalRecord }개의  게시물에서 <b>${searchValue }</b> 이/가 검색 되었습니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
				

			</tfoot>
		</table>
	</div>

</article>
