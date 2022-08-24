<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <title>COOKK 커뮤니티 관리자레시피 게시판</title>
   	<link rel='stylesheet' href='../css/bootstrap.css' />
   	
   <link rel='stylesheet' href='../css/style.css' />
   <link rel='stylesheet' href='../css/r1_style.css?ver=1' />
  
   <!-- header영역 따로 불러옴 -->
 	<div id="Header">
        <jsp:include page="Header.jsp" />
    </div>
    <!--  
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
-->
    <!-- 게시판 메인페이지 영역 시작 -->
	<div class="container con_wrap">
		<div class="con_box">
			<div class="con_title">
				<div>
					<img src="../images/recipe1_icon.png"/>
				</div>
				<h1><b>추천레시피</b></h1>
			</div>
			<!-- 추천레시피 이미지 -->
			 <ul>
                  <li>
                    <c:forEach var="review" items="${reviewList}">
                      <a href="r1BoardDetail.do?board_num=${review.board_num }">
                        <img src="../upload/${review.main_img}"/>
                        <p class=videoTit >
                      	[${review.category}] &nbsp;${review.title}
                        </p>
                      </a>
	                   <%--  review.board_num=><c:out value="${review.board_num}" />
	                    review.cook2=><c:out value="${review.cook2}" /> --%>
	                </c:forEach>
                  </li>
			</ul>
			<!-- 글쓰기 버튼 생성 -->
			<c:if test="${manager_id != null }">
			<span class="btn_write">	
			     <input type="button" onclick="location.href='r1BoardWrite.do'" value="레시피작성">
			</span>
			</c:if>
			<c:if test="${mem_id != null }">
			<span class="btn_write" style="display:none">	
			     <input type="button" onclick="location.href='r1BoardWrite.do'" value="레시피작성">
			</span>
			</c:if>
		<div class="table-responsive con_table">
			<table class="table table-hover" width="100%" 
			cellpadding="0" cellspacing="0" > 
				<thead>
			    	<tr height="30"> 
				      <td width="50">번호</td> 
				      <td width="200">제목</td> 
				      <td width="60">작성자</td>
				      <td width="70">작성일</td> 
				      <td width="20">조 회</td>  
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
			<c:forEach var="article" items="${list}">	
				<tr>
				    <td>${article.board_num}</td>
				    <td><a href="r1BoardDetail.do?board_num=${article.board_num}">[${article.category}]${article.title}</a></td>
				    <td>${article.writer2}</td>
				    <td>${article.postdate}</td>
				    <td>${article.re_view}</td>
				</tr>
			</c:forEach>   
			</table>
			</div> <!-- table-responsive con_table -->
			
			<div class="paging">${pagingHtml}
				
			</div>
			<!-- 검색창 -->
			<div class="row vertical-center-row">
			<div class="text-center col-lg-7 col-lg-offset-3">
			<form id="searchForm" class="navbar-form" role="search" action="r1BoardList.do">
	     		<div class="form-group"><!--view_tab-->
	     		<select name="keyField">
	     			<option value="0">선택</option>
					<option value="title">제목</option>
					<option value="cook1">재료</option>
					<option value="category">카테고리</option>
				</select>
					<input type="text" name="keyWord" class="form-control" placeholder="레시피를 검색해보세요">
					<button class="btn btn-default">검색</button>
	     		</div><!-- form-group -->
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
   

   
   















