create table lecture(
  seq number(4) references member(seq),
  name varchar2(20) not null,
  event_name varchar2(20),
  count number(4),
  validity date
);


-- lecture test ��
insert into lecture values(1025,'�̸�','��������',��ȿȽ��,add_months(sysdate,6));


-- ���������û 
update lecture set event_name='��������', count=10;