/*
  SQL 정리 
*/

-- 사용가능한 테이블 확인
SELECT * FROM SYS.USER_TABLES;
SELECT * FROM tab;

-- EMP 테이블 구조 확인 : DESC 테이블명;
DESC EMP;
DESC DEPT;

/* SELECT 명령어 - 데이터 조회 */
-- 형식 : SELECT [DISTINCT] *(전체), 컬럼명, 컬럼명에 대한 별칭 FROM 테이블명;

-- EMP 테이블에 있는 모든 데이터 조회
SELECT * FROM EMP;

-- DEPT 테이블에 있는 모든 데이터 조회
SELECT * FROM TAB;
SELECT * FROM DEPT;

-- EMP 테이블의 사원번호(EMPNO)와 사웡명(ENAME)을 조회
SELECT EMPNO, ENAME FROM EMP;

-- DEPT  테이블의 부서번호와 위치를 조회  
DESC DEPT;
SELECT Deptno, LOC FROM dept;
    
-- EMP 테이블의 사원명과 입사일을 조회
DESC EMP;
SELECT ENAME, HIREDATE FROM EMP;

-- EMP 테이블의 사원명과 입사일을 조회한 결과 컬럼명을 사원명, 입사일로 출력
-- 공백이 들어있으면 " " 안으로 집어 넣어준다.
SELECT ENAME "사 원 명", HIREDATE 입사일 FROM EMP;

-- EMP 테이블의 사원 연봉을 출력( 사원번호, 사원명, 급여, 연봉(급여 * 12))

SELECT EMPNO 사원번호, ENAME 사원명, SAL 급여, SAL * 12 연봉 FROM EMP;
SELECT * FROM EMP;

-- EMP 테이블의사원들 사원번호, 사원명, 급여, 보너스(SAL * COMM) 를 조회
SELECT EMPNO 사원번호, ENAME 사원명, SAL 급여, SAL * COMM 보너스 FROM EMP;

-- COMM 컬럼의 NULL 값을 0으로 치환

SELECT COMM, NVL(COMM,0) FROM EMP;
SELECT EMPNO 사원번호, ENAME 사원명, SAL 급여, SAL * NVL(COMM,0) 보너스 FROM EMP;

-- 문자열 결합 : ||(concateration)\
-- 'Smith의 업무는 Manager 입니다.'
SELECT ename || '의 업무는 '|| job || ' 입니다. 'FROM EMP;

-- DISTINCT : 중복된 데이터 배제 출력
-- EMP 테이블의 사원번호, 사원명, 부서번호 조회
SELECT DISTINCT EMPNO, ENAME, DEPTNO  FROM EMP;
-- 키 값이 EMPNO 이기때문에 중복값인 DEPTNO가 제거되지 않음.

-- EMP 테이블의 부서번호 조회
SELECT DEPTNO FROM EMP; --12행
SELECT DISTINCT DEPTNO FROM EMP;  --3행

-- EMP 테이블의 직급(JOB)을 중복되지 않도록 조회
SELECT DISTINCT JOB FROM EMP;

-- 특정 조건의 데이터를 조회하는 방법
-- SELECT ~~~ FROM ~~~ WHERE  조건식(   SAL      =       3000;  )
--                                   1.컬럼 2. 연산자 3. 비교대상값
-- EMP 테이블에서 급여가 3000인 사원을 조회
SELECT * FROM EMP WHERE SAL = 3000;

-- EMP 테이블에서 급여가 1500 보다 많은 사원의 사원번호, 사원명, 부서번호를 조회
SELECT EMPNO 사원번호, ENAME 사원명, DEPTNO 부서번호 , SAL 급여, NVL(COMM,0) 커미션 FROM EMP WHERE SAL >1500;

-- EMP 테이블에서 급여가 1500 보다 적은 사원의 사원번호, 사원명, 부서번호를 조회
SELECT EMPNO 사원번호, ENAME 사원명, DEPTNO 부서번호 , SAL 급여, NVL(COMM,0) 커미션 FROM EMP WHERE SAL <1500;

-- EMP 테이블에서 부서번호가 20번인 사원을 모두 출력
SELECT *FROM EMP WHERE DEPTNO = 20;

-- EMP 테이블의 사원 중 보너스가 100000 이상인 사원을 모두 출력 
-- (보너스는 급여 * 커미션)

SELECT * FROM EMP WHERE SAL * COMM >= 100000;

-- EMP 테이블의 사원 중 보너스가 100000 이상인 사원의 사원번호, 사원명, 급여, 커미션, 보너스 출력
-- (보너스는 급여*커미션, 커미션의 DEFAULT 는 0)
SELECT EMPNO, ENAME, SAL, NVL(COMM, 0) COMM,SAL*COMM BONUS FROM EMP WHERE SAL*NVL(COMM, 0) >= 100000;
-- SELECT EMPNO, ENAME, SAL, NVL(COMM, 0) COMM,SAL*COMM BONUS FROM EMP WHERE BONUS >= 100000;
-- SELECT * FROM 이 진행된 후에 WHERE 절이 진행되는데 BONUS 가 컬럼이면은 되는데 별칭이어서 실행이 되지 않는다.

--문자 데이터를 비교하여 조회 ( 문자열 = ' ' , 대/소문자 구별)
--사원명이 SMITH인 사원의 모든 정보를 출력
  SELECT * FROM EMP WHERE ENAME = 'SMITH';
  
-- 사원명이 JONES 사원의 정보 중 사원번호, 사원명, 부서번호, 입사일, 급여 출력
SELECT EMPNO, ENAME, DEPTNO, HIREDATE, SAL FROM EMP WHERE ENAME = 'JONES';

-- 사원번호가 7566인 사원의 사원명, 직급과 부서번호를 출력
DESC EMP;
SELECT ENAME , JOB, DEPTNO FROM EMP WHERE EMPNO = 7566;

/** 날짜 데이터(YY/MM/DD)를 비교하여 조회 */
-- 1981년 7월 1일 이전에 입사한 사원을 출력

SELECT * FROM EMP WHERE HIREDATE <= '82/07/01';

-- 1981년 3사분기 이후에 입사한 사원을 출력
SELECT * FROM EMP WHERE HIREDATE >= '81/09/01';


/** 논리연산자를 활용한 데이터 조회 (AND, OR, NOT ) */
-- EMP 테이블의 사원 중 부서번호가 10번이고, 직급이 MANAGER인 사원을 출력
SELECT * FROM EMP WHERE DEPTNO = 10 AND JOB ='MANAGER';

-- EMP 테이블의 사원 중 부서번호가 10번이거나 직급이 MANAGER인 사원을 출력
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB ='MANAGER';

