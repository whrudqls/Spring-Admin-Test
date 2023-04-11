<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<article>
	<header>
		<h1>공지</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${list}">
					<tr>
						<td>${e.nnum }</td>
						<td><a href="noticeDetail?num=${e.nnum }">${e.nsub }</a></td>
						<td>${e.nwriter }</td>
						<td>${e.ndate}</td>						
					</tr>
				</c:forEach>
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
										<option value="1">제목</option>
										<option value="2">작성자</option>
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
				<tr>
					<td colspan="5" style="text-align: right;"><a
						href=noticeaddform>글작성</a></td>
				</tr>

			</tfoot>
		</table>
	</div>

</article>