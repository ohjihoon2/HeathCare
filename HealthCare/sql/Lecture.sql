create table lecture(
  gx_code varchar(3),
  gx_name varchar2(20),
  gx_price number(6)
);


-- lecture test ��
insert into lecture values(101,'�䰡',10000,��ȿȽ��);


-- ���������û 
update lecture set gx_code=101, gx_name='�䰡', gx_price=10000;


--PERSONAL GXINFO TABLE
CREATE TABLE GXINFO(
  GXNO NUMBER(5) CONSTRAINT INFO_GXNO_PK PRIMARY KEY,
  CNO NUMBER(10) CONSTRAINT INFO_CNO_FK REFERENCES MEMBER(CNO),
  GX_CODE VARCHAR2(3) CONSTRAINT INFO_GXCODE_FK REFERENCES LECTURE(GX_CODE),
  GX_COUNT NUMBER(3),
  GX_VALIDITY DATE
);

CREATE SEQUENCE SEQU_GXINFO_GXNO
  START WITH 200
  INCREMENT BY 1 ;
  
  