-- EMP 테이블의 사원 중 부서번호가 10번이 아니거나 직급이 MANAGER가 아닌 사원을 출력
SELECT * FROM EMP WHERE DEPTNO != 10 OR JOB != 'MANAGER';
SELECT * FROM EMP WHERE DEPTNO <> 10 OR JOB <> 'MANAGER';

-- 1981년 상반기에 입사한 사원들을 모두 출력해 주세요.
SELECT * FROM EMP WHERE HIREDATE > '81/01/01' AND HIREDATE <'81/06/30';

-- BETWEEN ~ AND 연산자
SELECT * FROM EMP WHERE HIREDATE BETWEEN '81/01/01' AND '81/06/30';

-- 2000에서 3000 사이의 급여를 받는 사원들을 조회
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL <= 3000;
SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 3000;

-- 커미션이 300 이거나 500이거나 1400 인 사원을 조회
SELECT * FROM EMP WHERE COMM =300 OR COMM =500 OR COMM = 1400;
-- IN
SELECT * FROM EMP WHERE COMM IN(300,500,1400);

/**
  08-13
*/
-- 사원 번호가 7521이고 직무가 SALESMAN인 사원을 검색하세요. (논리연산자)
SELECT * FROM EMP WHERE EMPNO = 7521 AND JOB= 'SALESMAN';
-- 사원 번호가 7521이고 7654인 사람을 검색(범위)하세요. (BETWEEN AND)
SELECT * FROM EMP WHERE IEMPNO BETWEEN 7521 AND 7654;
-- 사원 번호가 7521이거나, 7654이거나, 7369인 사원을 검색하세요.(논리연산자)
SELECT * FROM EMP WHERE EMPNO = 7521 OR EMPNO = 7654 OR EMPNO =7369;
-- 사원 번호가 7521이거나, 7654이거나, 7369인 사원을 검색하세요.(IN)
SELECT * FROM EMP WHERE EMPNO IN(7521,7654,7369);

-- 사원명이 J 로 시작하는 모든 사원들을 출력 
SELECT * FROM EMP WHERE ENAME LIKE 'J%Y';

-- 사원명이 A 로 시작하는 모든 사원들을 출력 
SELECT * FROM EMP WHERE ENAME LIKE '%A%';

-- 커미션이 NULL인 모든 사원을 출력
SELECT * FROM EMP WHERE COMM IS NULL;

-- 커미션이 NULL이 아닌 모든 사원을 출력
SELECT * FROM EMP WHERE COMM IS NOT NULL;

-- CEO 출력 : MGR 컬럼이 NULL 인 경우
SELECT * FROM EMP WHERE MGR IS NULL;

/**
  데이터 정렬 : ORDER BY (ASC, DESC) 
*/

-- 급여 순으로 사원들을 정렬한 후 출력

-- 오름차순
SELECT * FROM EMP ORDER BY SAL ASC;
SELECT * FROM EMP ORDER BY SAL;

-- 내림차순
SELECT * FROM EMP ORDER BY SAL DESC;

-- 30번 부서 중에서 가장 많은 급여를 받는 순으로 정렬하여 출력
SELECT * FROM EMP WHERE DEPTNO = 30 ORDER BY SAL DESC;

-- 81년 상반기 입사자들 중에 보너스를 많이 받는 순으로 정렬하여 출력
-- 보너스는 급여*커미션 형식으로 하고, 디폴트 값은 0
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM, 0) COMM, DEPTNO, NVL(COMM, 0)*SAL BONUS FROM EMP WHERE HIREDATE BETWEEN '81/01/01' AND '81/06/30' ORDER BY BONUS DESC;

--부서 번호가 빠른 사원부터 출력하되 같은 부서 내의 사원을 출력할 경우 최근에 입사한 사원부터 출력하도록 하되 사원번호, 입사일, 사원 이름, 급여 순으로 출력하시오
SELECT DEPTNO, EMPNO, HIREDATE, ENAME, SAL FROM EMP ORDER BY DEPTNO ASC, HIREDATE DESC;

/**
  SQL 함수
*/

-- DUAL 테이블 구조 확인
DESC DUAL;

SELECT * FROM DUAL;

/** 숫자 데이터 타입에 적용되는 함수 */

-- 절대값 구하기  : ABS() 함수
SELECT -100, ABS(-100) FROM DUAL;

-- 소수점 자르기 : FLOOR 함수
SELECT 34.5678, FLOOR(34.5789)FROM DUAL;

-- 소수점 반올림 : ROUND() 함수
SELECT 34.5678, ROUND(34.5678) FROM DUAL;

-- 특정 자리수 소수점 반올림 : ROUND(대상, 자리수 : 출력) 함수
SELECT 34.5678, ROUND(34.5678, 2) FROM DUAL;
SELECT 34.5678, ROUND(34.5678, -1) FROM DUAL;

-- 특정 자리수 소수점 자르기 : TRUNC(대상, 자리수 : 출력) 함수
SELECT TRUNC(34.5678, 2), TRUNC(34.5678, -1), TRUNC(34.5678) FROM DUAL;

-- 나머지 연산 : MOD
SELECT MOD(27,2), MOD(27,5), MOD(27,7) FROM DUAL;

--4번이 홀수 인 사람들을 검색 : MOD(EMPNO,2) =1, MOD(EMPNO,2) <>0 
SELECT * FROM EMP WHERE MOD(EMPNO, 2) <> 0;

/** 문자 데이터 타입에 적용되는 함수 */

-- 대문자로 치환 : UPPER 함수
SELECT 'Welcome to Oracle', UPPER('Welcome to Oracle') FROM DUAL;

-- 소문자로 치환 : LOWER 함수
SELECT 'Welcome to Oracle', LOWER('Welcome to Oracle') FROM DUAL;

-- 첫글자만 대문자로 치환 : INITCAP 함수
SELECT 'Welcome to Oracle', INITCAP('WELCOME TO ORACLE') FROM DUAL;

-- 문자열 길이 반환 : LENGTH 함수
SELECT LENGTH('ORACLE'), LENGTH('오라클') FROM DUAL;

-- 문자열 길이 반환 : LENGTHB 함수 
SELECT LENGTHB('ORACLE'), LENGTHB('오라클') FROM DUAL;

-- 문자열 추출 : SUBSTR(대상문자열, 시작, 추출갯수) // -는 뒤에서 시작
SELECT SUBSTR ('WELCOME TO ORACLE',4,3) FROM DUAL;
SELECT SUBSTR ('WELCOME TO ORACLE',-4,3) FROM DUAL;

-- EMP 테이블이 사원정보를 입사년도, 월 만 출력
SELECT * FROM EMP;
SELECT SUBSTR(HIREDATE,1,2) Y, SUBSTR(HIREDATE,4,2) M FROM EMP;

-- 9월에 입사한 사원을 출력
SELECT * FROM EMP WHERE SUBSTR(HIREDATE,4,2) = 09;

