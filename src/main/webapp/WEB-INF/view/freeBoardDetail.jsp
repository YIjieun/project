<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

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

<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <title>freeBoard</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel='stylesheet' href='../css/style.css' />
    <link rel='stylesheet' href='../css/fb_style2.css' />
</head>
<body>
    
 <div id="header">
        <jsp:include page="Header.jsp" />
    </div>
    
    
	<div class="container" style="padding-bottom:0">
	<div class="row vertical-center-row">
		<div class="col-lg-7 col-lg-offset-3">
			<h1 class="fb_tit"><b>자유게시판</b></h1>
						<!-- <span class="btn_write">	
							<input type="button" class="pull-right" onclick="location.href='freeBoardList.do'" value="목록으로" />
						</span> -->
						
						<div class="conbox">
						<%-- <span>${board.board_num}</span> --%>
							<span class="fb_category">카테고리 > ${board.f_category}</span>
							<h2 style="margin-bottom:18px">${board.f_title}</h2>
							<span style="color:gray">작성자</span>
							<span id="writerVal">${board.writer}</span>&nbsp;&nbsp;&nbsp;
							<span style="color:gray">조회수</span>
							<span>${board.f_view}</span>
							
							<div class="fb_con">
								<div class="main_image" style="margin:30px 0 18px;">
										<img src="../upload/${board.f_img}" style="width:400px; height:400px;" onerror="this.style.display='none'" />
							</div>
								<p>${board.f_content}</p>
							</div>
							
						
							<p>
							
								<span class="btn_write">
								<input type="button" value="수정" id="update_btn"
								   onclick="location.href='freeBoardUpdate.do?board_num=${board.board_num}'">
								<input type="button" value="목록" 
									onclick="location.href='freeBoardList.do'">	
								</span>
							</p>
							
						
							
				<!-- 댓글 부분 -->
				<div class="reply" >
					<div class="reply_tit">
						<b>댓글</b>
					</div>				
					
				<!-- 댓글 목록보기 -->
				<c:forEach var="re" items="${reply}">	
					<div class="reply_con" id="reply_con">
						<div class="re_info">
							<ul id="re_for">
								   <!-- (2)<input type="hidden" value="${re.r_num}" name="r_num" /> -->
								   
									<li id="rnum"><b>${re.r_num}&nbsp;</b></li>
									<li id="r_writer"><b class="re_infoname">${re.writer}</b></li>
									<!-- date불러오기 -->
									<li><span>|</span></li>
									<li><button type="button" id="re_delete" name="re_delete"
												style="border:0; background-color:#fff">삭제</button></li>
									<li><span class="re_date" id="re_date">${re.r_write_date}</span></li>
									<li class="r_content">${re.r_content}</li>
							</ul>
						<p></p>
					</div> <!-- .re_info -->
					</div><!-- .reply_con -->
					<hr>
					</c:forEach>
					<h5 id="transnum" style="display:none;">${board_num}</h5>
					<script>

						//게시글 작성자만 수정가능
						$(function(){
							var writerVal=$("#writerVal").text();
							
							
						if(writerVal!="${voboard.writer}" || writerVal!="${board.writer}"){
								$("#update_btn").css({"display":"none"});
								return;
							}
							
							
						})
						
						//작성자만 댓글 삭제 가능
						/*$(function(){
							var r_writer=$('#r_writer').text();
							if(r_writer!="${voboard.writer}"){
								$("#re_delete").css({"display":"none"});
								$("#re_date").before("&nbsp;");
								return;
							}
						})*/
						//댓글버튼 작성자만 수정가능
						
				
						/* 댓글 삭제구문 */
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
						location.href="delete2.do?r_num="+rnum+"&board_num="+board_num;
							}//confirm
							})//click
					})//each
						
					</script>
					
					
					<!-- 댓글 작성부분  -->
					<div class="reply_write">
					    <spring:hasBindErrors name="FreeReplyVO" />
                        <form:errors path="FreeReplyVO" />
						<form role="form" name="free_reply" method="post" action="freeReply.do">
							<div class="form_group">
							<input type="hidden" name="board_num" value="${board.board_num}">
							<input type="hidden" name="mem_id" value="${board.mem_id}">
							<input type="hidden" name="writer" value="${board.writer}">
							<textarea id="reply_write" onclick="#" placeholder="댓글을 입력해주세요" 
										style="height:100px; width:85%; margin-top:0;" name="free_reply"
										class="reply_write form-control">${FreeReplyVO.r_content}</textarea>
										
							<span class="btn_group">
								<input type="submit" value="등록" style="height:100px;vertical-align:middle;">
							</span>
							</div>
						</form> <!-- input_group -->
					</div>
				</div><!-- .reply -->
							
			</div>	<!-- conbox -->			
			
			</div>
		</div> 
	</div> <!-- container -->

	<div id="footer">
       <jsp:include page="Footer.jsp" />
    </div>
    </body>
    </html>