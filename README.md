# project
/*
 테이블을 생성하고, sql 구문으로 데이터를 1개씩 추가한 후에 웹상에서 데이터 추가 가능.
 sql 구문으로 첫 데이터 추가시 , 각 게시판 폴더 안에 sql_insert구문 참조. 
*/



```c
/* 회원 */
CREATE TABLE member (
	mem_id VARCHAR2(20) NOT NULL, /* 회원ID */
	writer VARCHAR2(50) NOT NULL, /* 닉네임 */
	passwd VARCHAR2(20) NOT NULL, /* 암호 */
	name VARCHAR2(50) NOT NULL, /* 이름 */
	phone VARCHAR2(20) NOT NULL, /* 휴대폰번호 */
	grade VARCHAR2(20), NULL, /* 등급 */
	mem_date DATE(7) NOT NULL /* 가입날짜 */
);

CREATE UNIQUE INDEX PK_member
	ON member (
		mem_id ASC
	);

ALTER TABLE member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			mem_id
		);

/* 회원상세 */
CREATE TABLE memberDetail (
	mem_id VARCHAR2(20) NOT NULL, /* 회원ID */
	writer VARCHAR2(50) NOT NULL, /* 닉네임 */
	passwd VARCHAR2(20) NOT NULL, /* 암호 */
	grade VARCHAR2(20) NULL /* 등급 */
);

CREATE UNIQUE INDEX PK_memberDetail
	ON memberDetail (
		mem_id ASC
	);

ALTER TABLE memberDetail
	ADD
		CONSTRAINT PK_memberDetail
		PRIMARY KEY (
			mem_id
		);

/* 관리자 */
CREATE TABLE manager (
	manager_id VARCHAR2(20) NOT NULL, /* 관리자ID */
	passwd2 VARCHAR2(20) NOT NULL, /* 암호 */
	writer2 VARCHAR2(15) NOT NULL /* 닉네임 */
);

CREATE UNIQUE INDEX PK_manager
	ON manager (
		manager_id ASC
	);

ALTER TABLE manager
	ADD
		CONSTRAINT PK_manager
		PRIMARY KEY (
			manager_id
		);

/* 레시피 게시글 */
CREATE TABLE re_board (
   board_num number(20) NOT NULL, /* 게시글 번호 */
   manager_id VARCHAR2(20) NOT NULL, /* 관리자ID */
   mem_id VARCHAR2(20) NOT NULL, /* 회원ID */
   title VARCHAR2(50) NOT NULL, /* 글제목 */
   writer2 VARCHAR2(50) NOT NULL, /* 닉네임 */
   category VARCHAR2(50) NOT NULL, /* 카테고리 */
   main_img VARCHAR2(50) NOT NULL, /* 대표 이미지 */
   cook1 VARCHAR2(100) NOT NULL, /* 재료 */
   cook2 VARCHAR2(4000) NOT NULL, /* 내용 */
   re_view number(20) NOT NULL, /* 조회수 */
   postdate DATE NOT NULL /* 수정일자 */
);

CREATE UNIQUE INDEX PK_re_board
   ON re_board (
      board_num ASC,
      manager_id ASC,
      mem_id ASC
   );

ALTER TABLE re_board
   ADD
      CONSTRAINT PK_re_board
      PRIMARY KEY (
         board_num,
         manager_id,
         mem_id   
      );

/* 자유게시판 댓글 */
CREATE TABLE free_reply (
	r_num number(20) NOT NULL, /* 댓글번호 */
	board_num number(20) NOT NULL, /* 게시글 번호 */
	mem_id VARCHAR2(20) NOT NULL, /* 회원ID */
	writer VARCHAR2(100) NOT NULL, /* 닉네임 */
	ref number(10) NOT NULL, /* ref */
	re_step number(10) NOT NULL, /* re_step */
	re_level number(10) NOT NULL, /* re_level */
	r_content VARCHAR2(100) NOT NULL, /* 댓글 내용 */
	r_write_date DATE(7) NOT NULL /* 댓글 작성 날짜 */
);

CREATE UNIQUE INDEX PK_free_reply
	ON free_reply (
		r_num ASC,
		board_num ASC,
		mem_id ASC
	);

ALTER TABLE free_reply
	ADD
		CONSTRAINT PK_free_reply
		PRIMARY KEY (
			r_num,
			board_num,
			mem_id
		);

/* 마이페이지 */
CREATE TABLE myPage (
	mem_id VARCHAR2(20) NOT NULL, /* 회원ID */
	writer VARCHAR2(20) NOT NULL, /* 닉네임 */
	m_img VARCHAR2(50) NOT NULL, /* 이미지 */
	grade VARCHAR2(20) NOT NULL /* 등급 */
);

CREATE UNIQUE INDEX PK_myPage
	ON myPage (
		mem_id ASC
	);

ALTER TABLE myPage
	ADD
		CONSTRAINT PK_myPage
		PRIMARY KEY (
			mem_id
		);

/* 자유게시판 */
CREATE TABLE free_board (
	board_num number(20) NOT NULL, /* 게시글 번호 */
	mem_id VARCHAR2(20) NOT NULL, /* 회원ID */
	writer VARCHAR2(50) NOT NULL, /* 닉네임 */
	f_title VARCHAR2(100) NOT NULL, /* 글 제목 */
	f_category VARCHAR2(100) NOT NULL, /* 카테고리 */
	f_content VARCHAR2(500) NOT NULL, /* 글 내용 */
	postdate DATE(7) NOT NULL, /* 등록일 */
	f_img varchar2(50), /* 대표이미지 */
	f_view number(20) /* 조회 */
);

CREATE UNIQUE INDEX PK_free_board
	ON free_board (
		board_num ASC,
		mem_id ASC
	);

ALTER TABLE free_board
	ADD
		CONSTRAINT PK_free_board
		PRIMARY KEY (
			board_num,
			mem_id
		);

/* 이벤트 */
CREATE TABLE event (
	event_code number(20) NOT NULL, /* 이벤트 코드 */
	manager_id VARCHAR2(20) NOT NULL, /* 관리자ID */
	e_title VARCHAR2(100) NOT NULL, /* 이벤트명 */
	e_content VARCHAR2(4000) NOT NULL, /* 내용 */
	e_write_date DATE NOT NOT NULL, /* 작성날짜 */
	event_date DATE NOT NOT NULL, /* 이벤트 기간 */
	event_yn VARCHAR(5) NOT NULL, /* 이벤트 진행 여부 */
	event_image VARCHAR2(100) NULL/* 이미지 */
);

CREATE UNIQUE INDEX PK_event
	ON event (
		event_code ASC,
		manager_id ASC
	);

ALTER TABLE event
	ADD
		CONSTRAINT PK_event
		PRIMARY KEY (
			event_code,
			manager_id
		);

/* 레시피 게시글2 */
CREATE TABLE re_board2 (
	board_num number(20) NOT NULL, /* 게시글 번호 */
	mem_id VARCHAR2(20) NOT NULL, /* 회원ID */
	title VARCHAR2(50) NOT NULL, /* 글제목 */
	writer VARCHAR2(50) NOT NULL, /* 닉네임 */
	category VARCHAR2(50) NOT NULL, /* 카테고리 */
	main_img VARCHAR2(50) NOT NULL, /* 대표 이미지 */
	cook1 VARCHAR2(100) NOT NULL, /* 재료 */
	cook2 VARCHAR2(4000) NOT NULL, /* 내용 */
	re_view number(20) NOT NULL, /* 조회수 */
	postdate DATE(7) NOT NULL, /* 등록일 */
	heart number(10) NULL /* 좋아요 */
);

CREATE UNIQUE INDEX PK_re_board2
	ON re_board2 (
		board_num ASC,
		mem_id ASC
	);

ALTER TABLE re_board2
	ADD
		CONSTRAINT PK_re_board2
		PRIMARY KEY (
			board_num,
			mem_id
		);

/* 회원게시판_댓글 */
CREATE TABLE r2_reply (
	r_num number(20) NOT NULL, /* 댓글번호 */
	board_num number(20) NOT NULL, /* 게시글 번호 */
	mem_id VARCHAR2(20) NOT NULL, /* 회원ID */
	writer VARCHAR2(100) NOT NULL, /* 닉네임 */
	ref number(10) NOT NULL, /* ref */
	re_step number(10) NOT NULL, /* re_step */
	r_content VARCHAR2(100) NOT NULL, /* 댓글 내용 */
	r_write_date DATE(7) NOT NULL, /* 댓글 작성 날짜 */
	re_level number(10) NOT NULL /* re_level*/
);

CREATE UNIQUE INDEX r2_reply
	ON r2_reply (
		r_num ASC,
		board_num ASC,
		mem_id ASC
	);

ALTER TABLE r2_reply
	ADD
		CONSTRAINT ㄱ2_reply
		PRIMARY KEY (
			r_num,
			board_num,
			mem_id
		);

ALTER TABLE memberDetail
	ADD
		CONSTRAINT FK_member_TO_memberDetail
		FOREIGN KEY (
			mem_id
		)
		REFERENCES member (
			mem_id
		);

ALTER TABLE re_board
	ADD
		CONSTRAINT FK_manager_TO_re_board
		FOREIGN KEY (
			manager_id
		)
		REFERENCES manager (
			manager_id
		);

ALTER TABLE free_reply
	ADD
		CONSTRAINT FK_free_board_TO_free_reply
		FOREIGN KEY (
			board_num,
			mem_id
		)
		REFERENCES free_board (
			board_num,
			mem_id
		);

ALTER TABLE free_reply
	ADD
		CONSTRAINT FK_memberDetail_TO_free_reply
		FOREIGN KEY (
			mem_id
		)
		REFERENCES memberDetail (
			mem_id
		);

ALTER TABLE myPage
	ADD
		CONSTRAINT FK_member_TO_myPage
		FOREIGN KEY (
			mem_id
		)
		REFERENCES member (
			mem_id
		);

ALTER TABLE free_board
	ADD
		CONSTRAINT FK_memberDetail_TO_free_board
		FOREIGN KEY (
			mem_id
		)
		REFERENCES memberDetail (
			mem_id
		);

ALTER TABLE event
	ADD
		CONSTRAINT FK_manager_TO_event
		FOREIGN KEY (
			manager_id
		)
		REFERENCES manager (
			manager_id
		);

ALTER TABLE re_board2
	ADD
		CONSTRAINT FK_memberDetail_TO_re_board2
		FOREIGN KEY (
			mem_id
		)
		REFERENCES memberDetail (
			mem_id
		);

ALTER TABLE r2_reply
	ADD
		CONSTRAINT FK_re_board2_TO_r2_reply
		FOREIGN KEY (
			board_num,
			mem_id
		)
		REFERENCES re_board2 (
			board_num,
			mem_id
		);

ALTER TABLE r2_reply
	ADD
		CONSTRAINT FK_memberDetail_TO_r2_reply
		FOREIGN KEY (
			mem_id
		)
		REFERENCES memberDetail (
			mem_id
		);
```
