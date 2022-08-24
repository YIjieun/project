<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <title>COOKK 커뮤니티 회원레시피 게시판</title>
		<link rel='stylesheet' href='../css/bootstrap.css' />
   <link rel='stylesheet' href='../css/style.css' />
   <link rel='stylesheet' href='../css/rp2_style.css' />
   
    <link rel='stylesheet' href='../css/normalize.css' />
<!--    <link rel="stylesheet" href="stylesheets/swiper.min.css">
  <link rel="stylesheet" href="stylesheets/swiper.css">
 -->
  
  <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
    crossorigin="anonymous"></script>
  <script type="text/javascript" src="//wcs.naver.net/wcslog.js"></script>


</head>
<body>
 <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="js/bootstrap.min.js"></script>

<%
		// 작성해 주지 않으면 헤더 쪽에 로그인 했던 id값이 null이 되서 
		//로그아웃이 아니라 로그인으로 글자가 다시 변경된다.
		String manager_id = null;
		if(session.getAttribute("manager_id") != null){
			manager_id = (String)session.getAttribute("manager_id");
		}
	
		String mem_id = null;
		if(session.getAttribute("mem_id") != null){
			mem_id = (String)session.getAttribute("mem_id");
			session.setAttribute("mem_id", mem_id);
		}
		
		System.out.println("mem_id"+mem_id);
