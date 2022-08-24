<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
    
    <script>
    function test(){
       console.log('삭제버튼 클릭')
      if(confirm("삭제하시겠습니까?")){
         location.href="freeBoardDelete.do?board_num="+${vo.board_num}
      }
    }
    
    
</script>
</head>
<body>


 <div id="header">
        <jsp:include page="Header.jsp" />
    </div>
    
    
	<!-- 게시판 글쓰기 양식 영역 시작 -->
	<div class="container">
			<div class="con_title">
				<div>
					<img src="../images/freeboard.png"/>
					<h1><b>자유게시판 글수정</b></h1>
				</div>
			</div><!-- con_title -->
			<div class="row vertical-center-row">
				<div class="col-lg-6 col-lg-offset-3">
				<spring:hasBindErrors name="FreeBoardVO" />
                <form:errors path="FreeBoardVO" />
                
				<form method="post" action="freeBoardUpdate.do" enctype="multipart/form-data" name="freeUpdate">
				       <input type="hidden" name="board_num"  value="${vo.board_num}" /> 
				       <input type="hidden" name="mem_id"  value="${vo.mem_id}" />
				       <input type="hidden" name="writer"  value="${vo.writer}" />
						<div class="form-group">
						<input type="text" name="f_title"  id="f_title" 
									  class="form-control" value="${vo.f_title}"/>
						</div>		
						<div class="form-group">
							<select name="f_category" class="form-control" id="f_category">
								<option value="0">카테고리 선택</option>
								<option value="소통">소통</option>
								<option value="인사">인사</option>
								<option value="요리">요리</option>
								<option value="기타">기타</option>
							</select>
							<script>
				  	        document.freeUpdate.f_category.value="${vo.f_category}"
				            </script>
						</div>
						<div class="form-group">
				            <input type="file" class="form-control"  id="upload" name="upload">
				            <!--전에 이미 업로드된 파일이 있는 경우에만 수행  -->
							<c:if test="${!empty vo.f_img }">
									(${vo.f_img}) 파일이 등록되어있습니다.<br>
							</c:if>
				        </div>
						<p>
							<textarea rows="10" class="form-control" name="f_content">${vo.f_content}</textarea>
						</p>
						
						<!-- 글쓰기 버튼 생성 -->
						<p style="text-align:center; margin-top:30px">
						<span class="btn_write" >	
					    	<input type="button" onclick="location.href='freeBoardList.do'" value="목록으로" />
					    	<input type="button" value="삭제" onclick="test()">
							<input type="submit" value="글수정" />
						</span>
						</p>
					</form>
				</div>
			</div><!-- row -->
	</div><!-- container -->
	<!-- 게시판 글쓰기 양식 영역 끝 -->

	
	<div id="footer">
       <jsp:include page="Footer.jsp" />
    </div>
</body>
</html>