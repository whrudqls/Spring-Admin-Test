<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--2023. 2. 3./Kosmo--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300&display=swap')
	;

.container {
	font-family: "Trebuchet MS", sans-serif;
	display: flex;
	gap: 30px;
}

.column {
	font-family: 'Noto Serif KR', serif;
	flex-basis: 20%;
	background: gainsboro;
	min-height: 50vh;
	padding: 5px;
	border-radius: 10px;
}

.column2 {
	font-family: 'Noto Serif KR', serif;
	flex-basis: 60%;
	background: gainsboro;
	min-height: 90vh;
	padding: 5px;
	border-radius: 10px;
}

.column3 {
	font-family: 'Noto Serif KR', serif;
	flex-basis: 60%;
	background: lavender;
	min-height: 90vh;
	padding: 5px;
	border-radius: 10px;
}

.column h1 {
	text-align: center;
	font-size: 22px;
}

.column2 h1 {
	text-align: center;
	font-size: 22px;
}

.list-group-item {
	text-align: center;
	background: #fff;
	margin: 20px;
	padding: 20px;
	border-radius: 5px;
	cursor: pointer;
}

.ui-state-default {
	text-align: center;
	background: #fff;
	margin: 5px;
	padding: 20px;
	border-radius: 5px;
	cursor: pointer;
}

td {
	text-align: center;
	background: #fff;
	margin: 5px;
	padding: 10px;
	border-radius: 5px;
	cursor: pointer;
}

/* ==============����==================*/
.nine h1 {
	text-align: center;
	font-size: 50px;
	text-transform: uppercase;
	color: #222;
	letter-spacing: 1px;
	font-family: "Playfair Display", serif;
	font-weight: 400;
}

.nine h1 span {
	margin-top: 5px;
	font-size: 15px;
	color: #444;
	word-spacing: 1px;
	font-weight: normal;
	letter-spacing: 2px;
	text-transform: uppercase;
	font-family: "Raleway", sans-serif;
	font-weight: 500;
	display: grid;
	grid-template-columns: 1fr max-content 1fr;
	grid-template-rows: 27px 0;
	grid-gap: 20px;
	align-items: center;
}

.nine h1 span:after, .nine h1 span:before {
	content: " ";
	display: block;
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #ccc;
	height: 5px;
	background-color: #f8f8f8;
}

/* ============��ư====================*/
.custom-btn {
	width: 130px;
	height: 40px;
	color: #fff;
	border-radius: 5px;
	padding: 10px 25px;
	font-family: 'Lato', sans-serif;
	font-weight: 500;
	background: whitesmoke;
	cursor: pointer;
	transition: all 0.3s ease;
	position: relative;
	display: inline-block;
	box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px
		0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
	outline: none;
}

button {
	margin: 20px;
}

/**/
.btn-16 {
	border: none;
	color: #000;
}

.btn-16:after {
	position: absolute;
	content: "";
	width: 0;
	height: 100%;
	top: 0;
	left: 0;
	direction: rtl;
	z-index: -1;
	box-shadow: -7px -7px 20px 0px #fff9, -4px -4px 5px 0px #fff9, 7px 7px
		20px 0px #0002, 4px 4px 5px 0px #0001;
	transition: all 0.3s ease;
}

.btn-16:hover {
	color: #000;
}

.btn-16:hover:after {
	left: auto;
	right: 0;
	width: 100%;
}

.btn-16:active {
	top: 2px;
}
</style>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
	$(function() {
		$("#accom").click(function() {
			$.ajaxSetup({
				cache : false
			});

			$.ajax({
				url : "../schedulerRest/showList",
				success : function(json) {
					$('#target').html("");
					$.each(json, function(k, v) {
						console.log(k + ":" + v);	
						$('#target').append("<tr>")
						$.each(v, function(i, j) {
							if (j !== null) {
								console.log(i + ":" + j);
								$('#target').append("<td>" + j + "</td>");
							}
						})
						$('#target').append("</tr>");
					})
				}
			});
		});
	});
	

</script>

</head>
<body>
	<div class="nine">
		<h1>
			Scheduler<span>Just Drag And Drop your way</span>
		</h1>
	</div>
	<div class="container">

		<div class="column">
			<h1>Options</h1>
			<button class="custom-btn btn-16" id="departure">���</button>
			<button class="custom-btn btn-16" id="accom">����</button>
			<button class="custom-btn btn-16" id="meal">�Ļ�</button>
			<button class="custom-btn btn-16" id="cafe">ī��</button>
			<button class="custom-btn btn-16" id="tour">������</button>
			<button class="custom-btn btn-16">�Ͱ�</button>
		</div>


		<div class="column2">
			<h1>Options</h1>
			<table class="table table-bordered border-primary">
				<tbody id="target">
				</tbody>
			</table>
		</div>


		<div class="column3">
			<h1>Schedule</h1>
			<ul id="sortable">
				<li class="ui-state-default" draggable="true"><span
					class="ui-icon ui-icon-arrowthick-2-n-s" id="departure"></span>���</li>
				<li class="ui-state-default" draggable="true"><span
					class="ui-icon ui-icon-arrowthick-2-n-s"></span>���� �����̳�</li>
				<li class="ui-state-default" draggable="true"><span
					class="ui-icon ui-icon-arrowthick-2-n-s"></span>���� ī�����</li>
				<li class="ui-state-default" draggable="true"><span
					class="ui-icon ui-icon-arrowthick-2-n-s"></span>�ſ�� ���Ѹ���</li>
				<li class="ui-state-default" draggable="true"><span
					class="ui-icon ui-icon-arrowthick-2-n-s"></span>��� ��ź</li>
				<li class="ui-state-default" draggable="true"><span
					class="ui-icon ui-icon-arrowthick-2-n-s"></span>���� �˺���</li>
				<li class="ui-state-default" draggable="true"><span
					class="ui-icon ui-icon-arrowthick-2-n-s"></span>�Ͱ�</li>
			</ul>

		</div>
	</div>
</body>

<script>
	//$("#sortable").sortable();
	//$("#sortable").disableSelection(); // ������ ������ ���ڸ� �巡�� �ؼ� �������� ���ϵ��� �ϴ� ���

	$("#sortable").sortable({
		placeholder : "itemBoxHighlight", /* �̵��� ��ġ css ����  */
		start : function(event, ui) {
			// �巡�� ���� �� ȣ��
		},
		stop : function(event, ui) {
			// �巡�� ���� �� ȣ��
			reorder();
		}
	});

	/* ��ȣ ���Է�(����������) */
	function reorder() {
		$("#sortable li").each(function(i, box) {
			$(box).val(i + 1);
		});
	}
</script>
</html>