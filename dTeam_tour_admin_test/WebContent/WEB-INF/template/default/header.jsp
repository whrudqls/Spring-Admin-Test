<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />
<script src="http://code.jquery.com/jquery-latest.js"></script>


<header>
	<div class="header-area ">
		<div id="sticky-header" class="main-header-area">
			<div class="container-fluid">
				<div class="header_bottom_border">
					<div class="row align-items-center">
						<div class="col-xl-2 col-lg-2">
							<div class="logo">
								<a href="${ctrpath}/main"> <img src="${path}/img/logo.png"
									alt="">
								</a>
							</div>
						</div>

						<div class="col-xl-6 col-lg-6">
							<div class="main-menu  d-none d-lg-block">
								<nav>
									<ul id="navigation">

										<li><a href="#">�ɹ� <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="destination_details.html">���ɴ� �� </a></li>
												<li><a href="elements.html">mbti �� </a></li>
												<li><a href="elements.html">���� ��¥ �� </a></li>		
												<li><a href="elements.html">��� �� </a></li>										
											</ul></li>

										<li><a href="#">ȣ��Ʈ <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="elements.html">���� �� </a></li>
												<li><a href="elements.html">�׸� �� </a></li>
												<li><a href="elements.html">���ƿ� �� </a></li>
												<li><a href="elements.html">���� �� </a></li>
												<li><a href="elements.html">���� �� </a></li>
											</ul></li>
										<li><a href="#">���� ��ü <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="elements.html">���� </a></li>
												<li><a href="elements.html">�Ļ� </a></li>
												<li><a href="elements.html">ī�� </a></li>
												<li><a href="elements.html">�������</a></li>
												<li><a href="elements.html">����</a></li>
											</ul></li>

										<li><a class="active" href="${ctrpath}/mail/emailForm">���Ǹ���</a></li>

										<li class="nav-item"><a	href="${ctrpath}/admin/surveylist" class="nav-link">��������</a></li>
										
										<li><a class="active" href="${ctrpath}/admin/noticeboardList">��������</a></li>


										<li><a href="#">���� ��Ʈ <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="${ctrpath}/chart/mychart">barchart</a></li>
												<li><a href="${ctrpath}/chart/donutchart">donutChart</a></li>
												
												<li><a href="${ctrpath}/josn/memJson">memJson</a></li>												
												<li><a href="${ctrpath}/josn/memListJson">memListJson</a></li>
												<li><a href="${ctrpath}/admin/memboardList">�ɹ� ����¡ �˻�</a></li> 
												
												<li><a href="${ctrpath}/josn/hoJson">hoJson</a></li>												
												<li><a href="${ctrpath}/josn/hoListJson">hoListJson</a></li>
												<li><a href="${ctrpath}/admin/hoboardList">ȣ��Ʈ ����¡ �˻�</a></li>
												
												<li><a href="${ctrpath}/tchart/preference">��Ʈpreference</a></li>
                                                <li><a href="${ctrpath}/tchart/gender">��Ʈgender</a></li>                                               
                                            </ul>
										</li>
									</ul>
								</nav>
							</div>
						</div>
						<div class="col-xl-4 col-lg-4 d-none d-lg-block">
							<div
								class="social_wrap d-flex align-items-center justify-content-end">
								<!-- 
                                	�α��� �ϸ� ���̵���! => ���ǽɾ 
                                	${name} ȸ���� �ݰ����ϴ�! or ${id}
                                    <div class="number">
                                        <p> <i class="fa fa-comments-o" aria-hidden="true"></i> Kosmo123@gildong.net</p>
                                    </div>
                                -->
								<link rel="stylesheet" href="${path}/css/header_text_neon.css">
								<div class="text">
									<c:choose>
										<c:when test="${sessionScope.sessionID == null }">
											<h3 class="neonText">welcome</h3>
										</c:when>
										<c:when test="${sessionScope.sessionID != null }">
											<h3 class="neonText">${sessionScope.sessionName }��!</h3>
										</c:when>
										
									</c:choose>
								</div>
								&nbsp;&nbsp;&nbsp;
								<div class="social_links d-none d-xl-block">
									<ul>
										<c:choose>
											<c:when test="${sessionScope.sessionMaid == null }">
												<!-- �α��� ���� ������ -->
												<li><a href="${ctrpath}/login/loginForm">LogIn</a></li>
												<li><a href="${ctrpath}/admin/adminSignUpForm">SignUp</a></li>
											</c:when>
											<c:when test="${sessionScope.sessionMaid != null }">
												<li><a href="${ctrpath}/login/logoutProcess">LogOut</a></li>
											</c:when>
										</c:choose>
									</ul>
								</div>
							</div>
						</div>
						<div class="seach_icon">
							<a data-toggle="modal" data-target="#exampleModalCenter" href="#">
								<i class="fa fa-search"></i>
							</a>
						</div>
						<div class="col-12">
							<div class="mobile_menu d-block d-lg-none"></div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</header>