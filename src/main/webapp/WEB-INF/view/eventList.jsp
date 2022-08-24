<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="eventList.do" name="search" method="get" onsubmit="return searchCheck()">

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>event</title>
    
    <!-- 메인 -->
	<link rel='stylesheet' href='../css/normalize.css' />
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel='stylesheet' href='../css/style.css' />
      
      <!-- 이벤트 -->
    <link rel="stylesheet" href="../css/main2.css">
    <link rel="stylesheet" href="../css/sub2.css"> 
    <link rel='stylesheet' href='../css/fb_style.css' />   
    <link rel="stylesheet" href="../css/custom.css">   
    <link rel="stylesheet" href="../css/event.css">
      
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    
  </head>
<body>
<!-- header -->
 <div id="header">
   <jsp:include page="Header.jsp" />
</div><!-- header -->

	<main>
			<div class="thmb_list02 pt30" style="padding-bottom:70px;">
			
				<div class="con_title" style="padding-top:70px;">
				<div>
					<img src="../images/event.png" />
				</div>
				<h1 style="text-align:center;"><b>이벤트</b></h1>
			</div>
					
					
				<c:if test="${member2.manager_id != null}">
					<button type="button" class="board_list_btn" style="position: relative; right: 120px;" 
							onclick="location.href='eventWrite.do'">작성하기</button>
				</c:if>
				
				
				<div class="list_area" style="position: relative; left:110px;">					
				<c:forEach var="article" items="${list}">				
					<div class="item" style="position: relative; font-color: black; width: 260px; left: -30px;">
						
						<div class="thmb">							
							<a href="eventDetail.do?event_code=${article.event_code}"> 
								<img src="../upload/${article.event_image}" style="width:260px; height:150px; border-radius: 10px"/>
								<div style="color: black">
									<input type="hidden" name="event_code" value="${article.event_code}">
									<span style="font-size: 14px; float: right; margin-right: 10px; color: #937062" name="event_yn">${article.event_yn}"</span>
									<span style="font-size: 12px">${article.e_write_date} ~ ${article.event_date}</span>
									<p>
									<p>
										<span style="font-size: 14px">#${article.e_title}</span>
								</div>
							</a>						
						
						</div>					
					</div>
				</c:forEach>

					<!-- <div class="item" style="position:relative; font-color:black; width:260px; left: -10px;">
						<div class="thmb">
						<a href="#"> 
							<img src="images/cookk_png.png?" style="width:100%;border-radius: 10px; border:1px solid" />
							<div style="color:black">
								<span style="font-size:14px; float:right;margin-right:10px;color:#937062">진행중</span>
								<span style="font-size:12px">2022/03/08 ~ 2022/03/16</span><p><p>
								<span style="font-size:14px"># 우리집 밥도둑 레시피를 알려주세요</span>
							</div>
						</a>
					</div>
					</div>-->
					
			</div><!-- list_area -->
		</div><!-- thmb_list02 pt30 -->	
	</main>
	</body>
		<hr>
	    <div id="footer"> 
	    	<jsp:include page="Footer.jsp" />
	    </div><!-- footer -->
    
</html>

</form>













