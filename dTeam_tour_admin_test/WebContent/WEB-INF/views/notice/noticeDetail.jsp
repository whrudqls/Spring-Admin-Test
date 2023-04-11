<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<article>
	<header>
		<h1>���� ���� ����</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<%-- boardDetail ��� �� �ڸ�. --%>
		<div class="form-group">
			<label for="nsub">����</label>
			<!-- placeholder �Ӽ� �Է��� �����Ͱ� ���� ��� ������� ��Ÿ����.���������� �Է��� 100�ڱ����� ���� -->
			<!-- required �Ӽ��� �����ϸ� �ʼ��Է� �����̵ȴ�. -->
			<!-- pattern �Ӽ��� �̿��� ����ǥ�������� �������� ��ȿ�� �˻縦 �� �� �ִ�. -->
			<input type="text" class="form-control" id="nsub" value="${vo.nsub }"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="ncontent">����</label>
			<!--  �������� �����͸� �Է��ϰ� �ϰ��� �Ҷ� textarea �±׸� ����Ѵ�. -->
			<!--  textarea �ȿ� �ִ� ��� ���ڴ� �״�� ��Ÿ����. ���鹮��, tag, enter -->
			<textarea class="form-control" rows="5" id="ncontent" name="content"
				readonly="readonly">${vo.ncontent }</textarea>
		</div>
		<div class="form-group">
			<label for="nwriter">�ۼ���</label> <input type="text"
				class="form-control" id="nwriter" name="nwriter"
				value="${vo.nwriter }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="ndate">�ۼ���¥</label> <input type="text"
				class="form-control" id="ndate" name="ndate" value="${vo.ndate }"
				readonly="readonly">
		</div>

		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<a href="noticeupdateForm?num=${vo.nnum }">
				<button type="submit" class="btn btn-primary">����</button>
			</a> <a href="noticedelete?num=${vo.nnum }">
				<button type="submit" class="btn btn-primary">����</button>
			</a>
		</div>

	</div>

</article>
