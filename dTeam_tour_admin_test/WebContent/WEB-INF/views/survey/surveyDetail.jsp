<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article>
	<header>
		<h1>Survey Detail ��������</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<%-- form start --%>
		<div class="form-group">
			<label for="nwriter">����</label> 
				<input type="text" class="form-control" id="nwriter" name="nwriter"
				value="${vo.nwriter }" readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="nwriter">����</label> 
				<input type="text" class="form-control" id="nwriter" name="nwriter"
				value="${vo.nwriter }" readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="nwriter">������</label> 
				<input type="text" class="form-control" id="nwriter" name="nwriter"
				value="${vo.nwriter }" readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="nwriter">�ۼ���</label> 
				<input type="text" class="form-control" id="nwriter" name="nwriter"
				value="${vo.nwriter }" readonly="readonly">
		</div>
				










		<table class="table">
			<thead>
				<tr>
					<th colspan="2">SurveyDetail</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>����</th>
					<td><input type="text" name="sub" id="sub" value="${vo.sub }" readonly="readonly"> 
						<input type="hidden" name="num" id="num" value="${vo.num }"></td>
				</tr>
				<c:forEach var="e" items="${vo.subvey }" varStatus="i">
					<tr>
						<th>${i.index+1}������ ���� <input type="radio" name="subtype" value="${e.subtype }"> ${e.subtype }</th>
						<td>${e.surveytitle }</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">
						<input type="button" value="list" onclick="location='surveylist'"> 
						<input type="button" value="delete" id="delete">
						<input type="button" value="delete" id="update">
					</th>						
				</tr>
			</tfoot>
		</table>
	</div>

</article>