%> 

	<!-- header영역 따로 불러옴 -->
 	<div id="header">
        <jsp:include page="./Header.jsp" />
    </div>
    
   <!-- 게시글 상세보기 영역 시작 -->
	<div class="container">
	<div class="con_box">
			<div class="row vertical-center-row">
			<div class="col-lg-6 col-lg-offset-3">
				<span class="btn_write_t">카테고리 >
					<input type="text" value="${board.category}" />
				</span>
				<div class="btn_write">	
					<input type="button" class="pull-right" onclick="location.href='R2BoardList.do'" value="목록으로" />
				</div>
						<div class="con_title_t">
							<div>
								<h3><b>${board.board_num}</b></h3>
							</div>
							<div>
								<h3><b>${board.title}</b></h3>
							</div>
						</div><!-- con_title_t -->		
						<p>
						<div class="main_image" >
							<a href="file.do?main_img=${board.main_img}">
							<img src="../upload/${board.main_img}" />
							</a>
						</div>
						</p>
						<p>
						<div class="rp_title">
							<div class="second">
								<h3><b>${board.writer}</b></h3>
							</div>
							<div class="third">
								<h4>좋아요</h4>						
								<c:choose>
									<c:when test="${board.heart eq 1}">
										<img id="like-img" style="width: 20px; height: 20px; cursor: pointer;" alt=""src="../images/heart.png" />
									</c:when>
									<c:otherwise>
										<img id="like-img" style="width: 20px; height: 20px; cursor: pointer;" alt="" src="../images/emptyHeart.png" />
									</c:otherwise>
								</c:choose>
								<span id="likeCnt">${board.likestate}</span>
							
							<script>
						 //좋아요 하트 출력	
	                          $("#like-img").on("click", function() {//빈하트 클릭시
	                        	   var board_num =  ${board.board_num};
	                              //var mem_id=" ";
	                        	   console.log(board_num);//5
	                    
	                        	   $.ajax({
	                                   url : "${pageContext.request.contextPath}/board/boardLike.do",
	                                   type : "post",
	                                   //data : {board_num:board_num,clickyes:click}, /* {key:value}*/
	                                   data : {board_num:"${board.board_num}",mem_id:"${sessionScope.mem_id}"},
	                                   //,mem_id:mem_id or(또는) userId : "${sessionScope.userId}"(로그인 완성되면 이걸로변경)
	                                   dataType: "json", //json표기법
	                         
	                                   success : function (data) {
	                                	   console.log(data);
	                                 
	                                    if(data.result == 1) {
	                                   
	                                    	  console.log("here1");//5
											$("#like-img").attr("src", "../images/heart.png");
										}
										if(data.result == 0) {
									
											 console.log("here0");//5
											$("#like-img").attr("src", "../images/emptyHeart.png");
										}
										
										$("#likeCnt").html(data.likeCnt);
										//$('#likeCnt').html(data.goodsu);
	                                   },
	                                   error : function(error) {
	                   					alert("Error!");
	                   			    },
	                   			    complete : function() {
	                   			    }
	                   			});
	                        });                       			 
							</script>	

							</div>
							<div class="fourth">
								<h4>등록일</h4>
								${board.postdate}						
							</div>
							<div >								
								<h4>조회수</h4>
								${board.re_view}
							</div>
						</div><!-- rp_title -->
						</p>
						<p>
						<span class="t_box">
							<b>재료</b>
							${board.cook1}
						</span>
						</p>
						<p>
						<span class="h_box">
							<b>만드는 방법</b>
							<!--작성해주지 않으면 enter키를 인식해서 <br>붙음.  -->
						${fn:replace(board.cook2, replaceChar, "<br/>")}
						</span>
						</p>
						<!-- 글쓰기 버튼 생성 -->
						<p>
						<div class="btn_write">	
					    	<input type="submit" class="pull-right" value="수정하기" 
					    	onclick="location.href='R2BoardUpdate.do?board_num=${board.board_num}'" />
					    	<input type="button" value="삭제" 
						   onclick="location.href='BoardDelete.do?board_num=${board.board_num}'" />
						</div>
						</p>
				</div>
						
			</div><!-- row -->
				<!-- 댓글 부분 -->
				<div class="reply" >
					<div class="reply_tit">
						<b>댓글</b>
					</div>				

				<!-- 댓글 목록보기 -->
					<c:forEach var="re" items="${reply}">	
					<div class="reply_con" id="reply_con">
						<div class="re_info">
							<ul id="re_for" style="list-style: none;">
								   <!-- (2)<input type="hidden" value="${re.r_num}" name="r_num" /> -->				   
									<li id="rnum" style="display:none"><b>${re.r_num}&nbsp;</b></li>
									<span><b class="re_infoname" >${re.writer}</b></span>
									<!-- date불러오기 -->
								
									<span><span>|</span></span>
									<span><button type="button" id="re_delete" name="re_delete"
												style="border:0; background-color:#fff">삭제</button></span>
									<span><span class="re_date" id="re_date">${re.r_write_date}</span></span>
									<li class="r_content">${re.r_content}</li>
							</ul>
						<p></p>
					</div> <!-- .re_info -->
					</div><!-- .reply_con -->
					<hr>
				</c:forEach>
					<h5 id="transnum" style="display:none;">${board_num}</h5>
					<script>
						/* (2) */
						$(":button[name='re_delete']").each(function(idx){
							//alert('버튼의 클릭이벤트 연습중')
							$(this).click(function(){
								
								var rnum=parseInt($("ul").find('#rnum').eq(idx).text());
								//var rnum=$('#reply_con #rnum').text().split(" ")
								console.log('삭제 인덱스'+idx,'rnum=>'+rnum) 
										
							var board_num=$('#transnum').text()
							console.log('rnum=>'+rnum,'board_num=>',board_num)
							if(confirm("삭제하시겠습니까?")){
								//location.href="freeBoardDetail.do?board_num=${re.board_num}"
						location.href="delete.do?r_num="+rnum+"&board_num="+board_num;
							}//confirm
							})//click
					})//each
					
					</script>				
					<!-- 댓글 작성부분  -->
					<div class="reply_write">
					    <spring:hasBindErrors name="R2ReplyVO" />
                        <form:errors path="R2ReplyVO" />
						<form role="form" name="r2_reply" method="post" action="R2Reply.do">
							<div class="form_group">
							<input type="hidden" name="board_num" value="${board.board_num}">
							<input type="hidden" name="mem_id" value="${board.mem_id}">
							<input type="hidden"  id ="test2" value="${board99.writer}" readonly="readonly" />
							<!-- 로그인시 아이디만 입력해서 오기 때문에 작성자는 넘어오지 않는다. board99안에 작성자를 setwriter 하여 받아온 것을 출력해준다. -->
							<input type="hidden" name="writer" id ="writer_val"  value="${board.writer}">
									<script>
										$(document).ready(function() {
											var writer_val = $("#test2").val();

											 $("#writer_val").val(writer_val);
										});	
					</script>		
							<textarea id="reply_write" onclick="#" placeholder="댓글을 입력해주세요" 
										style="height:100px; width:85%; margin-top:0;" name="r_content"
										class="reply_write form-control">${R2ReplyVO.r_content}</textarea>
							<span class="btn_group">
								<input type="submit" value="등록" style="height:100px;vertical-align:middle;"
								onclick="location.href='R2BoardDetail.do?board_num=${board.board_num}'" />
							</span>
							</div>
						</form> <!-- input_group -->
					</div>
				</div><!-- .reply -->
		</div>
	</div><!-- container -->
	<!-- 게시판 글쓰기 양식 영역 끝 -->
	
	<!-- footer 따로 불러옴 -->
	<div id="footer">
       <jsp:include page="./Footer.jsp" />
    </div>
    
</body>
</html>