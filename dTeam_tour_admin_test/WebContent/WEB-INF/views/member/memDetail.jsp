<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    <article >
        <header>
            <h1>맴버리스트 - admin</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
        <%-- boardDetail 들어 갈 자리. --%>

<div class="form-group">
      <label for="title">이름</label>
<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
<!-- required 속성을 설정하면 필수입력 사항이된다. -->
<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
      <input type="text" class="form-control" id="mname" value="${vo.mname }" readonly="readonly" name="mname">
    </div>
    <div class="form-group">
   <label for="content">주민번호</label>
<!--  여러줄의 데이터를 입력하고 하고자 할때 textarea 태그를 사용한다. -->
<!--  textarea 안에 있는 모든 글자는 그대로 나타난다. 공백문자, tag, enter -->
   <textarea class="form-control" rows="5" id="content"
    name="content" readonly="readonly">${vo.mjumin }</textarea>
   </div>
    <div class="form-group">
      <label for="writer">id</label>
      <input type="text" class="form-control" id="mid" name="mid" value="${vo.mid }" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="writer">작성날짜</label>
      <input type="text" class="form-control" id="mdate" name="mdate" value="${vo.mdate }" readonly="readonly">
    </div> 
    <div class="form-group">
      <label for="writer">mimg</label>
      <a href="upDetail?mnum=${vo.mnum }"><img
		src="<%=request.getContextPath() %>/resources/imgfile/${vo.mimgn}"
		style="width: 100px" class="rounded mx-auto d-block"></a>
    </div>  
     <div class="form-group" style="text-align: right; margin-top: 10px;">
      <a href="${pageContext.request.contextPath}/member/memList?searchType=&searchValue=&cPage=1"><button type="submit" class="btn btn-primary">mem 리스트</button></a>
    
     
    </div>
</div>
 
    </article>
