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
		<h1>[ȸ�� ã��]HostJson</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>

	<div class="layout">
		<div id="target">Target</div>
		<div>
			<input type="text" id="hid" name="hid" placeholder="���̵� �Է��ϼ���">
		</div>
		<button id="jsonAjax">Click</button>
	</div>
</article>
<script>
	//jquery����

	$(function() {
		$('#jsonAjax').click(
				function() {
					alert($('#hid').val());
					$.ajaxSetup({//Ajax ĳ�ø� ����
						cache : false
					});
					$.ajax({
						url : "../hoJsonview?hid=" + $('#hid').val(),
						success : function(jsonData) {
							$('#target').html("");//���� => ��ø���� �ʵ���
							console.log(jsonData);
							console.log(Object.keys(jsonData));
							console.log(typeof (jsonData));/*Object() { [native code] }*/
							//���̽� �����͸� ���������� �ݺ��ڸ� ����ؼ� ����ϱ�
							$.each(jsonData, function(i, v) {
								console.log(i + ":" + v);
								//append : +=�� ����
								$('#target').append("<p>" + v + "</p>");
							});
							//target�� �ڽ���p�±׸� �����ؼ�
							//jQery�� css�Լ��� ����ؼ� �������� css�� ������ �� �ִ�.
							$('#target>p').css("background", "orange").css(
									"text-align", "center").css("color",
									"#ffffff");
						}
					});
				});
	});

</script>