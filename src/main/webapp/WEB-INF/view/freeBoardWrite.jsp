<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel='stylesheet' href='../css/style.css' />
    <link rel='stylesheet' href='../css/fb_style2.css' />
   <title>freeBoardWrite</title>
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
					<h1><b>자유게시판 글쓰기</b></h1>
				</div>
			</div><!-- con_title -->
			<div class="row vertical-center-row">
				<div class="col-lg-6 col-lg-offset-3">
				<spring:hasBindErrors name="FreeBoardVO" />
                <form:errors path="FreeBoardVO" />
				<form method="post" action="freeBoardWrite.do" enctype="multipart/form-data"> 
				       <input type="hidden" name="mem_id"  value="${sessionScope.mem_id}" />
				       <input type="hidden" name="writer"  value="${findOne.writer}" />
						<div class="form-group">
						<input type="text" name="f_title"  id="f_title" 
									  class="form-control" placeholder="제목을 입력해주세요."  value="${FreeBoardVO.f_title}"/>
						</div>		
						<div class="form-group">
							<select name="f_category" class="form-control" id="f_category"  value="${FreeBoardVO.f_category}">
								<option value="0">카테고리 선택</option>
								<option value="소통">소통</option>
								<option value="인사">인사</option>
								<option value="요리">요리</option>
								<option value="기타">기타</option>
							</select>
						</div>
						
						
						
						<div class="form-group">
				            <input type="file" class="form-control"  id="upload" name="upload">
				        </div>
						<p>
							<textarea rows="10" class="form-control" placeholder="내용을 입력해주세요" name="f_content">${FreeBoardVO.f_content}</textarea>
						</p>
						
						<!-- 글쓰기 버튼 생성 -->
						<p>
						<span class="btn_write">	
					    	<input type="button" onclick="location.href='freeBoardList.do'" value="목록으로" />
							<input type="submit" class="pull-right" value="글쓰기" />
						</span>
						</p>
					</form>
				</div>
			</div><!-- row -->
	</div><!-- container -->
	<!-- 게시판 글쓰기 양식 영역 끝 -->
					<script>
						$("input[type=submit]").click(function(){
							if($("select[name=f_category]").val() == "0"){
							    alert("카테고리를 입력해주세요");
							    $("#f_category").focus();
							    return false;
							}
						})
						
						
					</script>

	
	<div id="footer">
       <jsp:include page="Footer.jsp" />
    </div>
</body>
</html>