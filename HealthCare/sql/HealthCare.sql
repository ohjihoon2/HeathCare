

drop table MEMBER;


CREATE SEQUENCE SEQ_member
START WITH 1000
INCREMENT BY 1; 

create table MEMBER(
    cno number(10)
       CONSTRAINT PK_CLIENT_CNO PRIMARY KEY,
    NAME VARCHAR2(20)
       CONSTRAINT NN_CLIENT_NAME NOT NULL,
    GENDER varchar2(1) 
       CONSTRAINT CK_CLIENT_GENDER CHECK(GENDER IN('M','F')),
    ADDRESS VARCHAR(40)
       CONSTRAINT NN_CLIENT_ADDRESS NOT NULL,
    PHONE   VARCHAR(20)
       CONSTRAINT NN_CLIENT_PHONE NOT NULL,
    division number(2),
    created_date date,
    birth_date date,
    event_name varchar2(40),
    start_date date,
    end_date date
);

-- ȸ������ �ϱ�
insert into MEMBER values(seq_member.nextval, 'test', UPPER('f'), 'test123', '010000000', 1, sysdate, sysdate, '�ｺ', sysdate,add_months(sysdate, 1));

select * from MEMBER;
desc client;

-- �α��� �ϱ�
select * from MEMBER where cno = 1021;
select count(*) from MEMBER where cno=1021;
commit;