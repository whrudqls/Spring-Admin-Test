<%@page import="kr.co.kosmo.mvc.vo.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


<%--2023. 2. 6./Kosmo--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
</style>
<!-- calendar -->
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar-scheduler@6.1.0/index.global.min.js'></script>
<script>
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView : 'dayGridMonth',
		locale : 'ko', // 한국어 설정
		headerToolbar : {
        	start : "title", //우측
            center : "prev,addEventButton,next", //중간
            end : 'dayGridMonth,dayGridWeek,dayGridDay' //좌측
            },
	selectable : true,
    customButtons: {
        addEventButton: {
          text: 'add event...',
          click: function() {
            var dateStr = prompt('Enter a date in YYYY-MM-DD format');
            var date = new Date(dateStr + 'T00:00:00'); // will be in local time

            if (!isNaN(date.valueOf())) { // valid?
              calendar.addEvent({
                title: 'dynamic event',
                start: date,
                allDay: true
              });
              alert('You just updated your schedule! XD');
            } else {
              alert('Invalid date:(');
            }
          }
        }
      },
	droppable : true,
	editable : true,
	events : [ 
    	    <%List<BookVO> calendarList = (List<BookVO>) request.getAttribute("calendarList");%>
            <%if (calendarList != null) {%>
            <%for (BookVO vo : calendarList) {%>
            {
            	title : '<%=vo.getBstatus()%>',
                start : '<%=vo.getSdate()%>',
                end : '<%=vo.getEdate()%>',
                color : '#' + Math.round(Math.random() * 0xffffff).toString(16)
             },
				<%}
}%>
				]				
			});
			calendar.render();
		});
</script>
<script> </script>
</head>
<body>
	<%-- calendar --%>
	<div id='calendar'></div>
	<%-- calendar --%>

</body>
</html>