-- 81년도 입사한 사원을 출력
SELECT * FROM EMP WHERE SUBSTR(HIREDATE,1,2) = 81;

-- 문자 혹은 기호 채우기 : LPAD, RPAD
SELECT LPAD('ORACLE',20,'#') FROM DUAL;
SELECT RPAD('ORACLE',20,'#') FROM DUAL;
SELECT EMPNO, ENAME, RPAD(JOB,9,' '), MGR, HIREDATE, SAL FROM EMP;
select * from emp;

-- 공백 삭제 : LTRIM, RTRIM 
SELECT LTRIM('            ORCLE'), RTRIM('ORACLE    ') FROM DUAL;

-- 특정 문자열 삭제 : TRIM(삭제 문자열 FROM 대상 문자열)
SELECT TRIM('A' FROM 'AAAAORACLEAAA') FROM DUAL;

SELECT TRIM('     ORACLE     ') FROM DUAL;

select * from emp;

desc emp;

/** 날짜 함수 */
-- 현재 날짜를 반환 : SYSDATE *******중요*******
SELECT SYSDATE FROM DUAL;

-- 현재 날짜 기준으로 10일 후의 날짜를 출력
SELECT SYSDATE+10 FROM DUAL;

-- 현재 날짜 기준으로 어제, 오늘, 내일 날짜를 출력 
SELECT SYSDATE-1 어제, SYSDATE 오늘, SYSDATE+1 내일 FROM DUAL;

-- EMP 테이블 사원들의 현재 날짜 기준으로 근무일수를 출력
SELECT EMPNO 사원번호, ENAME 사원명, HIREDATE 입사일, SYSDATE-HIREDATE 근무일수 FROM EMP;
-- EMP 테이블 사원들의 현재 날짜 기준으로 근무일수(소수점2개 까지짜름)를 출력         //FLOOR- 전체 삭제, TRUNC
SELECT EMPNO 사원번호, ENAME 사원명, HIREDATE 입사일, TRUNC(SYSDATE-HIREDATE , 2) 근무일수 FROM EMP;
-- EMP 테이블 사원들의 현재 날짜 기준으로 근무일수(소수점2개 반올림)를 출력
SELECT EMPNO 사원번호, ENAME 사원명, HIREDATE 입사일, ROUND(SYSDATE-HIREDATE , 2) 근무일수 FROM EMP;

-- ROUND 적용 : ROUND(대상날짜, 포맷)
SELECT HIREDATE, ROUND (HIREDATE, 'MONTH')  FROM EMP; 

-- TRUNC 적용 : TRUNC(대상날짜, 포멧)
SELECT HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP;

-- MONTHS_BETWEEN : 날짜 사이의 개월 수 구함
-- 형식 : MONTHS_BETWEEN(날짜1, 날짜2)0

-- 현재 날짜 기준 사원들의 근무개월 구하고, 근무개월 기준 내림차순 정렬
SELECT EMPNO 사원번호, ENAME 사원명, HIREDATE 입사일, FLOOR(MONTHS_BETWEEN(SYSDATE,HIREDATE)) 근무개월, FLOOR(SYSDATE-HIREDATE) 근무일수 FROM EMP ORDER BY 근무개월 DESC;

-- ADD_MONTHS : 개월 수 추가
-- 입사일 기준으로 6개월 후 날짜 출력
SELECT HIREDATE 입사일, ADD_MONTHS(HIREDATE,6) 입사일2 FROM EMP;

-- NEXT_DAY : 요일에 맞는 날짜 반환
-- 현재 날짜 기준으로 다음 토요일의 날짜를 출력
SELECT SYSDATE, NEXT_DAY(SYSDATE, '토요일') FROM DUAL;

-- LAST_DAY : 해당 월의 마지막 날짜 반환
-- 입사월 기준으로 마지막 날짜 출력
SELECT HIREDATE, LAST_DAY(HIREDATE) FROM EMP;


/**
  형번환 함수 : TO_CHAR, TO_DATE, TO_NUMBER
*/
-- TO_CHAR
SELECT SYSDATE, TO_CHAR(SYSDATE,'YYYY-MM-DD, HH24:MI:SS') FROM DUAL;

-- 입사일 출력 포멧을 '년-월-일' 형식으로 변환하여 출력
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY.MM.DD') FROM EMP;
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;

-- TO_CHAR : 숫자 -->문자
-- 급여를 3자리씩 구분하여 출력
SELECT EMPNO,TO_CHAR(SAL, 'L000,000')   SAL, TO_CHAR(SAL, 'L999,999') SAL FROM EMP;
SELECT TO_CHAR(123456, '000,000,000'), TO_CHAR(123456, '999.999.999') FROM EMP;

-- TO_DATE : 문자 --> 날짜
SELECT '2019/01/01', TRUNC(SYSDATE-TO_DATE('2019/01/01','YYYY/MM/DD')) RESULT FROM DUAL;

-- TO_NUMBER : 문자 --> 숫자
SELECT TO_CHAR(TO_NUMBER('20,000','99,999')-TO_NUMBER('10,000','99,999'), '999,999') FROM DUAL;

-- NVL : NULL -->숫자
-- 현재날짜를 기준으로 근무년수를 구한 후 커미션을 곱하여 인센티브를 출력
-- 커미션 디폴트는 100, 급여와 인센티브는 통화기호와 3자리 구분

SELECT EMPNO 사원번호, ENAME 사원명, TO_CHAR(SAL,'L999,999') 급여, TRUNC((SYSDATE-HIREDATE)/365) 근무년수 ,NVL(COMM,100) 커미션, TO_CHAR(TRUNC((SYSDATE-HIREDATE)/365)*NVL(COMM,100), 'L999,999') 인센티브 FROM EMP;

-- DECODE : 조건에 맞는 데이터를 바꿀 수 있음
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING',
                                     20, 'RESEARCH', 
                                     30, 'SALES', 
                                     40, 'OPERATIONS') DNAME
FROM EMP;

-- 직급에 따라 급여를 인상
-- 직급이 'ANALYST'인 사원은 5%, 'SALESMAN'인 사원은 10%,
-- 'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20%인상한다.

SELECT ENAME 사원명, JOB 직급, SAL 현재급여, FLOOR(NVL(DECODE(JOB, 'ANALYST', SAL+(SAL*0.05),
                                    'SALESMAN', SAL+(SAL*0.1),
                                    'MANAGER', SAL+(SAL*0.15),
                                    'CLERK', SAL+(SAL*0.2)),0)) 인상급여
