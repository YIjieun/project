<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
     <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>header</title>
    
	 <link rel='stylesheet' href='../css/normalize.css' />
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel='stylesheet' href='../css/style.css' />
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    <!-- 로그아웃 추가 -->
	$(document).ready(function(){
		$("#logoutBtn").on("click", function(){
			location.href="logout.do";
		})
		
	})
	
	</script>
    
  </head>
  
  <body>  
    <div id="header">
     <div class="headerCon">
      <div class="headerTop">
       
       <c:if test="${member2 == null}"> 
           <a href="../board/manager.do" style="float:left" >관리자</a>
        </c:if>
        <c:if test="${member2 != null}"> 
           <a id="logoutBtn" onclick="location.href='logout.do'">로그아웃</a>         
        </c:if>
                
          
        <ul class="headerMenu">   
        	<c:if test="${member == null}"> 
        		<li><a href="../board/register.do">회원가입</a></li>
	            <li><a href="../board/login.do">로그인</a></li>             
	         </c:if>     
	          
	         <c:if test="${member != null }">
	         	<li style="width: 120; color:white">${member.mem_id} 환영 합니다.</li>
				<li id="logoutBtn" style="color:white">로그아웃</a></li>	         
	            <li><a href="../board/MyPage.do">마이페이지</a></li>
	          </c:if>
        	</ul>  
           
        	
        
      </div>
    </div>
      
   <div class="m_headerCon">
    <ul class="m_topMenu">
          <li>
          	<a href="../board/Main.do" class="logoB" >
          		<img class="logo" src="../images/cookk_png.png" />
          	</a>
          </li> 
    </ul>  
    
</div><!-- m_headerCon: 메인로고 -->

<script>
    $(document).ready(function () {
        var sc = $(".gnbRight").offset();
        //console.log(sc);
        //console.log($(document).scrollTop());

        $(window).scroll(function () {
            //console.log($(document).scrollTop());
            if ($(document).scrollTop() > sc.top) {
                $(".gnbRight").addClass("menu_fixed");
            }
            else {
                $(".gnbRight").removeClass("menu_fixed");
            }
        });
    });

</script>

      <div class="gnbCon">
    <div class="gnbBox">
        <div class="gnbLeft">           
          	<a href="../board/Main.do" class="logoB" >
          		<img class="logo" src="../images/cookk_png.png" />
          	</a>
        </div>
        
        <div class="gnbRight">
            <ul class="gnb">
                <li><a href="../board/r1BoardList.do">관리자작성</a></li>
	            <li><a href="../board/R2BoardList.do">회원작성</a></li>
	            <li><a href="../board/freeBoardList.do">자유게시판</a></li>
	            <li><a href="../board/eventList.do">이벤트</a></li>
            </ul>
        </div>
    
    </div><!-- gnbBox -->
</div> <!-- gnbCon -->

   
    </div><!-- header -->
    
  </body>
</html>