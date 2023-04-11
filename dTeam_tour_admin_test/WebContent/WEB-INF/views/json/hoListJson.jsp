<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<script src="http://code.jquery.com/jquery-latest.js"></script> 

<style>
.layout {
	width: 750px;
	margin: 0 auto;
	padding: 30px 35px 35px;
	justify-content: center;
}
</style>

<article>
	<header>
		<h1>[ȸ�� ã��]deptJsonDemo</h1>
	</header>
	
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	
	<div class="container">
	<button id="listBtn" class="btn btn-primary">Click</button>
		<div class="row">
			
			<div class="row justify-content-center">
				<table class="table">
					<thead>
						<tr>
							<td>hnum</td>
							<td>hid</td>
							<td>hname</td>
							<td>hphone</td>
							<td>haddr</td>
							<td>hemail</td>
							<td>hcall</td>
							<td>haccount</td>
							<td>hdate</td>						
						</tr>
					</thead>
					<tbody id="target">
					
					</tbody>
				</table>
			</div>
		</div>
	</div>
</article>
<script>
	//jQuery ����! 
	//jQuery ���� Ȯ��
$(function() {
    $('#listBtn').click(function() {
        $.ajaxSetup({//Ajax ĳ�ø� ����
            cache : false
        });
        $.ajax({
            url : "../hoListJsonview",
            success : function(jsonData) {
                console.log(jsonData);
                $('#target').html("");
                $.each(jsonData, function(k, v) {
                    var row = $("<tr>");
                    $.each(v, function(i, j) {
                        if (j != null) {
                            console.log(i + ":" + j);//�ش� ���� key�� value ��  
                            row.append("<td>" + j + "</td>");
                        }
                    })
                    $('#target').append(row);
                });
            }
        });
    });
});
</script>