FROM EMP;                                
-- CASE ~WHEN~THEN ~END : 조건에 맞는 데이터 조회(IF~ELSE IF~ELSE)
-- CASE~WHEN~THEN~ELSE~END
-- 부서번호를 이용하여 부서명 출력
SELECT EMPNO, ENAME, DEPTNO,
        CASE WHEN DEPTNO =10 THEN 'ACCOUNTING'
             WHEN DEPTNO =20 THEN 'RESEARCH'
             WHEN DEPTNO =30 THEN 'SALES'
             WHEN DEPTNO =40 THEN 'OPERATIONS'
        END AS DNAME
FROM EMP;

-- 직급에 따라 급여를 인상
-- 직급이 'ANALYST'인 사원은 5%, 'SALESMAN'인 사원은 10%,
-- 'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20%인상한다.
SELECT ENAME 사원명, JOB 직급, SAL 현재급여, 
        CASE WHEN JOB = 'ANALYST' THEN SAL+SAL*0.05
             WHEN JOB = 'SALESMAN' THEN SAL+SAL*0.1
             WHEN JOB = 'MANAGER' THEN SAL+SAL*0.15
             WHEN JOB = 'CLERK' THEN SAL+SAL*0.2
             ELSE 0
        END AS UPSAL
FROM EMP;
-- ROWNUM(ROW의 갯수 - INDEX역할)
SELECT ROWNUM , EMPNO, ENAME, RPAD(JOB,9,' '), MGR, TO_CHAR(HIREDATE, 'YYYY/MM/DD'), SAL, NVL(COMM,0), DEPTNO FROM EMP;

/**
  테이블의 구조 정의, 생성, 수정, 삭제
*/

-- CREATE TABLE : 테이브의 구조 정의 및 생성
-- 형식 : CREATE TABLE 테이블명( 컬럼명 데이터 타입,....); 

-- 데이터형 - VARCHAR2(size) (가변형 문자 데이터)

-- ROWID 출력
SELECT ROWID, EMPNO FROM EMP;

-- CREATE TAWBLE : 테이블의 구조 정의 및 생성
-- 형식 : CREATE TABLE 테이블명(컬럼명 데이터 타입,....);

-- 테이블 생성 : EMP01 테이블 이름으로 EMPNO, ENAME, SAL 칼럼
CREATE TABLE EMP01(
  EMPNO NUMBER(4),
  ENAME VARCHAR2(20),
  SAL NUMBER(7,2)
);

DESC EMP01;
SELECT * FROM USER_TABLES;
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP01';

CREATE TABLE DEPT01(
  DEPTNO NUMBER(2),
  DNAME VARCHAR2(14),
  LOC VARCHAR(13)
);
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'DEPT01';  
DESC DEPT01;


/**
  서브쿼리(SELECT) 를 통한 테이블 생성
*/

-- SELECT 명령을 이용하여 EMP 테이블의 모든 칼럼을 EPM02 테이블로 생성
CREATE TABLE EMP02 
AS
SELECT * FROM EMP;

SELECT * FROM USER_TABLES WHERE TABLE_NAME='EMP02';
DESC EMP02;
SELECT * FROM EMP01;
SELECT * FROM EMP02;

-- EMP 테이블의 사원번호, 사원명 복제하여 EMP03테이블 생성
CREATE TABLE EMP03
AS
SELECT EMPNO, ENAME FROM EMP;

SELECT * FROM USER_TABLES WHERE TABLE_NAME='EMP03';
DESC EMP03;

-- EMP테이블의 사원번호, 사원명, 급여, 연봉 컬럼들을 EMP04 테이블로 복제
CREATE TABLE EMP04
AS
SELECT EMPNO 사원번호, ENAME 사원명, SAL 급여, SAL*12 연봉 FROM EMP;

SELECT * FROM USER_TABLES WHERE TABLE_NAME='EMP04';
SELECT * FROM EMP04;
DESC EMP04;

-- EMP테이블의 사원번호, 사원명, 급여, 연봉, 입사일 컬럼들을 EMP04_1 테이블로 복제
-- EMP04_1 테이블로 복제(급여, 연봉은 통화기호 포함 3자리 구분, 입사일 형식은 YYYY/MM/DD 형식)
CREATE TABLE EMP04_1
AS
SELECT  EMPNO 사원번호, ENAME 사원명, TO_CHAR(SAL, 'L999,999')  급여, TO_CHAR(SAL*12, 'L999,999') 연봉 , TO_CHAR(HIREDATE , 'YYYY/MM/DD') 입사일 
FROM EMP;

SELECT * FROM USER_TABLES WHERE TABLE_NAME='EMP04_1';
SELECT * FROM EMP04_1;

-- EMP 테이블의 30번 부서에 속하는 사원들을 EMP05 테이블로 복제
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP05';

CREATE TABLE EMP05
AS
SELECT * FROM EMP
WHERE DEPTNO=30;

SELECT * FROM EMP05;

-- EMP 테이블의 구조만 복제하여 EMP06 생성 : WHERE 1=0;

-- WHERE 1=1; 전부 복제;
-- WHERE 1=0; WHERE 1=0; 조건은 항상 거짓입니다. 거짓이라 구조만 복제 할 수 있음

SELECT * FROM EMP;
DESC EMP;

CREATE TABLE EMP06
AS
SELECT * FROM EMP
WHERE 1=0;

SELECT * FROM EMP06;

-- DEPT 테이블과 같은 구조로 빈 테이블 DEPT02 생성
CREATE TABLE DEPT02
AS
SELECT * FROM DEPT WHERE 1=0;
SELECT * FROM DEPT02;

CREATE TABLE EMP04_2
AS
SELECT  EMPNO 사원번호, ENAME 사원명, TO_CHAR(SAL, 'L999,999')  급여, TO_CHAR(SAL*12, 'L999,999') 연봉 , TO_CHAR(HIREDATE , 'YYYY/MM/DD') 입사일 
FROM EMP
WHERE 1=0;

SELECT * FROM EMP04_2;


/**
  테이블수정 : ALTER TABLE
  - ADD( 컬럼명 타입, ...)
  - MODIFY(컬럼명 타입, ...)
  - DROP COLUMN(컬럼명 타입,...)
*/

--EMP01 테이블에 JOB컬럼 추가

-- EMP01 테이블 확인
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP01';
-- EMP01 테이블 구조 확인
DESC EMP01;
-- JOB 칼럼 추가
ALTER TABLE EMP01
ADD (JOB VARCHAR2(9));

-- EMP01 테이블의 JOB 컬럼 사이즈 30으로 변경
ALTER TABLE EMP01
MODIFY JOB VARCGAR2(30);

/**
  테이블 삭제 :DROP TABLE 테이블명;
*/

-- EMP01 테이블 삭제
DROP TABLE EMP01;
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP01';

/**
  테이블의 로우 삭제 : TRUNCATE TABLE 테이블명; -- 복구불가능(주의)
*/
--EMP02 테이블의 전체 행 모두 삭제
SELECT * FROM USER_ALTERS WHERE TABLE_NAME='EMP02';
SELECT * FROM EMP02;
TRUNCATE TABLE EMP02;

