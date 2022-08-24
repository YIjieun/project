<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <title>COOKK 커뮤니티 관리자레시피 게시판</title>
	<link rel='stylesheet' type="text/css" href='../css/bootstrap.css' />
   <link rel='stylesheet'  type="text/css" href='../css/style.css' />
   <link rel='stylesheet' type="text/css" href='../css/r1_style.css?ver=1' />
  
  <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
    crossorigin="anonymous"></script>
  <script type="text/javascript" src="//wcs.naver.net/wcslog.js"></script>

<!-- <script>
	$(function(){
		var writer2Val=$("writer2Val").text();
		
		if(writer2Val!="${board.writer2}"){
			console.log("${board.writer2}")
			$("#update_btn").css({"display":"none"});
		}
	})
</script>  -->

</head>
<body>
 <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="js/bootstrap.min.js"></script>

<%
		// 메인 페이지로 이동했을 때 세션에 값이 담겨있는지 체크
		String manager_id = null;
		if(session.getAttribute("manager_id") != null){
			manager_id = (String)session.getAttribute("manager_id");
		}
		String mem_id = null;
		if(session.getAttribute("mem_id") != null){
			mem_id = (String)session.getAttribute("mem_id");
			session.setAttribute("mem_id", mem_id);
		}
%>
	<!-- header영역 따로 불러옴 -->
 	<div id="header">
        <jsp:include page="./Header.jsp" />
    </div>
    
   <!-- 게시글 상세보기 영역 시작 -->
	<div class="container" style="padding-bottom:0">
	<div class="row vertical-center-row">
		<div class="col-lg-7 col-lg-offset-3">
		<h1 class="r1_tit"><b>인기 레시피</b></h1>
			<div class="conbox">
				<span class="r1_category">카테고리 > ${board.category}</span>
				<div class="con_title_t">
					<div>
						<h3 id="num">${board.board_num}</h3>
					</div>
					<div>
						<h3><b>${board.title}</b></h3>
					</div>
				</div><!-- con_title_t -->
				<p>
				<div class="r1_con">
				<div class="main_image" style="margin:30px 0 18px;">
					<img src="../upload/${board.main_img}" style=" width:450px; height:300px;" onerror="this.style.display='none'" />
					<div id="click" style="display:none">${board.click}</div>
				</div>
				</div>
				
				<p>
				<div class="rp_title">
					<div class="second">
						<h3><b>${board.writer2}</b></h3>
					</div>
					<!-- 좋아요 -->
					<div class="third">
					<h4 id="login" style="display:none">${mem_id}</h4>
					<script>
                     //좋아요 하트 출력
                     $(function() {
                     $("#like-img2").show();//빈하트
                           $("#like-img2").on("click", function() {//빈하트 클릭시
                        	   var board_num =  parseInt($("#num").text()); 
                               var mem_id=$('#login').text();
                               var click= parseInt($('#click').text());
                        	   console.log('board_num=>',board_num,'mem_id=>',mem_id,'click=>',click)//5 click추가
                        	   
                        	   $.ajax({
                                   url : "clickHeart.do",
                                   type : "post",
                                   //data : {board_num:board_num,clickyes:click}, /* {key:value}*/
                                   data : {board_num:board_num,mem_id:mem_id,click:click},
                                   dataType: "json", //json표기법
                                   success : function (data) {     
                                	 console.log("success함수호출(data)=>"+data)
                                     if(data.result == 1) {//채워진 하트로 변경
										$("#like-img2").attr("src", "../images/heart1.png");
									}else if(data.result == 0) {//빈하트로 변경
										$("#like-img2").attr("src", "../images/heart0.png");
									}
									//$("#likeCnt").html(data.likeCnt);
								    console.log('data.goodsu=>',data.goodsu)
									$('#heart').text(data.goodsu);
								    //<div id="click">${board.click}</div>
								    
								    $('#click').text(data.clickCheck);
									/*
									console.log('data.checkLike->'+data.checkLike)
									$('#click').html(data.checkLike);
									*/
                                   }
                               });
                           //$(this).attr("src", "../images/heart1.png");//꽉찬하트로 이미지변경
                            });                
                        });
                     </script>
                     <h4 style="display:none">좋아요</h4>
                     <h4 id="heart">${board.heart}</h4>
                     <!-- <img id="like-img1" style="width: 20px; height: 20px; cursor: pointer;" alt="" src="../images/heart1.png" />--> 
                     <img id="like-img2" style="width: 20px; height: 20px; cursor: pointer;" alt="" src="../images/heart0.png" />
					</div>
					<div class="fourth">
						<h4>등록일</h4>
						${board.postdate}
					</div>
					<h4>조회수</h4>
						${board.re_view}
					</div><!-- rp_title -->
					<p>
					<span class="t_box">
						<b>재료</b>
						${board.cook1}
					</span>
					</p>
					<p>
					<span class="h_box">
						<b>만드는 방법</b>
						${fn:replace(board.cook2, replaceChar, "<br/>")}
					</span>
					<p>
					<!-- 글쓰기 버튼 생성 -->
					<p>
					<span class="btn_write">
					<c:if test="${member2.manager_id != null}">
						<input type="button" id="update_btn" value="수정"
						onclick="location.href='r1BoardUpdate.do?board_num=${board.board_num}'" />
					</c:if>
					</span>
					<span class="btn_write">
						<input type="button" class="pull-right" onclick="location.href='r1BoardList.do'" value="목록으로" />
					</span>
					</p>
				</div>	<!-- conbox -->
			</div><!-- grid -->
		</div> <!--Row-->
	</div> <!-- container -->
	<!-- 게시판 글쓰기 양식 영역 끝 -->
	
	<!-- footer 따로 불러옴 -->
	<div id="footer">
       <jsp:include page="./Footer.jsp" />
    </div>
    
</body>
</html>