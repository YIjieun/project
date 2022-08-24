<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		
	<title>Mypage</title>
	
	<link rel='stylesheet' href='../css/bootstrap.css' />
	<link rel='stylesheet' href='../css/mypage2.css' />
	<link rel='stylesheet' href='../css/leftmenu.css' /><!-- EditPlus에서 열기! 렉걸림 -->
		
	<link rel='stylesheet' href='../css/normalize.css' />
	<link rel='stylesheet' href='../css/style.css' />
	<link rel="stylesheet" href="../css/swiper.min.css">
	<link rel="stylesheet" href="../css/swiper.css">
	<link rel="stylesheet" href="../css/all.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.js"
					integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
					crossorigin="anonymous"></script>
	<script type="text/javascript" src="//wcs.naver.net/wcslog.js"></script>
	<script src="../js/all.min.js"></script>
</head>
<body>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="js/bootstrap.min.js"></script>



   <!-- header영역 따로 불러옴 -->
 	<div id="Header">
        <jsp:include page="Header.jsp" />
    </div>
	
	<div class="container con_wrap">
		<div class="con_box">
			<div class="con_title">
				<div>
					<img src="../images/mypage.png" />
				</div>
				<h1>
					<b>마이페이지</b>
				</h1>
			</div>
			<section class="slice-sm sct-color-1">
			<div class="profile">
				<div class="container">
					<div class="row cols-xs-space cols-sm-space cols-md-space">
						<div class="col-lg-3">
							<div
								class="sidebar sidebar-inverse bg-base-1 sidebar--style-2 no-border stickyfill">
								<div class="widget">
									<!-- Profile picture -->
									<div class="profile-picture profile-picture--style-2">
										<img src="../images/mypage1.png" class="img-center"
											style="width: 100px;"> <a href="#" class="btn-aux">
												<i class="fa-solid fa-pen"></i>
										</a>
									</div>
									<!-- Profile details -->
									<div class="profile-details mb-4">
										<h2 class="heading heading-6 strong-600 profile-name ">사용자 이름</h2>
									</div>
									<hr>
										<ul class="categories categories--style-3 mt-3">
											<li><a href="eventList.do"> <i class="fa-solid fa-clipboard"></i>
													<span class="category-name">작성한 게시글 </span>
											</a></li>
											<li><a href="r1BoardList.do" class="active"> <i
													class="fa-solid fa-reply fa-rotate-180"></i> <span
													class="category-name"> 작성한 댓글 </span>
											</a></li>
											<li><a href="freeBoardList.do"> <i class="fa-solid fa-heart"></i> <span
													class="category-name">좋아요 게시글 </span>
											</a></li><!--  findMemberView.do (MyUpdate.od대신에) findMemberView.do?mem_id=nup-->
											<li><a href="findMemberView.do?mem_id=${mem_id}"><i class="fa-solid fa-gear "></i> <span
													class="category-name"> 회원수정 </span>
											</a></li>
										</ul>
								</div>
							</div>
						</div>
						
						<div class="col-lg-9">
							<div class="main-content">
								<!-- Page title -->
								<div class="page-title">
									<div class="row align-items-center">
										<div class="col-lg-6 col-12">
											<h1
												class="heading heading-2.5  strong-700 mb-0 margin-top:10px">
												내가 작성한 게시글</h1>
										</div>
									</div>
								</div>

								<hr>

									<!-- Notifications -->
									<div class="row">
										<div class="col-lg-12">
											<div class="card no-border bg-transparent">
												<div>
													<!-- class="card-body px-0"넣고 안넣고 차이있음 -->
													<div class="table-responsive con_table">
														<table class="table table-hover" width="800"
															cellpadding="0" cellspacing="0">
															<thead>
																<tr>
																	<td>no board_num</td>
																	<td>글제목 title</td>
																	<td>등록일 postdate</td>
																	<td>조회수 re_view</td>
																</tr>
															</thead>
															<tr>
																<td>10</td>
																<td>게시판의 글제목</td>
																<td>22-2-24</td>
																<td>7</td>
															</tr>
															<tr>
																<td>9</td>
																<td>게시판의 글제목</td>
																<td>22-2-24</td>
																<td>5</td>

															</tr>
															<tr>
																<td>8</td>
																<td>게시판의 글제목</td>
																<td>22-2-23</td>
																<td>1</td>
															</tr>
															<tr>
																<td>7</td>
																<td>게시판의 글제목</td>
																<td>22-2-22</td>
																<td>21</td>
															</tr>
															<tr>
																<td>6</td>
																<td>게시판의 글제목</td>
																<td>22-2-22</td>
																<td>20</td>
															</tr>
															<tr>
																<td>5</td>
																<td>게시판의 글제목</td>
																<td>22-2-21</td>
																<td>6</td>
															</tr>
															<tr>
																<td>4</td>
																<td>게시판의 글제목</td>
																<td>22-2-21</td>
																<td>10</td>
															</tr>
															<tr>
																<td>3</td>
																<td>게시판의 글제목</td>
																<td>22-2-20</td>
																<td>11</td>
															</tr>
															<tr>
																<td>2</td>
																<td>게시판의 글제목</td>
																<td>22-2-20</td>
																<td>10</td>
															</tr>
															<tr>
																<td>1</td>
																<td>게시판의 글제목</td>
																<td>22-2-20</td>
																<td>9</td>
															</tr>
														</table>
													</div>
													<!-- table-responsive con_table -->

													<div class="paging">
														<ul class="pagination pagination-xs">
															<li><a href="#"> << </a></li>
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
															<li><a href="#"> >> </a></li>
														</ul>
													</div>
												</div>
											</div>
										</div>
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
	</div>
	<!-- conbox -->
	</div>
	<!-- container -->

	<!-- footer 따로 불러옴 -->
	<div id="Footer">
       <jsp:include page="Footer.jsp" />
    </div>
	<!-- wrap -->
</body>
</html>