/**
  테이블명 치환 : RENAME 이전 테이블명 TO 새로운 테이블명
*/

-- EMP02테이블의 이름을 TEST로 치환
SELECT* FROM USER_TABLES WHERE TABLE_NAME ='EMP02';
RENAME EMP02 TO TEST;
SELECT *FROM USER_TABLES WHERE TABLE_NAME='TEST';

SELECT * FROM USER_TABLES;
SELECT COUNT(*) FROM ALL_TABLES; --84
SELECT COUNT(*) FROM DBA_TABLES; -- 접근 불가능

/**
  데이터 추가 : INSERT
  형식 : INSERT INTO 테이블명(칼럼리스트) VALUES(칼럼값,...);
*/
-- DEPT01 테이블 삭제
SELECT * FROM USER_TABLES WHERE TABLE_NAME ='DEPT01';
DROP TABLE DEPT01;

-- DEPT 테이블의 구조만 복제하여 DEPT01 생성
CREATE TABLE DEPT01
AS
SELECT * FROM DEPT WHERE 1=0;

DESC DEPT01;

-- DEPT01 데이터 추가 , 10, ACCOUNTING, NEW YORK
INSERT INTO DEPT01(DEPTNO, DNAME, LOC) VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01(DEPTNO, DNAME, LOC) VALUES(20, 'SALES', 'SEOUL');
INSERT INTO DEPT01(LOC,DNAME, DEPTNO) VALUES('BUSAN', 'MANAGER', 30);
SELECT * FROM DEPT01;

-- 자동으로 셋팅이 안되어있으면 commit 해주어야 db에 반영이 되어진다.
COMMIT;

-- DICTIONALRY
SELECT *FROM USER_TABLES WHERE TABLE_NAME ='SAM01';

--EMP 테이블의 EMPNO, ENAME, JOB, SAL 컬럼 구조를 복제하여 SAM01 테이블 생성
CREATE TABLE SAM01
AS
SELECT EMPNO, ENAME, JOB, SAL 
FROM EMP 
WHERE 1=0;

INSERT INTO SAM01(EMPNO, ENAME, JOB, SAL) VALUES(1000, 'APPLE', 'POLICE', NULL);
INSERT INTO SAM01(EMPNO, ENAME, JOB, SAL) VALUES(1010, 'BANANA', NULL, 15000);
INSERT INTO SAM01(EMPNO, ENAME, JOB, SAL) VALUES(1020, 'ORANGE', NULL, NULL);
INSERT INTO SAM01(EMPNO, ENAME, JOB, SAL) VALUES(NULL, NULL, NULL, NULL);

-- NOT NULL 제약을 가진 테이블 생성

CREATE TABLE SAM02(
  EMPNO NUMBER(4) NOT NULL,
  ENAME VARCHAR2(10),
  JOB VARCHAR2(9),
  SAL NUMBER(7,2)
);

SELECT * FROM USER_TABLES WHERE TABLE_NAME ='SAM02';
DESC SAM02;

INSERT INTO SAM02(EMPNO, ENAME, JOB, SAL) VALUES(NULL, NULL, NULL, NULL);


/**
  시퀀스(SEQUENCE) : 자동번호 생성기 --> PK(Primary key) 
*/
-- 시퀀스 확인
SELECT * FROM USER_SEQUENCES;

-- 시퀀스 생성
CREATE SEQUENCE SEQU_EMP01
  START WITH 1
  INCREMENT BY 1
;

-- EMP 테이블의 EMPNO, ENAME, DEPTNO 구조만 복제하여 EMP01 생성
CREATE TABLE EMP01
AS
SELECT EMPNO, ENAME, DEPTNO FROM EMP WHERE 1=0;

SELECT * FROM EMP01;

-- 시퀀스를 이용하여 데이터 추가하기

INSERT INTO EMP01 VALUES (SEQU_EMP01.NEXTVAL ,'SMITH',10); 
INSERT INTO EMP01 VALUES (SEQU_EMP01.NEXTVAL ,'SCOTT',20); 

-- EMP01 데이터 전체 삭제
TRUNCATE TABLE EMP01;
SELECT * FROM EMP01;

-- SEQU_EMP01.NEXTVAL 값은 3부터 나온다. 1,2는 지워졌더라도 1이 아니라 3부터 시작함.****
INSERT INTO EMP01 VALUES (SEQU_EMP01.NEXTVAL ,'SMITH',10); 

-- 시퀀스 삭제
DROP SEQUENCE SEQU_EMP01;
SELECT * FROM USER_SEQUENCES;


-- 1000에서 부터 1씩 증가하는 시퀀스를 SEQU_EMP01 이름으로 생성하고, EMP01 테이블의 사원번호 컬럼에 적용하여 INSERT
SELECT * FROM USER_SEQUENCES;
CREATE SEQUENCE SEQU_EMP01
  START WITH 1000
  INCREMENT BY 1
;

SELECT * FROM EMP01;
INSERT INTO EMP01 VALUES(SEQU_EMP01.NEXTVAL, 'SMITH', 10);
-- ROWNUM 
SELECT ROWNUM, EMPNO, ENAME, DEPTNO FROM EMP01;

-- STU 테이블 생성
-- SNO 학번,NAME 이름,KOR 국어,ENG 영어,MATH 수학,TOT 총점,AVG 평균

select * from stu;

CREATE TABLE STU(
  SNO VARCHAR2(10) NOT NULL, --SIST0001
  SNAME VARCHAR2(20) NOT NULL,
  SKOR NUMBER(4),
  SENG NUMBER(4),
  SMATH NUMBER(4),
  STOT NUMBER(6,2),
  SAVG NUMBER(6,2)
);
drop table stu;
desc stu;

select * from stu;

/**08/20 서브쿼리를 활용한 insert */
-- DEPT 테이블 구조를 복제한 DEPT02 테이블 생성
SELECT * FROM USER_TABLES WHERE TABLE_NAME= 'DEPT02';
DROP TABLE DEPT02;

CREATE TABLE DEPT02
AS
SELECT * FROM DEPT WHERE 1=0;

-- DEPT 테이블의 데이터들을 DEPT02에 추가 (서브쿼리로 넣음)
 
INSERT INTO DEPT02 SELECT * FROM DEPT;
SELECT * FROM DEPT02;

-- SAM01
SELECT*FROM USER_TABLES WHERE TABLE_NAME = 'SAM01';
SELECT*FROM SAM01;

--EMP 테이블의 10번 부서에 있는 사원들을 SAM01에 추가 (컬럼명들이 동일 해야 한다.)
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO = 10;

SELECT * FROM EMP;

-- EMP 테이블의 EMPNO, ENAME, HIREDATE 컬럼의 구조를 복제하여 EMP_HIR 테이블 생성
-- 1단계 : 테이블 확인
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP_HIR';
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP_MGR';

