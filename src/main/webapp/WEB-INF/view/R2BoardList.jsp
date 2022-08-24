<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <title>COOKK 커뮤니티 회원레시피 게시판</title>
   	<link rel='stylesheet' href='../css/bootstrap.css' />
   <link rel='stylesheet' href='../css/style.css' />
   <link rel='stylesheet' href='../css/rp2_style.css' />
  
   <!-- header영역 따로 불러옴 -->
 	<div id="Header">
        <jsp:include page="Header.jsp" />
    </div>
    <%
		// 메인 페이지로 이동했을 때 세션에 값이 담겨있는지 체크
		String manager_id = null;
		if(session.getAttribute("manager_id") != null){
			manager_id = (String)session.getAttribute("manager_id");
		}
	
		String mem_id = null;
		if(session.getAttribute("mem_id") != null){
			mem_id = (String)session.getAttribute("mem_id");
		}
%>

    <!-- 게시판 메인페이지 영역 시작 -->
	<div class="container">
	<div class="con_box">
		<div class="con_box">
			<div class="con_title">
				<div>
					<img src="../images/spoon.png"/>
				</div>
					<h1><b>회원레시피</b></h1>
				</div><!-- con_title -->
			<!-- 인기레시피 이미지 -->
			 <ul>
                  <li>
            <!-- 조회수가 높은 순서대로 3개의 레시피가 display된다.-->
                    <c:forEach var="review" items="${reviewList}">
                     <a href="R2BoardDetail.do?board_num=${review.board_num}">
                      <img src="../upload/${review.main_img}" />
                      <p class=videoTit>
                      	[${review.category}] &nbsp;${review.title}
                      </p>
                    </a> 
                    </c:forEach>
                  <!--   </div> -->
                  </li>
			</ul>
			<!-- 글쓰기 버튼 생성 -->
			<span class="btn_write">	
			<!--   <input type="button" onclick="location.href='freeBoardWrite.do'" value="글쓰기"> -->
			 <input type="button" onclick="location.href='R2BoardWrite.do'" value="레시피작성"> 
			   <!--  <a href="R2BoardWrite.do">레시피 작성</a> -->
			</span>
		<div class="table-responsive con_table">
			<table class="table table-hover"  
			cellpadding="0" cellspacing="0" > 
				<thead>
			    	<tr height="30"> 
				      <td>no</td> 
				      <td>제목</td> 
				      <td>작성자</td>
				      <td>작성일</td> 
				      <td>조 회</td> 
			  	  </tr>
			    </thead>
			    
			    <!-- 레코드가 없다면 -->
				<c:if test="${count==0}">
				    <tr>
				       <td colspan="5" align="center">
				          등록된 게시물이 없습니다.
				       </td>
				    </tr>
				</c:if>
				
			    <tbody>
			    <c:forEach var="article" items="${list}">
				    <tr>
				    	<td>${article.board_num}</td>
				    	<td><a href="R2BoardDetail.do?board_num=${article.board_num }">[${article.category}]${article.title}</a></td>
				    	<td>${article.writer}</td>
				    	<td>${article.postdate}</td>
				    	<td>${article.re_view}</td>
				    </tr>
			    </c:forEach>
				</tbody> 
			</table>
			</div> <!-- table-responsive con_table -->
			
			<div class="paging">${pagingHtml}
				<!-- <ul class="pagination pagination-xs">
				 	<li><a href="#"> < </a></li>
				 	<li class="active"><a href="#">1</a></li>
				 	<li><a href="#">2</a></li>
				 	<li><a href="#">3</a></li>
				 	<li><a href="#">4</a></li>
				 	<li><a href="#">5</a></li>
				 	<li><a href="#">6</a></li>
				 	<li><a href="#">7</a></li>
				 	<li><a href="#">8</a></li>
				 	<li><a href="#">9</a></li>
				 	<li><a href="#">10</a></li>
				 	<li><a href="#"> > </a></li>
				 </ul> -->
			</div>
			<!-- 검색창 -->
			<div class="row vertical-center-row">
			<div class="text-center col-lg-4 col-lg-offset-4">
			<form class="navbar-form" role="search">
				
	     		<div class="form-group">
	     			<input type="text" class="form-control" placeholder="레시피를 검색해보세요">
	     		</div>
	     		<button type="button" class="btn btn-default">검색</button>
	     	</form>
	     	</div>
	     	</div>
		</div> <!-- conbox -->
	</div> <!-- container -->
	<!-- 게시판 메인 페이지 영역 끝 -->
	
	<!-- footer 따로 불러옴 -->
	<div id="Footer">
       <jsp:include page="Footer.jsp" />
    </div>
   
   















