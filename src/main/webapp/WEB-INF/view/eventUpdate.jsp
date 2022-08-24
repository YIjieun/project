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
    
    <title>eventUpdate</title>
    
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
    <script src=".../js/bootstrap.min.js"></script>  
    
 </head>
  
<body>
<!-- header -->
 <div id="header">
   <jsp:include page="Header.jsp" />
</div><!-- header -->

	<form action="eventUpdate.do"  enctype="multipart/form-data" method="post">

<!--수정 (글쓰기랑 동일) -->

	<div class="container mtp-0" style="padding-bottom: 10%;">
		<div class="box mh500">
		
			<div class="con_title" style="padding-top:70px;">
				<div>
					<img src="../images/event.png" />
				</div>
				<h1 style="text-align:center"><b>이벤트</b></h1>
			</div>
									
			<input type="submit" class="board_list_btn" style="position: relative; right: 60px;" value="저장하기" >
			
			<input type="button" class="board_list_btn" style="position: relative; right: 60px;"
            			value="삭제" onclick="location.href='deleteBoard.do?event_code=${command.event_code}'"/>          			
						
			<input type="button" class="board_list_btn" style="float:left; position: relative; left:120px;" onclick="location.href='eventList.do'"  value="목록으로" />		
 

			<div class="container">
				
				<div style="width:70px;font-size:20px; margin:30px 70px 0;" >
					NO:<input type="text" style="border:none; position:relatvie" name="event_code" value="${command.event_code}"></input>
				</div>
									
				<table class="board_lg" style="margin:20px 70px">
					<thead>
						<tr>										
							<th style="width:120px">작성자</th>
							<th style="width:0px;">제목</th>
							<th style="width:0px;">진행여부</th>
							<th style="width:0px;">시작일</th>
							<th>종료일</th>								
						</tr>
					</thead>				

					<tbody>
						<tr>	
							<td>
								<input type="text" class="form-control" name="manager_id" style="width:120px;font-size:13px;position: relative; left: 20px;" value="test" readonly="readonly" />
							</td>		
											
							<td >
								<input type="text" class="form-control" style="width:370px;font-size:14px; position: relative; left: 50px;" name="e_title" value="${command.e_title}">
							</td>	
								
							<td>
								<input type="text" class="form-control" name="event_yn" style="width:120px;font-size:16px;position: relative; left:13px;" value="${command.event_yn}" />
							</td>

							<td>
							<input type="Date" class="form-control" style="width: 150px; position:relative; left:20px;" name="e_write_date" value="${command.e_write_date}" />
							</td>
							
							<td>
								<input type="Date" class="form-control" name="event_date" style="width:150px" value="${command.event_date}" />
							</td>
							
						</tr>
						
						<tr>			
							<td class="b_content" colspan="4.5" style="border: 1px;">
							
								<div style="float:left; margin:30px 0; position: relative; left: 10px">		
										
									<div style="float:left">																
										<!--전에 이미 업로드된 파일이 있는 경우에만 수행  -->
										<c:if test="${!empty command.event_image}">
											(${command.event_image}) 파일이 등록되어있습니다. <br>수정을 원하시면 파일을 다시 선택 하세요.
										</c:if>
									</div>	
									
									<div >								
										<input type="file" class="form-control" style="height:40px; box-shadow: none;  border-color: #bbb;  border-radius: 3px;" 
													id="upload" name="upload">
									</div>							
								</div>
				
								<div>
									<img src="../upload/${command.event_image}" style="width: 70%; height: 250px; margin: 10% 20% 5%;" /> 
								</div>
								
								<div style="position:relative; left:60px;">
									<textarea name="e_content" rows="8" cols="130" style=" border: 1px solid #e4e4e4;border-radius: 3px;padding: 6px 12px;">
									${command.e_content}</textarea>														
								</div>	
			
							</td>			
						</tr>
						
					</tbody>
				</table>
					
			</div>
	
		</div>
	</div><!-- container -->
	
	</form>
	
 <hr>
    <div id="footer"> 
    	<jsp:include page="Footer.jsp" />
    </div><!-- footer -->
  
  </body>
  </html>  