CREATE TABLE EMP_HIR 
AS
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE 1=0;


CREATE TABLE EMP_MGR 
AS 
SELECT EMPNO, ENAME, MGR FROM EMP WHERE 1=0;

INSERT ALL  
INTO EMP_HIR VALUES(EMPNO, ENAME, HIREDATE) 
INTO EMP_MGR VALUES(EMPNO, ENAME, MGR) 
SELECT EMPNO, ENAME, HIREDATE, MGR  FROM EMP WHERE DEPTNO=20; 

SELECT * FROM EMP_HIR;
SELECT * FROM EMP_MGR;


CREATE TABLE EMP_SAL  
AS 
SELECT EMPNO, ENAME, SAL FROM EMP WHERE 1=0;


-- 한번에 조건을 주고 INSERT 하기
INSERT ALL
WHEN HIREDATE >'81/06/30' THEN
INTO EMP_HIR02 VALUES(EMPNO, ENAME, HIREDATE)
WHEN SAL > 2000 THEN
INTO EMP_SAL VALUES(EMPNO, ENAME, SAL)
SELECT EMPNO, ENAME, HIREDATE ,SAL FROM EMP;

SELECT * FROM EMP_HIR02;
SELECT * FROM EMP_SAL;

/**
  데이터 형식 : UPDATE
  형식 : UPDATE 테이블명 SET 컬럼명 = 값, ... WHERE 조건절;
*/

-- EMP01 테이블의 모든 부서번호를 30번으로 수정
SELECT * FROM USER_TABLES WHERE TABLE_NAME ='EMP01';
SELECT * FROM EMP01;

UPDATE EMP01 SET DEPTNO =30;

-- INSERT 는 새로운 ROW 추가, UPDATE는 기존의 ROW 수정할때 사용 !!!!!!!!!!!
-- EMP01 테이블에 SAL 컬럼 추가 - 
ALTER TABLE EMP01
ADD (SAL NUMBER(6,2));

-- 기본 급여를 1000으로 UPDATE 후 모든 사원의 급여를 10% 인상 적용
UPDATE EMP01 SET SAL = 1000; 
UPDATE EMP01 SET SAL = SAL*1.1;
SELECT * FROM EMP01;

-- EMPNO가 1004번인 사원의 급여를 30% 인상
UPDATE EMP01 SET SAL = SAL*1.3 WHERE EMPNO=1004;

COMMIT;

-- EMP_HIR 테이블의 입사일 중 81/06/30 이후에 입사한 사원들의 날짜를 현재 날짜로 수정
SELECT * FROM EMP_HIR;
UPDATE EMP_HIR SET HIREDATE = SYSDATE WHERE HIREDATE > '81/06/30';

-- EMP01 테이블을 삭제하고, EMP 테이블을 복제하여 EMP01 생성
DROP TABLE EMP01;
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP01';
CREATE TABLE EMP01
AS
SELECT*FROM EMP;

--SMITH 사원의 부서번호를 30번으로 , 직급은 MANAGER로 수정
SELECT * FROM EMP01;
UPDATE EMP01 SET DEPTNO = 30, JOB = 'MANAGER' WHERE ENAME = 'SMITH';

-- 81년에 입사한 사원들의 부서번호를 50번으로, 직급은 SALESMAN으로 수정
SELECT COUNT(*) FROM EMP01 WHERE SUBSTR(HIREDATE, 1,2) = 81;
UPDATE EMP01 SET DEPTNO = 50, JOB = 'SALESMAN' WHERE SUBSTR(HIREDATE, 1,2) =81;

-- EMP01 테이블에서 커미션이 NULL 인 사원들의 부서를 20번으로 수정
UPDATE EMP01 SET DEPTNO =20 WHERE COMM IS NULL;

-- EMP01 테이블에 LOC 컬럼 추가
DESC EMP01;
ALTER TABLE EMP01 ADD(LOC VARCHAR2(13));


-- 20번 부서의 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리 문을 사용해 봅시다.
SELECT * FROM EMP01;
SELECT * FROM DEPT;

UPDATE EMP01
SET LOC = (SELECT LOC FROM DEPT WHERE DEPTNO =20)
WHERE DEPTNO = 20;

/**
  데이터 삭제 : DELETE
  형식 : DELETE FROM 테이블명 WHERE 조건절;
*/

-- DEPT01 테이블의 모든 행 삭제
SELECT* FROM USER_TABLES WHERE TABLE_NAME = 'DEPT01';
SELECT * FROM DEPT01;
DELETE FROM DEPT01;

-- EMP01 테이블의 50븐 부서 삭제
SELECT COUNT(*) FROM EMP01 WHERE DEPTNO = 50; --4
DELETE FROM EMP01 WHERE DEPTNO = 50;
SELECT *FROM EMP01;


-- SAM01 테이블에서 사원 번호가 3000이고, 직급이 정해지지 않은 데이터 삭제
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'SAM01';
SELECT * FROM SAM01;

DELETE FROM SAM01 WHERE EMPNO =1020 AND JOB IS NULL;

/** 서브쿼리는 ( ~~ ) 중괄호 안에 작성 */

-- SAM01 테이블의 사원번호가 1000인 사원보다 연봉이 낮은ㅇ 사원을 EMP01 테이블에서 삭제
DELETE FROM EMP01 WHERE SAL < ( SELECT SAL FROM SAM01 WHERE EMPNO = 1000 );

-- MERGE
-- EMP 테이블 복제 후 생성
DROP TABLE EMP01;
SELECT * FROM USERT_TABLES WHERE TABLE_NAME ='EMP01';
CREATE TABLE EMP01
AS
SELECT * FROM EMP;
SELECT * FROM EMP01;

-- EMP 테이블의 직급이 MANAGER인 사원들만 복제해서 EMP02 생성
CREATE TABLE EMP02 
AS 
SELECT * FROM EMP WHERE JOB = 'MANAGER';
SELECT * FROM EMP02;

-- EMP02 테이블의 JOB을 TEST로 수정
UPDATE EMP02 SET JOB = 'TEST';

-- EMP02 테이블에 새로운 데이터 추가
INSERT INTO EMP02
VALUES(9000, 'SYS', 'TOP', 7566, SYSDATE, 3000, 300, 30);

MERGE INTO EMP01
USING EMP02
ON(EMP01.EMPNO=EMP02.EMPNO)
WHEN MATCHED THEN
UPDATE SET
EMP01.ENAME = EMP02.ENAME,
EMP01.JOB = EMP02.JOB,
EMP01.MGR = EMP02.MGR,
EMP01.HIREDATE=EMP02.HIREDATE,
EMP01.SAL=EMP02.SAL,
EMP01.COMM=EMP02.COMM,
EMP01.DEPTNO=EMP02.DEPTNO 
WHEN NOT MATCHED THEN 
INSERT VALUES(EMP02.EMPNO, EMP02.ENAME, EMP02.JOB,  EMP02.MGR, EMP02.HIREDATE, EMP02.SAL,  EMP02.COMM, EMP02.DEPTNO); 

