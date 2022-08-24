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
	<title>login</title>
    
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
  
  <script type="text/javascript">

  // 공백 체크
  function login() {
	  
		if ($("#mem_id").val() == "") {			
			$(".id").text("아이디를 입력해주세요 :)");
			$('.id').css("color", "red");
			return	
		}		
		else if ($("#passwd").val() == "") {
			$(".passwd").text("암호를 입력해주세요 :)");
			$('.passwd').css("color", "red");
			return
		}	
		else{
			$('#login').submit();
			
		}
  }


</script>
   
  
    
</head>
  
  <body>
  
  <form action="login.do" method="post" id="login">
  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
           
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
						<h1><b>Login</b></h1>
						</div>                     
                    </div>

				<c:if test="${member == null}"> 
					<!-- 아이디 -->
					<div class="input-group margin-bottom-20">
                        <span class="input-group-addon"  style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/user.png" style="width:35px; height:35px" />
                        </span>
                        
                        <input type="text" id="mem_id" name="mem_id" placeholder="아이디" class="form-control">
                        	<span class="id"></span>
                    </div>                    
                    
                    <!-- 암호 -->
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon" style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/passwd.png" style="width:35px; height:35px" />
                        </span>
                        
                        <input type="password" id="passwd" name="passwd" placeholder="암호" class="form-control" >
                        	<span class="passwd"></span>
                    </div>                    
                      
                    <div class="row">
                        <div class="col-md-6 col-md-offset-5" style="padding-left:0px;">
                            <input class="btn-u" type="button" value="로그인" onclick="login();" /><br><br> 
                           
                           <c:if test="${msg == false }">                         
      		                   <span style="position: relative;right: 40px; color: red">아이디와 비밀번호 확인해주세요 !</span>  			 
                           </c:if>	
                       
                        </div>
                    </div>
              </c:if> 					
					
                    <hr style="margin-bottom:20px">

                    <h5>비밀번호 찾기</h5>
                    <p>암호를 잊으셨나요? 
                    <a href="../board/FindPassword.do" class="color-green">여기를 클릭하세요.</a>
                    </p>
                    
                    
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