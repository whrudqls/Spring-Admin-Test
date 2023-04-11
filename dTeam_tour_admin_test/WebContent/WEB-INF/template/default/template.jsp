<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:set var="path" value="${pageContext.request.contextPath}/resources"/>


<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>타일즈 적용이지롱 세미 템플릿</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link rel="shortcut icon" type="image/x-icon" href="${path}/img/favicon.png">
 

    <!-- CSS here -->
    <link rel="stylesheet" href="${path}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${path}/css/magnific-popup.css">
    <link rel="stylesheet" href="${path}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${path}/css/themify-icons.css">
    <link rel="stylesheet" href="${path}/css/nice-select.css">
    <link rel="stylesheet" href="${path}/css/flaticon.css">
    <link rel="stylesheet" href="${path}/css/gijgo.css">
    <link rel="stylesheet" href="${path}/css/animate.css">
    <link rel="stylesheet" href="${path}/css/slick.css">
    <link rel="stylesheet" href="${path}/css/slicknav.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

    <link rel="stylesheet" href="${path}/css/style.css">

</head>

<body>

	<tiles:insertAttribute name="header"/>
  
	<tiles:insertAttribute name="body"/>

	<tiles:insertAttribute name="footer"/>

	<tiles:insertAttribute name="searchbar"/>


    <script src="${path}/js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="${path}/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="${path}/js/popper.min.js"></script>
    <script src="${path}/js/bootstrap.min.js"></script>
    <script src="${path}/js/owl.carousel.min.js"></script>
    <script src="${path}/js/isotope.pkgd.min.js"></script>
    <script src="${path}/js/ajax-form.js"></script>
    <script src="${path}/js/waypoints.min.js"></script>
    <script src="${path}/js/jquery.counterup.min.js"></script>
    <script src="${path}/js/imagesloaded.pkgd.min.js"></script>
    <script src="${path}/js/scrollIt.js"></script>
    <script src="${path}/js/jquery.scrollUp.min.js"></script>
    <script src="${path}/js/wow.min.js"></script>
    <script src="${path}/js/nice-select.min.js"></script>
    <script src="${path}/js/jquery.slicknav.min.js"></script>
    <script src="${path}/js/jquery.magnific-popup.min.js"></script>
    <script src="${path}/js/plugins.js"></script>
    <script src="${path}/js/gijgo.min.js"></script>
    <script src="${path}/js/slick.min.js"></script>
   

    

    <script src="${path}/js/contact.js"></script>
    <script src="${path}/js/jquery.ajaxchimp.min.js"></script>
    <script src="${path}/js/jquery.form.js"></script>
    <script src="${path}/js/jquery.validate.min.js"></script>
    <script src="${path}/js/mail-script.js"></script>

    <script src="${path}/js/main.js"></script>
    <script>
        $('#datepicker').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
             rightIcon: '<span class="fa fa-caret-down"></span>'
         }
        });
    </script>
</body>

</html>