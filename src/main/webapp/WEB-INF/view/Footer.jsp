<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>footer</title>
    
	<link rel='stylesheet' href='../css/normalize.css' />
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel='stylesheet' href='../css/style.css' />
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    
  </head>
<body>
    
    <div id="footer">
     <div class="container" style="padding-bottom:50px">
    <div class="footerBox" style="margin: 50px auto">
        <div class="footerLeft">
            <span class="ck">Cookk</span>
            <ul class="ftmenu1">
            <p class="footerTxt">
                쿸 <br />
                사업장: 서울특별시 강남구 역삼동 819-10 세경빌딩 3층<br />
                고객센터: cookk@cookk.com<br />
                연락처: 070-123-4567<br /><br />
                Copyright ⓒ 4조 All rights Reserved
            </p>
            <p class="m_footerTxt">
                쿸 <br />
                사업장: 서울특별시 강남구 역삼동 819-10 세경빌딩 3층<br />
                고객센터: cookk@cookk.com<br />
                연락처: 070-123-4567<br /><br />
                Copyright ⓒ 4조 All rights Reserved
            </p>
            
            </ul>
            <ul class="ftmenu2">
                <li><a href="/terms" target="_blank">이용약관</a></li>
                <li><a href="/privacy" target="_blank">개인정보취급방침</a></li>
                <li><a href="https://www.ftc.go.kr/www/bizCommView.do?key=232&apv_perm_no=2020409035430201403&pageUnit=10&searchCnd=wrkr_no&searchKrwd=4082821450&pageIndex=1"
                        target="_blank">사업자정보확인</a></li>
                <li><a href="/pdfs/cookmin_rule.pdf" target="_blank">쿸 규정</a></li>
                <li><a href="/pdfs/cookmin_guide.pdf" target="_blank">쿸 가이드라인</a></li>
            </ul>
        </div>
        <div class="footerRight">
        	<div class="ftR" style="width:50%">
        		<ul>
        			<li><a href="#"><img src="../images/insta.png" alt="인스타그램"/></a></li>
        			<li><a href="#"><img src="../images/facebook.png" alt="페이스북"/></a></li>
        			<li><a href="#"><img src="../images/twt.png" alt="트위터"/></a></li>
        			<li><a href="#"><img src="../images/youtube.png" alt="유튜브"/></a></li>
        		</ul>
        	</div>

        </div> 
    </div>
</div>
<div class="m_footer_menu">
    <ul>
        <li><a href="/"><img class="icon" src="../images/home.svg" /><span>홈</span></a></li>
        <li><a href="/rsearch"><img class="icon" src="../images/loupe.svg" /><span>요리검색</span></a></li>
        <li><a href="/mypage"><img class="icon" src="../images/user.svg" /><span>마이페이지</span></a></li>
    </ul>
</div>
<script>
    $(document).ready(function () {
        var path = window.location.pathname;
        if (path === "/") {
            $(".m_footer_menu ul li:nth-child(1) a span").css("color", "#e86416");
        } else if (path === "/rsearch") {
            $(".m_footer_menu ul li:nth-child(2) a span").css("color", "#e86416");
        } else if (path === "/mypage") {
            $(".m_footer_menu ul li:nth-child(3) a span").css("color", "#e86416");
        }
    });
    </script>
    
    </div><!-- wrap -->
</body>
</html>