CREATE SEQUENCE SEQ_member
START WITH 1000
INCREMENT BY 1; 



drop table client;

create table CLIENT(
    cno number(10),
    NAME VARCHAR2(20),
    GENDER number(2),
    ADDRESS VARCHAR(40),
    PHONE   VARCHAR(20),
    division number(2),
    created_date date,
    birth_date date,
    event_name varchar2(40),
    start_date date,
    end_date date
);

insert into client values(seq_member.nextval, 'test', 1, 'test123', '010000000', 1, sysdate, sysdate, 'Çï½º', sysdate,add_months(sysdate, 1));

select * from client;

desc client;