

drop table MEMBER;


CREATE SEQUENCE SEQ_member
START WITH 1000
INCREMENT BY 1; 

CREATE TABLE MEMBER  (
   CNO NUMBER(10)  CONSTRAINT PK_CLIENT_CNO PRIMARY KEY, 
   NAME VARCHAR2(20) CONSTRAINT NN_CLIENT_NAME NOT NULL, 
   GENDER VARCHAR2(1) CONSTRAINT CK_CLIENT_GENDER CHECK(GENDER IN('M','F')), 
   ADDRESS VARCHAR2(40) CONSTRAINT NN_CLIENT_ADDRESS NOT NULL, 
   PHONE VARCHAR2(20) CONSTRAINT NN_CLIENT_PHONE NOT NULL, 
   DIVISION NUMBER(2), 
   CREATED_DATE DATE, 
   BIRTH_DATE DATE, 
   START_DATE DATE, 
   END_DATE DATE, 
   GX_CODE VARCHAR2(3), 
   GX_PRICE NUMBER(6), 
   GX_COUNT NUMBER(4) 
   GX_VALIDITY DATE,
   BMI VARCHAR2(10), 
   FAT VARCHAR2(10), 
   PBF VARCHAR2(10), 
   WHR VARCHAR2(10)
);


-- 회원가입 하기
insert into MEMBER values(seq_member.nextval, 'test', UPPER('f'), 'test123', '010000000', 1, sysdate, sysdate, '헬스', sysdate,add_months(sysdate, 1));

select * from MEMBER;
desc client;

-- 로그인 하기
select * from MEMBER where cno = 1021;
select count(*) from MEMBER where cno=1021;
commit;