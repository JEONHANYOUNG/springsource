create table spring_board(
	bno number(10,0), 						-- 글번호
	title varchar2(200) not null,   		-- 제목
	content varchar2(2000) not null,  		-- 내용
	writer varchar2(50) not null,			-- 작성자
	regdate date default sysdate, 			-- 작성날짜
	updatedate date default sysdate			-- 수정날짜
);

alter table spring_board add constraint pk_spring_board primary key(bno);

create sequence seq_board;

select * from spring_board;

-- 페이지 나누기
-- rownum(가상 행번호 부여)
select rownum, bno, title from spring_board;

-- 더미 데이터 삽입
insert into spring_board(bno,title,content,writer)
(select seq_board.nextval,title,content,writer from SPRING_BOARD);

select count(*) from spring_board;


-- rownum 부여 시 주의할 점 => order by 절과 같이 올 때(order by 구문에 index 값이 쓰이지 않는 경우)
-- ex) order by re_ref desc, re_lev asc;
-- ex) index(pk 만들면 index로 생성됨)

-- 서브쿼리 이용하기
select rownum, bno, title
from (select bno,title from SPRING_BOARD where bno>0 order by bno desc)
where rownum <=10;

-- 오라클 힌트(동일한 작업 처리 가능)
select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum,bno,title
from spring_board
where rownum <=10;


-- 1 : 최신글 10개 가지고 나오기
select rn,bno,title
from (select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum rn,bno,title
	  from spring_board
      where rownum <=10)
where rn>0;

-- 2 : 그 다음 최신글 10개 가지고  나오기
select rn,bno,title
from (select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum rn,bno,title
	  from spring_board
      where rownum <=20)
where rn>10;


-- 첨부파일 테이블
create table spring_attach(
	uuid varchar2(100) not null,
	uploadPath varchar2(100) not null,
	fileName varchar2(100) not null,
	fileType char(1) default 'I',
	bno number(10,0)
);

alter table spring_attach add constraint pk_attach primary key(uuid);
alter table spring_attach add constraint fk_board_attach foreign key(bno)
references spring_board(bno);

select * from spring_attach;
















