create table lecture(
  seq number(4) references member(seq),
  name varchar2(20) not null,
  event_name varchar2(20),
  count number(4),
  validity date
);


-- lecture test 용
insert into lecture values(1025,'이름','수강종목',유효횟수,add_months(sysdate,6));


-- 수강연장신청 
update lecture set event_name='수강종목', count=10;