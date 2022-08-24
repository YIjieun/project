<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>FindPassword</title>
    
    <!-- 헤더 푸터 -->
	 <link rel='stylesheet' href='../css/normalize.css' />
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel='stylesheet' href='../css/style.css' />
      
    <!-- 로그인, 회원가입 -->
    <link rel="stylesheet" href="../css/app.css">
    <link rel="stylesheet" href="../css/font.css">  
    <link rel="stylesheet" href="../css/page_log.css">  
    
    <link rel='stylesheet' href='../css/fb_style.css' /> 
    <link rel="stylesheet" href="../css/custom.css">  
    <link rel="stylesheet" href="../css/Footer2.css">  
       
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
    
</head>
  
  <body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>

<form action="find_password.do" method="post" >

           
   <div id="header"> 
    	<jsp:include page="Header.jsp" />
    </div>
    
 <div class="wrapper">
    <div class="container content">		
    	<div class="row">
            <div class="col-md-3 col-md-offset-7" style="margin-left: 35%;">
                <form class="reg-page" style="padding:30px 180px;">
                    <div class="reg-header">            
                       <div class="con_title">
							<div>
								<img src="../images/login.png"/>
							</div>
						<h2><b>암호 찾기</b></h2>
						</div>                     
                    </div>
                    
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"  style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/user.png" style="width:35px; height:35px" />
                        </span>
                        <input type="text" id="mem_id" name="mem_id" placeholder="아이디" class="form-control">
                    </div>  

					<div class="input-group margin-bottom-20">
                        <span class="input-group-addon"  style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/name.png" style="width:35px; height:35px" />
                        </span>
                        <input type="text" id="name" name="name" placeholder="이름" class="form-control" autofocus onkeyup="enterKeyCheck()">
                    </div>                    
                    
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon" style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/phone.png" style="width:35px; height:35px" />
                        </span>
                        <input type="text" id="phone" name="phone" placeholder="연락처" class="form-control" onkeyup="enterKeyCheck()">
                    </div>                    
                            
                    <div class="row">
                        <div class="col-md-6 col-md-offset-5" style="padding-left:0px;">
                            <input class="btn-u" type="submit" value="암호 찾기" >                 
                        </div>
                    </div>
<hr>
		<!-- 정보가 일치하지 않을 때-->
		<c:if test="${check == 1}">
			<script>
				opener.document.findform.mem_id.value = "";
				opener.document.findform.name.value = "";
				opener.document.findform.phone.value = "";
			</script>
			<label>일치하는 정보가 존재하지 않습니다.</label>
		</c:if>

		<!-- 일치할때 -->
		<c:if test="${check == 0 }">
			<div>
				<label>회원님의 비밀번호는 "${passwd}" 입니다</label><br>
					<p>로그인 페이지로 돌아가려면 
                    	<a href="../board/login.do" class="color-green">여기를 클릭하세요.</a>
                    </p>
			</div>
		</c:if>            
                    
                    
                </form>            
            </div>
        </div><!--/row-->
    </div><!--/container-->		
</div><!--/wrapper-->

  <hr>
    
	<div id="footer"> 
    	<jsp:include page="Footer.jsp" />
    </div><!-- footer -->
   
   </form>
    
  </body>
</html>