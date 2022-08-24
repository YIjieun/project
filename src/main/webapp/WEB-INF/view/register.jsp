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
    <title>register</title>
    
    <!-- 공통 -->
	 <link rel='stylesheet' href='../css/normalize.css' />
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel='stylesheet' href='../css/style.css' />
    <link rel='stylesheet' href='../css/fb_style.css' /> 
      
    <!-- 로그인, 회원가입 -->
    <link rel="stylesheet" href="../css/app.css">
    <link rel="stylesheet" href="../css/font.css">     
    <link rel="stylesheet" href="../css/page_log.css">
    <link rel="stylesheet" href="../css/Footer2.css"> 
    
    <link rel="stylesheet" href="../css/custom.css">  
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    
    <script>
 
  //최종 틍록하기 버튼 클릭
	function signUp() {
	  
			if ($("#mem_id").val() == "") {			
				$(".id").text("아이디를 입력해주세요 :)");
				$('.id').css("color", "red");
				return
			}		
			else if ($("#writer").val() == "") {
				$(".writer").text("닉네임을 입력해주세요 :)");
				$('.writer').css("color", "red");
				return 
			}			 
			else if ($("#passwd1").val() == "") {							
				$('.passwd1').text("암호를 입력해주세요 :)")
				$('.passwd1').css("color", "red");
				 return 
			}
			else if ($("#passwd2").val() != $("#passwd1").val()) {										
				$('.passwd2').text("암호가 일치하지 않습니다 :)")
				$('.passwd2').css("color", "red");
				 return 
			}
			else if ($("#name").val() == "") {											
				$('.name').text("이름을 입력해주세요 :)")
				$('.name').css("color", "red");
				 return 
			}
			else if ($("#phone").val() == "") {											
				$('.phone').text("연락처를 입력해주세요 :))")
				$('.phone').css("color", "red");
				 return 
			}
			else{
				$('#reigster').submit();
			}
								
	} //signUp()
    
    
	//아이디 중복검사
	 function idcheck(){

		var mem_id = $('#mem_id').val();			
		var data = {mem_id : mem_id}			
		
		$.ajax({
			type : "post",
			url : "memberIdChk.do",
			data : data,
			success : function(result){
				 console.log("id Ajax 성공 여부" + result);	
				 
					if(result != 'fail'){ // 성공
						 $('.id').text("사용 가능한 아이디 입니다 :)")
						 $('.id').css("color", "green");		
					} else  {
						$('.id').text("사용중인 아이디 입니다 :(")
						 $('.id').css("color", "red");				
					}				

			}		
		}); // ajax			
		
	}// idcheck()
	
	
	// 닉네임 중복검사
	 function writercheck(){
		var writer = $('#writer').val();			
		var data = {writer : writer}			
	
		$.ajax({
			type : "post",
			url : "writerChk.do",
			data : data,
			success : function(result){
				 console.log("writer Ajax 성공 여부" + result);	
				 
				   if(result != 'fail' ){
						 $('.writer').text("사용 가능한 닉네임 입니다 :)")
						 $('.writer').css("color", "green");				
					} else {
						$('.writer').text("사용중인 닉네임 입니다 :( ")
						$('.writer').css("color", "green");					
					}						 
			
			}
		}); // ajax		
	}// idcheck()
						
		
	
	
</script>
	
  </head>
  
  <body>
  
   <form action="register.do" id="reigster" method="post">  
   
    <div id="header"> 
    	<jsp:include page="Header.jsp" />
    </div>
    
 <div class="wrapper">
 
    <div class="container content">		
    
    	<div class="row">
    	
            <div class="col-md-3 col-md-offset-7" style="margin-left: 37%;">
            
                <form class="reg-page" style="padding:30px 180px;">
                
                    <div class="reg-header">            
                       <div class="con_title">
							<div>
								<img src="../images/login.png"/>
							</div>
						<h2><b>회원가입</b></h2>
						</div>                     
                    </div>
                    
                    	<!-- 등급 
                    		<input type="hidden" name="grade" value=1 />
                    	 -->
						<!-- 아이디 -->
				
					 <div class="input-group margin-bottom-20">
                        <span class="input-group-addon" style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/user.png" style="width:35px; height:35px" />
                        </span>
                                              
                        <input type="text" id="mem_id" name="mem_id" placeholder="아이디" class="form-control" />
                        
                        <span class=id></span>

                        	<span class="input-group-addon" style="border:none;background-color:white;" >
                            	<button type="button" class="btn-u" id="id_input" onclick="idcheck();" 
                            				style="margin-left: 15px;">중복확인</button>                        
                         	</span>   
                    </div>    
                    
                               
                     <!-- 닉네임 -->                                
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon" style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/ninkname.png" style="width:35px; height:35px" />
                        </span>
                        
                        <input type="text" id="writer" name="writer" placeholder="닉네임" class="form-control" />
                        
                        <span class="writer"></span>
                        
                        	<span class="input-group-addon" style="border:none;background-color:white;" >
                            	<button type="button" id="writer_input" class="btn-u" onclick="writercheck();"
                            				style="margin-left: 15px;">중복확인</button>                        
                         	</span>                   	
                    </div>  
                       
                       <!-- 암호 -->
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon" style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/passwd.png" style="width:35px; height:35px" />
                        </span>
                        
                        <input type="password" id="passwd1" name="passwd" placeholder="암호" class="form-control" />
                    		
                    		<span class="passwd1"></span>
                    		
                    </div>                    
                    
                    <!-- 암호확인 -->
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon" style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/check.png" style="width:35px; height:35px" />
                        </span>
                        
                        <input type="password" id="passwd2" placeholder="암호 확인" class="form-control" />
                    	
                    	<span class="passwd2"></span>
                    	
                    </div>    
                                         
                    <!-- 이름 -->
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon" style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/name.png" style="width:35px; height:35px" />
                        </span>
                        
                        <input type="text" id="name" name="name" placeholder="이름" class="form-control" />
                        
                       <span class="name" ></span> 
                       
                        
                    </div>  
                    
                         
                    <!-- 연락처 -->
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon" style="padding:3px 10px;border:none;background-color:white;">
                        	<img src="../images/phone.png" style="width:35px; height:35px" />
                        </span>
                        
                        <input type="text" id="phone" name="phone" placeholder="연락처" class="form-control" />
                    	
                    	<span class="phone" ></span>
                    	
                    </div>                         
                
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4" >
                            <input type="button" class="btn-u" value="가입하기" id="button1" onclick="signUp();" 
                            			style="width:170px; font-size:16px; margin-top:30px; border-radius: 10px;">
                        </div>
                    </div>
                            
            </div><!-- col-md-4 -->
            
        </div><!--/row-->
    </div><!--/container-->		
</div><!--/wrapper-->

	  <hr>
	    <div id="footer"> 
	    	<jsp:include page="Footer.jsp" />
	    </div>
	    
      </form><!-- form action -->
      
  </body>
</html>