<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Main</title>
    
    <!-- 헤더 푸터 -->
	 <link rel='stylesheet' href='../css/normalize.css' />
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel='stylesheet' href='../css/style.css' />
      
      <!-- 추천레시피 -->
   	<link rel="stylesheet" href="../css/main2.css">
    <link rel="stylesheet" href="../css/sub2.css"> 
 
    <link rel='stylesheet' href='../css/fb_style.css' /> 
    <link rel="stylesheet" href="../css/custom.css">  
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    
  </head>
  
  <body>  
  <form action="Main.do" action ="Post">
  
  
    <div id="header">
   		<jsp:include page="Header.jsp" />
	</div><!-- header -->


<!-- main(슬라이드 or 이미지) -->
	<div class="slideCon">
          <div class="slideBox">
              <div class="swiper-wrapper">                            
                    <a href="" class="swiper-slide"> 
                      <img src="../images/main.jpg" style="height:800px" />
                   </a> 
               </div>
           </div>                                     
	</div>

  <!-- container -->
<!-- sec01 추천레시피 -->
		<div class="content section03" style="margin-top: 100px">
			<h2 class="main hr" style="text-align: center">
				<a href="../board/r1BoardList.do" style="color:black">추천 레시피</h2></a>
			<hr style="width: 100px;border-top: 3px solid #eee">
			<p class="main" style="text-align: center; font-size:18px">Cookk이 추천하는 레시피를 도전해보세요.</p>
			

			<!-- 레시피 리스트 -->
			<div class="thmb_list02">
				<div class="list_area">
										
				<c:forEach var="r10" items="${getDescRe_main2}" begin="0" end="0"> 
					<div class="item big">
						<div class="thmb">
							<a href="r1BoardDetail.do?board_num=${r10.board_num}">
								<div class="img">
									<div class="scale">
										<img src="../upload/${r10.main_img}" style="border:none" />
									</div>
								</div>
							</a>
						</div>
											
						<div class="info">
						<!--
							<div class="info_tag">							
							<span>#집밥</span>							
							<span>#밑반찬</span>							
							<span>#꿀유자차</span>
						</div>
						-->						
							<div class="info_title ellip">
								<a href="r1BoardDetail.do?board_num=${r10.board_num}">${r10.title}</a>
							</div>
						</div>
					</div>
				</c:forEach>
				
					
					<c:forEach var="r11" items="${getDescRe_main2}" begin="1" end="1"> 								
					<div class="item" >
					
						<div class="thmb">													
							<a href="r1BoardDetail.do?board_num=${r11.board_num}">
							<div class="img">
								<div class="scale">
									<img src="../upload/${r11.main_img}" style="border:none"/>
								</div>
							</div>													
							</a>					
						</div>
						
						<div class="info">						
							<div class="info_title ellip">
								<a href="r1BoardDetail.do?board_num=${r11.board_num}">${r11.title}</a>
							</div>
						</div>
					</div>
					</c:forEach>
			

			 	<c:forEach var="r12" items="${getDescRe_main2}" begin="2" end="2">								
					<div class="item" >
					
						<div class="thmb">													
							<a href="r1BoardDetail.do?board_num=${r12.board_num}">
							<div class="img">
								<div class="scale">
									<img src="../upload/${r12.main_img}" style="border:none"/>
								</div>
							</div>													
							</a>					
						</div>
						
						<div class="info">						
							<div class="info_title ellip">
								<a href="r1BoardDetail.do?board_num=${r12.board_num}">${r12.title}</a>
							</div>
						</div>
					</div>
				</c:forEach>

					<c:forEach var="r13" items="${getDescRe_main2}" begin="3" end="3">				
					<div class="item  big no6">
						
						<div class="thmb">
							<a href="r1BoardDetail.do?board_num=${r13.board_num}">
								<div class="img">
									<div class="scale">
										<img src="../upload/${r13.main_img}" style="border:none"/>
									</div>
								</div>
							</a>
						</div>
					
						<div class="info">						
							<div class="info_title ellip">
								<a href="r1BoardDetail.do?board_num=${r13.board_num}">${r13.title}</a>
							</div>
						</div>
					</div>
				</c:forEach>
			
				<c:forEach var="r14" items="${getDescRe_main2}" begin="4" end="4">					
					<div class="item" >
					
						<div class="thmb">													
							<a href="r1BoardDetail.do?board_num=${r14.board_num}">
							<div class="img">
								<div class="scale">
									<img src="../upload/${r14.main_img}" style="border:none"/>
								</div>
							</div>													
							</a>					
						</div>
						
						<div class="info">
							<div class="info_title ellip">
								<a href="r1BoardDetail.do?board_num=${r14.board_num}">${r14.title}</a>
							</div>
						</div>
					</div>
				</c:forEach>
						
				
				<c:forEach var="r15" items="${getDescRe_main2}" begin="5" end="5">				
					<div class="item" >
					
						<div class="thmb">													
							<a href="r1BoardDetail.do?board_num=${r15.board_num}">
							<div class="img">
								<div class="scale">
									<img src="../upload/${r15.main_img}" style="border:none"/>
								</div>
							</div>													
							</a>					
						</div>
						
						<div class="info">
							<div class="info_title ellip">
								<a href="r1BoardDetail.do?board_num=${r15.board_num}">${r15.title}</a>
							</div>
						</div>
					</div>
				</c:forEach>
										
				</div>
			</div>
			
	</div><!-- class="content section03" -->
	<!--추천 레시피-->
			
			
	<!-- sec02 인기레시피 --> 
	<form action="r2.do" >
	
	<div id="hitlist" class="content section05" style="margin-top: 200px">
			<h2 class="main hr" style="text-align: center; font-size:30px">
				<a href="../board/R2BoardList.do" style="color:black">인기레시피</h2></a>
			<hr style="width: 100px;border-top: 3px solid #eee">
			<p class="main" style="text-align: center; font-size:18px">Cookk에서 많은 분들이 찾아본 인기 레시피를 소개합니다.
			
			<!-- 레시피 리스트 -->
			<div class="thmb_list02 pt30" style="margin-top:50px">
				<div class="list_area">
					
					<c:forEach var="r2" items="${getDescRe_main}">				
					<div class="item">
						<div class="thmb">						
							<a href="R2BoardDetail.do?board_num=${r2.board_num}">
							<div class="img">
								<div class="scale">
									<img src="../upload/${r2.main_img}" alt="" style="border:none"/>
								</div>
							</div>
							</a>
							
						</div>
						<div class="info">
							<div class="info_title ellip">
								<a href="R2BoardDetail.do?board_num=${r2.board_num}">${r2.title}</a>
							</div>
						</div>
					</div>
					</c:forEach>
					
					
					
									
			</div><!-- thmb_list02 pt30 -->
		</div><!-- list_area -->		
	</div><!-- content section05 -->
	</form>	
				
	<!-- 이벤트 -->
		<div id="hitlist" class="content section05" style="margin-top: 200px">
			<h2 class="main hr" style="text-align: center; font-size:27px">
				<a href="../board/eventList.do" style="color:black">Cookk's 이벤트</h2></a>
			<hr style="width: 100px;border-top: 3px solid #eee">
			
			<div class="thmb_list02 pt30" style="margin-top:40px">
				<div class="list_area" style="margin-left: 110px;">
					
				
					<c:forEach var="article" items="${list}" begin="0" end="3">				
					<div class="item" style="position: relative; font-color: black; width: 260px; left: -30px;">
						
						<div class="thmb">							
							<a href="eventDetail.do?event_code=${article.event_code}"> 
								<img src="../upload/${article.event_image}" style="width:260px; height:150px; border-radius: 10px;"/>
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
					
			</div><!-- list_area -->
		</div><!-- thmb_list02 pt30 -->
	</div>

		<hr>
    <div id="footer"> 
    	<jsp:include page="Footer.jsp" />
    </div><!-- footer -->
 
 </form>
    
  </body>
</html>
</form>