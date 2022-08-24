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
    
    <title>event_write</title>
    
    <!-- 공통 -->
	 <link rel='stylesheet' href='../css/normalize.css' />
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel='stylesheet' href='../css/style.css' />
    <link rel='stylesheet' href='../css/fb_style.css' />  
      
      <!-- 이벤트 -->
    <link rel="stylesheet" href="../css/main2.css">
    <link rel="stylesheet" href="../css/sub2.css">   
    <link rel="stylesheet" href="../css/event.css">
    
    <link rel="stylesheet" href="../css/custom.css">  
      
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>  
 </head>

<!-- header -->
 <div id="header">
   <jsp:include page="Header.jsp" />
</div><!-- header -->

	<div class="container mtp-0" style="padding-bottom: 10%;">
		<div class="box mh500">
		
			<div class="con_title" style="padding-top:70px;">
				<div>
					<img src="../images/event.png" />
				</div>
				<h1 style="text-align:center"><b>이벤트</b></h1>
			</div>
						
			<input type="button" class="board_list_btn" style="position: relative; right: 60px;" 
						value="수정" onclick="location.href='eventUpdate.do?event_code=${board.event_code}'"/>
						        
            <input type="button" class="board_list_btn" style="float:left; position: relative; left:120px;"
            			value="목록보기" onclick="location.href='eventList.do'"/>
		
	
			<div class="container">
				<table class="board_lg" style="margin: 0 180px 30px;">
					<thead>
						<tr>
							<th>No</th>
							<th style="width:400px;">제목</th>
							<th>작성자</th>
							<th>시작일</th>
							<th>종료일</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td>${board.event_code}</td>
							<td style="width:400px;">${board.e_title}</td>
							<td>${board.manager_id}</td>
							<td>${board.e_write_date}</td>
							<td>${board.event_date}</td>
						</tr>
						
					<tr style="border: none;">
						<td class="b_content" colspan="4">
							
							<img src="../upload/${board.event_image}" style="width: 70%; height: 250px; margin: 8% 19% 2%;" />

							<div class="item__Meta-sc-1puup1i-2 crmenN" style="width: 70%; margin-left: 19%">
								<span class="item__State-sc-1puup1i-3 fZSMWd" name="event_yn">${board.event_yn}</span>
								<span class="item__DateText-sc-1puup1i-4 loJNuz">${board.e_write_date} ~ ${board.event_date}</span>
							</div>  
							
							<!-- custom.css 안먹음  -->
							<div class="event_write">${board.e_content}</div>
						</td>
					</tr>
						
					</tbody>
				</table>
				
			</div><!-- container -->
			
		</div><!-- box -->
	</div><!--container mtp-0 -->
	
 <hr>
    <div id="footer"> 
    	<jsp:include page="Footer.jsp" />
    </div><!-- footer -->
    
  </body>
  </html>  








