
-- 전체회원 출력(관리자 제외)
select cno, name, gender, phone, TO_CHAR(birth_date, 'MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr from member where division =1;

-- 회원 검색하기
select cno, name, gender, phone, TO_CHAR(birth_date, 'MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr from member where cno = 1004;

-- 회원 수정

-- 회원 삭제

-- 강의 수정

-- 강의 삭제