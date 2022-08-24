<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <title>COOKK 커뮤니티 관리자레시피 게시판</title>
	<link rel='stylesheet' href='../css/bootstrap.css' />
   <link rel='stylesheet' href='../css/style.css' />
   <link rel='stylesheet' href='../css/r1_style.css' />
  
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
    crossorigin="anonymous"></script>
  <script type="text/javascript" src="//wcs.naver.net/wcslog.js"></script>
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
	<script>
    function test(){
    	console.log('삭제버튼 클릭')
		if(confirm("삭제하시겠습니까?")){
			location.href="r1BoardDelete.do?board_num="+${command.board_num}
		}
    }
</script>

</head>
<body>
 <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="js/bootstrap.min.js"></script>

<!-- header영역 따로 불러옴 -->
 	<div id="Header">
        <jsp:include page="Header.jsp" />
    </div>

   <!-- 게시판 글쓰기 양식 영역 시작 -->
	<div class="container">
			<div class="con_title">
				<div>
					<img src="../images/recipe1_icon.png"/>
					<h1><b>레시피 수정하기</b></h1>
				</div>
			</div><!-- con_title -->
			<div class="row vertical-center-row">
				<div class="col-lg-6 col-lg-offset-3">
				<spring:hasBindErrors name="command" />
                <form:errors path="command" />
				<form id="form" method="post" action="r1BoardUpdate.do"  enctype="multipart/form-data" name="r1">
					<input type="hidden" name="board_num"  value="${command.board_num}" />
					<input type="hidden" name="mem_id"  value="${command.mem_id}" />
					<input type="hidden" name="manager_id"  value="${command.manager_id}" />
					<input type="hidden" name="writer2"  value="${command.writer2}" />
					<!-- <input type="text" name="heart"  value="1" readonly="readonly" /> -->
					<div class="form-group">
						<input type="text" class="form-control" placeholder="제목(요리이름)을 입력해주세요." 
								name="title" id="title" value="${command.title} "/>
					</div>
						<div class="form-group">
							<select name="category" class="form-control" id="category">
								<option value="0">카테고리선택</option>
			 					<option value="메인요리">메인요리</option>
			 					<option value="밑반찬">밑반찬</option>
			 					<option value="간단요리">간단요리</option>
			 					<option value="안주">안주</option>
			 					<option value="베이킹">베이킹</option>
			 					<option value="다이어트">다이어트</option>
							</select>
							<script>
								document.r1.category.value="${command.category}"
							</script>
						</div>
						<div class="form-group">
				            <input type="file" class="form-control"  id="upload" name="upload">
				            <!--이미 업로드된 파일이 있는 경우에만 수행  -->
							<c:if test="${!empty command.main_img }">
											(${command.main_img }) 파일이 등록되어있습니다.<br>
							</c:if>
				        </div>
						<p>
							<textarea rows="5" class="form-control" name="cook1">${command.cook1}</textarea>
						</p>
						<p>
							<textarea rows="10" class="form-control" name="cook2">${command.cook2}</textarea>
						</p>
						
						<!-- 글쓰기 버튼 생성 -->
						<p style="text-align:center; margin-top:30px">
						<span class="btn_write" >	
					    	<input type="button" onclick="location.href='r1BoardList.do'" value="목록으로" />
					    	<input type="button" value="삭제하기"   onclick="test()" />
					    	<input type="submit" id="form" value="등록하기" />
						</span>
						</p>
					</form>
				</div>
			</div><!-- row -->
	</div><!-- container -->
	<!-- 게시판 글쓰기 양식 영역 끝 -->
</form>

	<!-- footer 따로 불러옴 -->
	<div id="Footer">
       <jsp:include page="Footer.jsp" />
    </div>
</body>
</html>