SELECT * FROM EMP01;

--
DESC  STU;
SELECT * FROM STU;
SELECT * FROM USER_SEQUENCES;


CREATE SEQUENCE  SEQU_STU
START WITH 1
INCREMENT BY 1;

SELECT 'SIST_' || SEQU_STU.NEXTVAL FROM DUAL;

SELECT * FROM STU;
select * from stu;
SELECT * FROM USER_TABLES;

select rownum, sno, sname, skor, seng, smath,stot, trunc(savg,2) from stu order by sno;

select rownum, sno, sname, skor, seng, smath,stot, savg 
from (select  sno, sname, skor, seng, smath,stot, trunc(savg,2) savg from stu order by sno);

select * from stu where sno=upper('sist_3');

-- UPDATE 테이블명 SET 컬럼명 = 값, ... WHERE 조건절;
update stu set sname = '홍홍', skor = 100, seng = 90, smath = 80 where sno = 'st-0001';

/**
  조인(join) : 다중 테이블 연결 - 곱하기
*/
-- cross join 연결된 조건이 하나도 없을때 곱한다.
select * from emp;
select * from dept;
select * from emp cross join dept;
select count(*) from emp, dept;
select count(*) from emp cross join dept;

-- Equi Joj


SELECT * FROM EMP;
SELECT * FROM DEPT;
-- 뉴욕에서 근무하는 사원의 이름과 급여를 출력하세요.
SELECT ENAME, SAL FROM EMP, DEPT WHERE LOC = 'NEW YORK';


SELECT ENAME, SAL FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND LOC = 'NEW YORK';


-- ACCOUNTING 부서 소속 사원의 이름과 입사일을 출력하시오
SELECT ENAME, HIREDATE FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND DEPT.DNAME = 'ACCOUNTING';

-- 직급이 MANAGER인 사원의 이름, 부서명을 출력하세요.
SELECT ENAME, DNAME FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND JOB= 'MANAGER';\

--조인 명령어에서 테이블 개수 제한이 있을까요? 넵 근데 느려짐 

-- 직급이 MANAGER인 사원의 사원번호, 이름, 급여, 부서명, 급여등급을 출력\
SELECT * FROM SALGRADE;
SELECT EMPNO, ENAME, SAL, DNAME, GRADE 
FROM EMP, DEPT, SALGRADE
 -- EQUI 조인  EMP.DEPTNO = DEPT.DEPTNO 을 꼭 넣어야 한다.
WHERE EMP.DEPTNO = DEPT.DEPTNO 
  AND SAL BETWEEN LOSAL AND HISAL 
  AND JOB = 'MANAGER';
 
 --SELF JOIN
 SELECT * 
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO;

-- SMITH 사원의 매니저 이름을 출력해주세요.
SELECT E1.ENAME, E2.ENAME
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO
AND E1.ENAME ='SMITH';

-- SMITH 사원의 매니저 이름을 출력(서브쿼리)
SELECT ENAME 상사
FROM EMP
WHERE EMPNO = (SELECT MGR FROM EMP WHERE ENAME ='SMITH');

-- BLAKE 사원이 관리하는 후배 사원들을 출력해주세요(서브쿼리)

-- 조인 조건에 만족하지 못하였더라도 해당 로우를 나타내고 싶을 때에 사용하는 것이 외부 조인(Outer Join)
-- OUTER JOIN        (+) 
SELECT * FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- 40번은  EMP에 들어있지 않아서 출력이 안된다.
SELECT* FROM DEPT;

-- EMP.DEPTNO 가 NULL이 뜨기 때문에 NULL이 뜨는 자리에 (+) 를 넣어주면 된다. 

SELECT * FROM EMP, DEPT
WHERE EMP.DEPTNO(+) = DEPT.DEPTNO;

-- 내가 쓴거의 기준 FROM 절 - EMP (기준) DEPT - (RIGHT) DEPT 기준으로 
-- ANSI SQL 
SELECT * 
FROM EMP RIGHT OUTER JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO;

SELECT * FROM EMP, DEPT
WHERE EMP.DEPTNO(+) = DEPT.DEPTNO;


-- EMP 테이블의 사원중에서 30번 부서에 속하는 사원들의 
-- 사원번호, 사원명, 급여, 부서번호, 부서명의 데이터를 복제하여 EMP9 생성

CREATE TABLE EMP9
AS
SELECT EMPNO, ENAME, SAL , E.DEPTNO, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.DEPTNO = 30;

SELECT * FROM EMP9;

-- EMP 테이블의 사원중에서 30번 부서에 속하는 사원들 중
-- 입사일이 81년 하반기 입사자 들의
-- 사원번호, 사원명, 급여, 부서번호, 부서명의 데이터를 복제하여 EMP10 생성
CREATE TABLE EMP10
AS
SELECT EMPNO, ENAME, SAL, E.DEPTNO, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.DEPTNO = 30
AND HIREDATE > '81/06/30'; 

SELECT * FROM EMP10;

-- EMP9 (6) 테이블과 EMP10(3) 테이블 CROSS JOIN (6*3 = 18)
SELECT * FROM EMP9, EMP10;
SELECT * FROM EMP9 CROSS JOIN EMP10;

-- EMP9 테이블과 EMP10 테이블 EQUI JOIN
SELECT * FROM EMP9, EMP10
WHERE EMP9.EMPNO = EMP10.EMPNO;

-- EMP9 테이블과 EMP10 테이블을 EMP9 기준으로 OUTER JOIN : 6
SELECT * FROM EMP9, EMP10
WHERE EMP9.EMPNO = EMP10.EMPNO(+);

-- EMP10 테이블과 EMP9 테이블을 EMP9 기준으로 OUTER JOIN : 3
SELECT * FROM EMP9, EMP10
WHERE EMP9.EMPNO(+) = EMP10.EMPNO;

COMMIT;
/**
  서브쿼리 : 메인쿼리의 조건절에 포함되어 쿼리를 먼저 수행하는 형식 
*/
-- SMITH 사원과 같은 부서에 근무하는 사원들을 출력
SELECT * FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SMITH');


-- 7369의 사원 번호를 가진 사원과 같은 부서에 근무하는 사람들을 출력
SELECT * FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE EMPNO = '7369');

-- 7902 사원이 관리하는 사원과 같은 부서에 근무하는 사람들을 출력
SELECT * FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE EMPNO =(SELECT EMPNO FROM EMP  WHERE MGR='7902'));

