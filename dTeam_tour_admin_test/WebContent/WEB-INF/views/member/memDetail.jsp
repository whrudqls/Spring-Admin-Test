<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    <article >
        <header>
            <h1>�ɹ�����Ʈ - admin</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
        <%-- boardDetail ��� �� �ڸ�. --%>

<div class="form-group">
      <label for="title">�̸�</label>
<!-- placeholder �Ӽ� �Է��� �����Ͱ� ���� ��� ������� ��Ÿ����.���������� �Է��� 100�ڱ����� ���� -->
<!-- required �Ӽ��� �����ϸ� �ʼ��Է� �����̵ȴ�. -->
<!-- pattern �Ӽ��� �̿��� ����ǥ�������� �������� ��ȿ�� �˻縦 �� �� �ִ�. -->
      <input type="text" class="form-control" id="mname" value="${vo.mname }" readonly="readonly" name="mname">
    </div>
    <div class="form-group">
   <label for="content">�ֹι�ȣ</label>
<!--  �������� �����͸� �Է��ϰ� �ϰ��� �Ҷ� textarea �±׸� ����Ѵ�. -->
<!--  textarea �ȿ� �ִ� ��� ���ڴ� �״�� ��Ÿ����. ���鹮��, tag, enter -->
   <textarea class="form-control" rows="5" id="content"
    name="content" readonly="readonly">${vo.mjumin }</textarea>
   </div>
    <div class="form-group">
      <label for="writer">id</label>
      <input type="text" class="form-control" id="mid" name="mid" value="${vo.mid }" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="writer">�ۼ���¥</label>
      <input type="text" class="form-control" id="mdate" name="mdate" value="${vo.mdate }" readonly="readonly">
    </div> 
    <div class="form-group">
      <label for="writer">mimg</label>
      <a href="upDetail?mnum=${vo.mnum }"><img
		src="<%=request.getContextPath() %>/resources/imgfile/${vo.mimgn}"
		style="width: 100px" class="rounded mx-auto d-block"></a>
    </div>  
     <div class="form-group" style="text-align: right; margin-top: 10px;">
      <a href="${pageContext.request.contextPath}/member/memList?searchType=&searchValue=&cPage=1"><button type="submit" class="btn btn-primary">mem ����Ʈ</button></a>
    
     
    </div>
</div>
 
    </article>
