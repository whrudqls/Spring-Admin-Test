<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<style>
.layout {
	width: 750px; margin : 0 auto; padding : 30px 35 px 35 px;
	justify-content: center;
	margin: 0 auto;
	padding: 30px 35 px 35 px
}
</style>


<article>
	<header>
		<h1>[회원 찾기]HostJson</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>

	<div class="layout">
		<div id="target">Target</div>
		<div>
			<input type="text" id="hid" name="hid" placeholder="아이디를 입력하세요">
		</div>
		<button id="jsonAjax">Click</button>
	</div>
</article>
<script>
	//jquery시작

	$(function() {
		$('#jsonAjax').click(
				function() {
					alert($('#hid').val());
					$.ajaxSetup({//Ajax 캐시를 삭제
						cache : false
					});
					$.ajax({
						url : "../hoJsonview?hid=" + $('#hid').val(),
						success : function(jsonData) {
							$('#target').html("");//비우기 => 중첩되지 않도록
							console.log(jsonData);
							console.log(Object.keys(jsonData));
							console.log(typeof (jsonData));/*Object() { [native code] }*/
							//제이슨 데이터를 제이쿼리를 반복자를 사용해서 출력하기
							$.each(jsonData, function(i, v) {
								console.log(i + ":" + v);
								//append : +=과 같음
								$('#target').append("<p>" + v + "</p>");
							});
							//target의 자식인p태그를 선택해서
							//jQery의 css함수를 사용해서 동적으로 css를 적용할 수 있다.
							$('#target>p').css("background", "orange").css(
									"text-align", "center").css("color",
									"#ffffff");
						}
					});
				});
	});

</script>