-- SMITH 아 동일한 직급을 가진 사원을 출력
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SMITH');
-- SMITH 의 급여와 동일하거나 더 많이 받는 사원ㅁ ㅕㅇ과 급여를 출력
SELECT ENAME, SAL FROM EMP WHERE SAL >= (SELECT SAL FROM EMP WHERE ENAME ='SMITH');
SELECT * FROM EMP;
SELECT * FROM DEPT WHERE LOC = 'DALLAS';
-- DALLAS 에서 근무하는 사원의 이름, 부서 번호를 출력
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

SELECT E1.ENAME, E1.DEPTNO FROM EMP E1, DEPT D WHERE E1.DEPTNO = D.DEPTNO AND D.LOC = 'DALLAS';

-- SALES 부서에서 근무하는 모든 사원의 이름과 급여를 출력
SELECT ENAME, SAL FROM EMP WHERE DEPTNO= (SELECT DEPTNO FROM DEPT WHERE DNAME ='SALES');
SELECT ENAME, SAL FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND DNAME = 'SALES';

--직속 상관이 KING인 사원의 이름과 급여를 출력
SELECT * FROM EMP;
SELECT ENAME, SAL FROM EMP WHERE MGR =(SELECT EMPNO FROM EMP WHERE ENAME='KING');

SELECT E1.ENAME, E1.SAL FROM EMP E1, EMP E2 WHERE E1.MGR = E2.EMPNO AND E2.ENAME='KING';

-- 평균 급여보다 급여가 많은 사원을 출력
SELECT * FROM EMP WHERE SAL >(SELECT AVG(SAL) FROM EMP);

SELECT DISTINCT DEPTNO FROM EMP ; -- 여러줄이 출력 -> 다중행
SELECT DISTINCT DEPTNO FROM EMP WHERE ENAME ='SMITH'; --> 한줄이 출력 = 단일행

-- 다중행 서브쿼리 : 서브쿼리의 결과를 다중행으로 출력 
-- 3000 이상 받는 사원이 소속된 부서(10번, 20번)와 동일한 부서에서 근무하는 사원 출력
SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL >=3000);

-- 부서 별(GROUP BY 함수)
-- 부서별로 가장 급여를 많이 받는 사원의 정보
--(사원 번호, 사원이름, 급여 , 부서 번호) 를 출력하시오 (IN 연산자)
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE SAL IN(SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- 직급(JOB)이 MANAGER인 사람이 속한 부서의 부서번호, 부서명, 지역을 출력
SELECT DEPTNO, DNAME, LOC FROM DEPT WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');

SELECT SAL FROM EMP WHERE DEPTNO = 30;

-- '> ALL ' : MAX() - 모든 비교값 보다 더 큰 값인지 비교
-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사람의
-- 이름, 급여를 출력하는 쿼리문을 작성

SELECT ENAME, SAL FROM EMP 
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30);

SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);

-- 단일 행으로 바꿀수 있는가를 고민해봐야한다 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

-- '> ANY : MIN()'
-- 30번 소속 사원들 중에서 급여를 가장 적게 받는 사원보다 더 많은 급여를 받는 사람의
-- 이름, 급여를 출력하는 쿼리문을 작성
SELECT ENAME, SAL 
FROM EMP
WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO = 30);

SELECT COUNT(*)
FROM (SELECT ENAME, SAL 
FROM EMP
WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO = 30));

SELECT ENAME, SAL 
FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);

SELECT COUNT(*)
FROM 
(SELECT ENAME, SAL 
FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30));


-- 데이터 딕셔너리  제약 확인

DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;
--  어떤 칼럼에 어떤 제약 조 건이 지정되었는지 알려주는 데이터 딕셔너리
SELECT * FROM USER_CONS_COLUMNS;

-- NOT NULL : 데이터가 반드시 필요한 컬럼에 제약 설정
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP01';
DROP TABLE EMP01;

CREATE TABLE EMP01(
  EMPNO NUMBER(4) NOT NULL,
  ENAME VARCHAR2(20) NOT NULL,
  HIREDATE DATE,
  SAL NUMBER(6,2)
);

SELECT * FROM EMP01;

--EMP01 테이블의 제약사항 확인
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME ='EMP01';
-- C = CHECK OR NOT NULL 

SELECT * FROM USER_CONS_COLUMNS
WHERE TABLE_NAME = 'EMP01';

INSERT INTO EMP01(EMPNO, ENAME, HIREDATE,SAL)
VALUES(1000, 'HONG', SYSDATE, 100);

INSERT INTO EMP01(EMPNO, ENAME, HIREDATE,SAL)
VALUES(1000, '홍길동', NULL, 100);

SELECT * FROM EMP01;
SELECT * FROM USER_TABLES WHERE TABLE_NAME ='EMP02';
DROP TABLE EMP02;

CREATE TABLE EMP02(
  EMPNO NUMBER(4) UNIQUE,
  ENAME VARCHAR2(20) NOT NULL,
  SAL NUMBER(6,2)
);

SELECT * FROM USER_CONS_COLUMNS
WHERE TABLE_NAME ='EMP02';

INSERT INTO EMP02 VALUES(1000, '홍길동', 100);
INSERT INTO EMP02 VALUES(2000, '홍길동', 100);
INSERT INTO EMP02 VALUES(NULL, '홍길동', 100);
INSERT INTO EMP02 VALUES(NULL, NULL, 100);
-- NULL은 중복체크에서 열외이다.!!!!!!! UNIQUE 를 사용했을때 NULL은 제외된다. 
SELECT * FROM EMP02;

-- PRIMARY KEY : UNIQUE + NOT NULL 
DROP TABLE EMP03;
CREATE TABLE EMP03(
  EMPNO NUMBER(4) PRIMARY KEY,
  ENAME VARCHAR2(20) NOT NULL,
  SAL NUMBER(6,2)
);

SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME='EMP03';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME ='EMP03';

DESC EMP03;

INSERT INTO EMP03 VALUES(1000,'홍길동',100);
INSERT INTO EMP03 VALUES(1001,'홍길동',100);


--제약명 설정
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP04';
DROP TABLE EMP04;

CREATE TABLE EMP04(
  EMPNO NUMBER(4) CONSTRAINT PK_EMPNO_EMP04 PRIMARY KEY,
  ENAME VARCHAR2(20) CONSTRAINT NN_ENAME_EMP04 NOT NULL,
  SAL NUMBER(6,2)
);

SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME ='EMP04';

SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME ='EMP04';

CREATE SEQUENCE SEQ 
START WITH 1 
INCREMENT BY 1; 

create table CLIENT2(
    seq seq,
    NAME VARCHAR2(20),
    SEX number(2),
    ADDRESS VARCHAR(40),
    PHONE   VARCHAR(20),
    division number(2),
    created_date date,
    birth_date date
);