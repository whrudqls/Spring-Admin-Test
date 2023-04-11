<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<article>
	<header>
		<h1>����</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>��ȣ</th>
					<th>����</th>
					<th>�ۼ���</th>
					<th>�ۼ���¥</th>
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
										<option selected value="">�˻�</option>
										<option value="1">����</option>
										<option value="2">�ۼ���</option>
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
						${totalRecord }����  �Խù����� <b>${searchValue }</b> ��/�� �˻� �Ǿ����ϴ�.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<tr>
					<td colspan="5" style="text-align: right;"><a
						href=noticeaddform>���ۼ�</a></td>
				</tr>

			</tfoot>
		</table>
	</div>

</article>