/*
  SQL ���� 
*/

-- ��밡���� ���̺� Ȯ��
SELECT * FROM SYS.USER_TABLES;
SELECT * FROM tab;

-- EMP ���̺� ���� Ȯ�� : DESC ���̺��;
DESC EMP;
DESC DEPT;

/* SELECT ��ɾ� - ������ ��ȸ */
-- ���� : SELECT [DISTINCT] *(��ü), �÷���, �÷��� ���� ��Ī FROM ���̺��;

-- EMP ���̺� �ִ� ��� ������ ��ȸ
SELECT * FROM EMP;

-- DEPT ���̺� �ִ� ��� ������ ��ȸ
SELECT * FROM TAB;
SELECT * FROM DEPT;

-- EMP ���̺��� �����ȣ(EMPNO)�� �����(ENAME)�� ��ȸ
SELECT EMPNO, ENAME FROM EMP;

-- DEPT  ���̺��� �μ���ȣ�� ��ġ�� ��ȸ  
DESC DEPT;
SELECT Deptno, LOC FROM dept;
    
-- EMP ���̺��� ������ �Ի����� ��ȸ
DESC EMP;
SELECT ENAME, HIREDATE FROM EMP;

-- EMP ���̺��� ������ �Ի����� ��ȸ�� ��� �÷����� �����, �Ի��Ϸ� ���
-- ������ ��������� " " ������ ���� �־��ش�.
SELECT ENAME "�� �� ��", HIREDATE �Ի��� FROM EMP;

-- EMP ���̺��� ��� ������ ���( �����ȣ, �����, �޿�, ����(�޿� * 12))

SELECT EMPNO �����ȣ, ENAME �����, SAL �޿�, SAL * 12 ���� FROM EMP;
SELECT * FROM EMP;

-- EMP ���̺��ǻ���� �����ȣ, �����, �޿�, ���ʽ�(SAL * COMM) �� ��ȸ
SELECT EMPNO �����ȣ, ENAME �����, SAL �޿�, SAL * COMM ���ʽ� FROM EMP;

-- COMM �÷��� NULL ���� 0���� ġȯ

SELECT COMM, NVL(COMM,0) FROM EMP;
SELECT EMPNO �����ȣ, ENAME �����, SAL �޿�, SAL * NVL(COMM,0) ���ʽ� FROM EMP;

-- ���ڿ� ���� : ||(concateration)\
-- 'Smith�� ������ Manager �Դϴ�.'
SELECT ename || '�� ������ '|| job || ' �Դϴ�. 'FROM EMP;

-- DISTINCT : �ߺ��� ������ ���� ���
-- EMP ���̺��� �����ȣ, �����, �μ���ȣ ��ȸ
SELECT DISTINCT EMPNO, ENAME, DEPTNO  FROM EMP;
-- Ű ���� EMPNO �̱⶧���� �ߺ����� DEPTNO�� ���ŵ��� ����.

-- EMP ���̺��� �μ���ȣ ��ȸ
SELECT DEPTNO FROM EMP; --12��
SELECT DISTINCT DEPTNO FROM EMP;  --3��

-- EMP ���̺��� ����(JOB)�� �ߺ����� �ʵ��� ��ȸ
SELECT DISTINCT JOB FROM EMP;

-- Ư�� ������ �����͸� ��ȸ�ϴ� ���
-- SELECT ~~~ FROM ~~~ WHERE  ���ǽ�(   SAL      =       3000;  )
--                                   1.�÷� 2. ������ 3. �񱳴��
-- EMP ���̺��� �޿��� 3000�� ����� ��ȸ
SELECT * FROM EMP WHERE SAL = 3000;

-- EMP ���̺��� �޿��� 1500 ���� ���� ����� �����ȣ, �����, �μ���ȣ�� ��ȸ
SELECT EMPNO �����ȣ, ENAME �����, DEPTNO �μ���ȣ , SAL �޿�, NVL(COMM,0) Ŀ�̼� FROM EMP WHERE SAL >1500;

-- EMP ���̺��� �޿��� 1500 ���� ���� ����� �����ȣ, �����, �μ���ȣ�� ��ȸ
SELECT EMPNO �����ȣ, ENAME �����, DEPTNO �μ���ȣ , SAL �޿�, NVL(COMM,0) Ŀ�̼� FROM EMP WHERE SAL <1500;

-- EMP ���̺��� �μ���ȣ�� 20���� ����� ��� ���
SELECT *FROM EMP WHERE DEPTNO = 20;

-- EMP ���̺��� ��� �� ���ʽ��� 100000 �̻��� ����� ��� ��� 
-- (���ʽ��� �޿� * Ŀ�̼�)

SELECT * FROM EMP WHERE SAL * COMM >= 100000;

-- EMP ���̺��� ��� �� ���ʽ��� 100000 �̻��� ����� �����ȣ, �����, �޿�, Ŀ�̼�, ���ʽ� ���
-- (���ʽ��� �޿�*Ŀ�̼�, Ŀ�̼��� DEFAULT �� 0)
SELECT EMPNO, ENAME, SAL, NVL(COMM, 0) COMM,SAL*COMM BONUS FROM EMP WHERE SAL*NVL(COMM, 0) >= 100000;
-- SELECT EMPNO, ENAME, SAL, NVL(COMM, 0) COMM,SAL*COMM BONUS FROM EMP WHERE BONUS >= 100000;
-- SELECT * FROM �� ����� �Ŀ� WHERE ���� ����Ǵµ� BONUS �� �÷��̸��� �Ǵµ� ��Ī�̾ ������ ���� �ʴ´�.

--���� �����͸� ���Ͽ� ��ȸ ( ���ڿ� = ' ' , ��/�ҹ��� ����)
--������� SMITH�� ����� ��� ������ ���
  SELECT * FROM EMP WHERE ENAME = 'SMITH';
  
-- ������� JONES ����� ���� �� �����ȣ, �����, �μ���ȣ, �Ի���, �޿� ���
SELECT EMPNO, ENAME, DEPTNO, HIREDATE, SAL FROM EMP WHERE ENAME = 'JONES';

-- �����ȣ�� 7566�� ����� �����, ���ް� �μ���ȣ�� ���
DESC EMP;
SELECT ENAME , JOB, DEPTNO FROM EMP WHERE EMPNO = 7566;

/** ��¥ ������(YY/MM/DD)�� ���Ͽ� ��ȸ */
-- 1981�� 7�� 1�� ������ �Ի��� ����� ���

SELECT * FROM EMP WHERE HIREDATE <= '82/07/01';

-- 1981�� 3��б� ���Ŀ� �Ի��� ����� ���
SELECT * FROM EMP WHERE HIREDATE >= '81/09/01';


/** �������ڸ� Ȱ���� ������ ��ȸ (AND, OR, NOT ) */
-- EMP ���̺��� ��� �� �μ���ȣ�� 10���̰�, ������ MANAGER�� ����� ���
SELECT * FROM EMP WHERE DEPTNO = 10 AND JOB ='MANAGER';

-- EMP ���̺��� ��� �� �μ���ȣ�� 10���̰ų� ������ MANAGER�� ����� ���
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB ='MANAGER';

-- EMP ���̺��� ��� �� �μ���ȣ�� 10���� �ƴϰų� ������ MANAGER�� �ƴ� ����� ���
SELECT * FROM EMP WHERE DEPTNO != 10 OR JOB != 'MANAGER';
SELECT * FROM EMP WHERE DEPTNO <> 10 OR JOB <> 'MANAGER';

-- 1981�� ��ݱ⿡ �Ի��� ������� ��� ����� �ּ���.
SELECT * FROM EMP WHERE HIREDATE > '81/01/01' AND HIREDATE <'81/06/30';

-- BETWEEN ~ AND ������
SELECT * FROM EMP WHERE HIREDATE BETWEEN '81/01/01' AND '81/06/30';

-- 2000���� 3000 ������ �޿��� �޴� ������� ��ȸ
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL <= 3000;
SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 3000;

-- Ŀ�̼��� 300 �̰ų� 500�̰ų� 1400 �� ����� ��ȸ
SELECT * FROM EMP WHERE COMM =300 OR COMM =500 OR COMM = 1400;
-- IN
SELECT * FROM EMP WHERE COMM IN(300,500,1400);

/**
  08-13
*/
-- ��� ��ȣ�� 7521�̰� ������ SALESMAN�� ����� �˻��ϼ���. (��������)
SELECT * FROM EMP WHERE EMPNO = 7521 AND JOB= 'SALESMAN';
-- ��� ��ȣ�� 7521�̰� 7654�� ����� �˻�(����)�ϼ���. (BETWEEN AND)
SELECT * FROM EMP WHERE IEMPNO BETWEEN 7521 AND 7654;
-- ��� ��ȣ�� 7521�̰ų�, 7654�̰ų�, 7369�� ����� �˻��ϼ���.(��������)
SELECT * FROM EMP WHERE EMPNO = 7521 OR EMPNO = 7654 OR EMPNO =7369;
-- ��� ��ȣ�� 7521�̰ų�, 7654�̰ų�, 7369�� ����� �˻��ϼ���.(IN)
SELECT * FROM EMP WHERE EMPNO IN(7521,7654,7369);

-- ������� J �� �����ϴ� ��� ������� ��� 
SELECT * FROM EMP WHERE ENAME LIKE 'J%Y';

-- ������� A �� �����ϴ� ��� ������� ��� 
SELECT * FROM EMP WHERE ENAME LIKE '%A%';

-- Ŀ�̼��� NULL�� ��� ����� ���
SELECT * FROM EMP WHERE COMM IS NULL;

-- Ŀ�̼��� NULL�� �ƴ� ��� ����� ���
SELECT * FROM EMP WHERE COMM IS NOT NULL;

-- CEO ��� : MGR �÷��� NULL �� ���
SELECT * FROM EMP WHERE MGR IS NULL;

/**
  ������ ���� : ORDER BY (ASC, DESC) 
*/

-- �޿� ������ ������� ������ �� ���

-- ��������
SELECT * FROM EMP ORDER BY SAL ASC;
SELECT * FROM EMP ORDER BY SAL;

-- ��������
SELECT * FROM EMP ORDER BY SAL DESC;

-- 30�� �μ� �߿��� ���� ���� �޿��� �޴� ������ �����Ͽ� ���
SELECT * FROM EMP WHERE DEPTNO = 30 ORDER BY SAL DESC;

-- 81�� ��ݱ� �Ի��ڵ� �߿� ���ʽ��� ���� �޴� ������ �����Ͽ� ���
-- ���ʽ��� �޿�*Ŀ�̼� �������� �ϰ�, ����Ʈ ���� 0
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM, 0) COMM, DEPTNO, NVL(COMM, 0)*SAL BONUS FROM EMP WHERE HIREDATE BETWEEN '81/01/01' AND '81/06/30' ORDER BY BONUS DESC;

--�μ� ��ȣ�� ���� ������� ����ϵ� ���� �μ� ���� ����� ����� ��� �ֱٿ� �Ի��� ������� ����ϵ��� �ϵ� �����ȣ, �Ի���, ��� �̸�, �޿� ������ ����Ͻÿ�
SELECT DEPTNO, EMPNO, HIREDATE, ENAME, SAL FROM EMP ORDER BY DEPTNO ASC, HIREDATE DESC;

/**
  SQL �Լ�
*/

-- DUAL ���̺� ���� Ȯ��
DESC DUAL;

SELECT * FROM DUAL;

/** ���� ������ Ÿ�Կ� ����Ǵ� �Լ� */

-- ���밪 ���ϱ�  : ABS() �Լ�
SELECT -100, ABS(-100) FROM DUAL;

-- �Ҽ��� �ڸ��� : FLOOR �Լ�
SELECT 34.5678, FLOOR(34.5789)FROM DUAL;

-- �Ҽ��� �ݿø� : ROUND() �Լ�
SELECT 34.5678, ROUND(34.5678) FROM DUAL;

-- Ư�� �ڸ��� �Ҽ��� �ݿø� : ROUND(���, �ڸ��� : ���) �Լ�
SELECT 34.5678, ROUND(34.5678, 2) FROM DUAL;
SELECT 34.5678, ROUND(34.5678, -1) FROM DUAL;

-- Ư�� �ڸ��� �Ҽ��� �ڸ��� : TRUNC(���, �ڸ��� : ���) �Լ�
SELECT TRUNC(34.5678, 2), TRUNC(34.5678, -1), TRUNC(34.5678) FROM DUAL;

-- ������ ���� : MOD
SELECT MOD(27,2), MOD(27,5), MOD(27,7) FROM DUAL;

--4���� Ȧ�� �� ������� �˻� : MOD(EMPNO,2) =1, MOD(EMPNO,2) <>0 
SELECT * FROM EMP WHERE MOD(EMPNO, 2) <> 0;

/** ���� ������ Ÿ�Կ� ����Ǵ� �Լ� */

-- �빮�ڷ� ġȯ : UPPER �Լ�
SELECT 'Welcome to Oracle', UPPER('Welcome to Oracle') FROM DUAL;

-- �ҹ��ڷ� ġȯ : LOWER �Լ�
SELECT 'Welcome to Oracle', LOWER('Welcome to Oracle') FROM DUAL;

-- ù���ڸ� �빮�ڷ� ġȯ : INITCAP �Լ�
SELECT 'Welcome to Oracle', INITCAP('WELCOME TO ORACLE') FROM DUAL;

-- ���ڿ� ���� ��ȯ : LENGTH �Լ�
SELECT LENGTH('ORACLE'), LENGTH('����Ŭ') FROM DUAL;

-- ���ڿ� ���� ��ȯ : LENGTHB �Լ� 
SELECT LENGTHB('ORACLE'), LENGTHB('����Ŭ') FROM DUAL;

-- ���ڿ� ���� : SUBSTR(����ڿ�, ����, ���ⰹ��) // -�� �ڿ��� ����
SELECT SUBSTR ('WELCOME TO ORACLE',4,3) FROM DUAL;
SELECT SUBSTR ('WELCOME TO ORACLE',-4,3) FROM DUAL;

-- EMP ���̺��� ��������� �Ի�⵵, �� �� ���
SELECT * FROM EMP;
SELECT SUBSTR(HIREDATE,1,2) Y, SUBSTR(HIREDATE,4,2) M FROM EMP;

-- 9���� �Ի��� ����� ���
SELECT * FROM EMP WHERE SUBSTR(HIREDATE,4,2) = 09;

-- 81�⵵ �Ի��� ����� ���
SELECT * FROM EMP WHERE SUBSTR(HIREDATE,1,2) = 81;

-- ���� Ȥ�� ��ȣ ä��� : LPAD, RPAD
SELECT LPAD('ORACLE',20,'#') FROM DUAL;
SELECT RPAD('ORACLE',20,'#') FROM DUAL;
SELECT EMPNO, ENAME, RPAD(JOB,9,' '), MGR, HIREDATE, SAL FROM EMP;
select * from emp;

-- ���� ���� : LTRIM, RTRIM 
SELECT LTRIM('            ORCLE'), RTRIM('ORACLE    ') FROM DUAL;

-- Ư�� ���ڿ� ���� : TRIM(���� ���ڿ� FROM ��� ���ڿ�)
SELECT TRIM('A' FROM 'AAAAORACLEAAA') FROM DUAL;

SELECT TRIM('     ORACLE     ') FROM DUAL;

select * from emp;

desc emp;

/** ��¥ �Լ� */
-- ���� ��¥�� ��ȯ : SYSDATE *******�߿�*******
SELECT SYSDATE FROM DUAL;

-- ���� ��¥ �������� 10�� ���� ��¥�� ���
SELECT SYSDATE+10 FROM DUAL;

-- ���� ��¥ �������� ����, ����, ���� ��¥�� ��� 
SELECT SYSDATE-1 ����, SYSDATE ����, SYSDATE+1 ���� FROM DUAL;

-- EMP ���̺� ������� ���� ��¥ �������� �ٹ��ϼ��� ���
SELECT EMPNO �����ȣ, ENAME �����, HIREDATE �Ի���, SYSDATE-HIREDATE �ٹ��ϼ� FROM EMP;
-- EMP ���̺� ������� ���� ��¥ �������� �ٹ��ϼ�(�Ҽ���2�� ����¥��)�� ���         //FLOOR- ��ü ����, TRUNC
SELECT EMPNO �����ȣ, ENAME �����, HIREDATE �Ի���, TRUNC(SYSDATE-HIREDATE , 2) �ٹ��ϼ� FROM EMP;
-- EMP ���̺� ������� ���� ��¥ �������� �ٹ��ϼ�(�Ҽ���2�� �ݿø�)�� ���
SELECT EMPNO �����ȣ, ENAME �����, HIREDATE �Ի���, ROUND(SYSDATE-HIREDATE , 2) �ٹ��ϼ� FROM EMP;

-- ROUND ���� : ROUND(���¥, ����)
SELECT HIREDATE, ROUND (HIREDATE, 'MONTH')  FROM EMP; 

-- TRUNC ���� : TRUNC(���¥, ����)
SELECT HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP;

-- MONTHS_BETWEEN : ��¥ ������ ���� �� ����
-- ���� : MONTHS_BETWEEN(��¥1, ��¥2)0

-- ���� ��¥ ���� ������� �ٹ����� ���ϰ�, �ٹ����� ���� �������� ����
SELECT EMPNO �����ȣ, ENAME �����, HIREDATE �Ի���, FLOOR(MONTHS_BETWEEN(SYSDATE,HIREDATE)) �ٹ�����, FLOOR(SYSDATE-HIREDATE) �ٹ��ϼ� FROM EMP ORDER BY �ٹ����� DESC;

-- ADD_MONTHS : ���� �� �߰�
-- �Ի��� �������� 6���� �� ��¥ ���
SELECT HIREDATE �Ի���, ADD_MONTHS(HIREDATE,6) �Ի���2 FROM EMP;

-- NEXT_DAY : ���Ͽ� �´� ��¥ ��ȯ
-- ���� ��¥ �������� ���� ������� ��¥�� ���
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�����') FROM DUAL;

-- LAST_DAY : �ش� ���� ������ ��¥ ��ȯ
-- �Ի�� �������� ������ ��¥ ���
SELECT HIREDATE, LAST_DAY(HIREDATE) FROM EMP;


/**
  ����ȯ �Լ� : TO_CHAR, TO_DATE, TO_NUMBER
*/
-- TO_CHAR
SELECT SYSDATE, TO_CHAR(SYSDATE,'YYYY-MM-DD, HH24:MI:SS') FROM DUAL;

-- �Ի��� ��� ������ '��-��-��' �������� ��ȯ�Ͽ� ���
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY.MM.DD') FROM EMP;
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;

-- TO_CHAR : ���� -->����
-- �޿��� 3�ڸ��� �����Ͽ� ���
SELECT EMPNO,TO_CHAR(SAL, 'L000,000')   SAL, TO_CHAR(SAL, 'L999,999') SAL FROM EMP;
SELECT TO_CHAR(123456, '000,000,000'), TO_CHAR(123456, '999.999.999') FROM EMP;

-- TO_DATE : ���� --> ��¥
SELECT '2019/01/01', TRUNC(SYSDATE-TO_DATE('2019/01/01','YYYY/MM/DD')) RESULT FROM DUAL;

-- TO_NUMBER : ���� --> ����
SELECT TO_CHAR(TO_NUMBER('20,000','99,999')-TO_NUMBER('10,000','99,999'), '999,999') FROM DUAL;

-- NVL : NULL -->����
-- ���糯¥�� �������� �ٹ������ ���� �� Ŀ�̼��� ���Ͽ� �μ�Ƽ�긦 ���
-- Ŀ�̼� ����Ʈ�� 100, �޿��� �μ�Ƽ��� ��ȭ��ȣ�� 3�ڸ� ����

SELECT EMPNO �����ȣ, ENAME �����, TO_CHAR(SAL,'L999,999') �޿�, TRUNC((SYSDATE-HIREDATE)/365) �ٹ���� ,NVL(COMM,100) Ŀ�̼�, TO_CHAR(TRUNC((SYSDATE-HIREDATE)/365)*NVL(COMM,100), 'L999,999') �μ�Ƽ�� FROM EMP;

-- DECODE : ���ǿ� �´� �����͸� �ٲ� �� ����
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING',
                                     20, 'RESEARCH', 
                                     30, 'SALES', 
                                     40, 'OPERATIONS') DNAME
FROM EMP;

-- ���޿� ���� �޿��� �λ�
-- ������ 'ANALYST'�� ����� 5%, 'SALESMAN'�� ����� 10%,
-- 'MANAGER'�� ����� 15%, 'CLERK'�� ����� 20%�λ��Ѵ�.

SELECT ENAME �����, JOB ����, SAL ����޿�, FLOOR(NVL(DECODE(JOB, 'ANALYST', SAL+(SAL*0.05),
                                    'SALESMAN', SAL+(SAL*0.1),
                                    'MANAGER', SAL+(SAL*0.15),
                                    'CLERK', SAL+(SAL*0.2)),0)) �λ�޿�
FROM EMP;                                
-- CASE ~WHEN~THEN ~END : ���ǿ� �´� ������ ��ȸ(IF~ELSE IF~ELSE)
-- CASE~WHEN~THEN~ELSE~END
-- �μ���ȣ�� �̿��Ͽ� �μ��� ���
SELECT EMPNO, ENAME, DEPTNO,
        CASE WHEN DEPTNO =10 THEN 'ACCOUNTING'
             WHEN DEPTNO =20 THEN 'RESEARCH'
             WHEN DEPTNO =30 THEN 'SALES'
             WHEN DEPTNO =40 THEN 'OPERATIONS'
        END AS DNAME
FROM EMP;

-- ���޿� ���� �޿��� �λ�
-- ������ 'ANALYST'�� ����� 5%, 'SALESMAN'�� ����� 10%,
-- 'MANAGER'�� ����� 15%, 'CLERK'�� ����� 20%�λ��Ѵ�.
SELECT ENAME �����, JOB ����, SAL ����޿�, 
        CASE WHEN JOB = 'ANALYST' THEN SAL+SAL*0.05
             WHEN JOB = 'SALESMAN' THEN SAL+SAL*0.1
             WHEN JOB = 'MANAGER' THEN SAL+SAL*0.15
             WHEN JOB = 'CLERK' THEN SAL+SAL*0.2
             ELSE 0
        END AS UPSAL
FROM EMP;
-- ROWNUM(ROW�� ���� - INDEX����)
SELECT ROWNUM , EMPNO, ENAME, RPAD(JOB,9,' '), MGR, TO_CHAR(HIREDATE, 'YYYY/MM/DD'), SAL, NVL(COMM,0), DEPTNO FROM EMP;

/**
  ���̺��� ���� ����, ����, ����, ����
*/

-- CREATE TABLE : ���̺��� ���� ���� �� ����
-- ���� : CREATE TABLE ���̺��( �÷��� ������ Ÿ��,....); 

-- �������� - VARCHAR2(size) (������ ���� ������)

-- ROWID ���
SELECT ROWID, EMPNO FROM EMP;

-- CREATE TAWBLE : ���̺��� ���� ���� �� ����
-- ���� : CREATE TABLE ���̺��(�÷��� ������ Ÿ��,....);

-- ���̺� ���� : EMP01 ���̺� �̸����� EMPNO, ENAME, SAL Į��
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
  ��������(SELECT) �� ���� ���̺� ����
*/

-- SELECT ����� �̿��Ͽ� EMP ���̺��� ��� Į���� EPM02 ���̺�� ����
CREATE TABLE EMP02 
AS
SELECT * FROM EMP;

SELECT * FROM USER_TABLES WHERE TABLE_NAME='EMP02';
DESC EMP02;
SELECT * FROM EMP01;
SELECT * FROM EMP02;

-- EMP ���̺��� �����ȣ, ����� �����Ͽ� EMP03���̺� ����
CREATE TABLE EMP03
AS
SELECT EMPNO, ENAME FROM EMP;

SELECT * FROM USER_TABLES WHERE TABLE_NAME='EMP03';
DESC EMP03;

-- EMP���̺��� �����ȣ, �����, �޿�, ���� �÷����� EMP04 ���̺�� ����
CREATE TABLE EMP04
AS
SELECT EMPNO �����ȣ, ENAME �����, SAL �޿�, SAL*12 ���� FROM EMP;

SELECT * FROM USER_TABLES WHERE TABLE_NAME='EMP04';
SELECT * FROM EMP04;
DESC EMP04;

-- EMP���̺��� �����ȣ, �����, �޿�, ����, �Ի��� �÷����� EMP04_1 ���̺�� ����
-- EMP04_1 ���̺�� ����(�޿�, ������ ��ȭ��ȣ ���� 3�ڸ� ����, �Ի��� ������ YYYY/MM/DD ����)
CREATE TABLE EMP04_1
AS
SELECT  EMPNO �����ȣ, ENAME �����, TO_CHAR(SAL, 'L999,999')  �޿�, TO_CHAR(SAL*12, 'L999,999') ���� , TO_CHAR(HIREDATE , 'YYYY/MM/DD') �Ի��� 
FROM EMP;

SELECT * FROM USER_TABLES WHERE TABLE_NAME='EMP04_1';
SELECT * FROM EMP04_1;

-- EMP ���̺��� 30�� �μ��� ���ϴ� ������� EMP05 ���̺�� ����
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP05';

CREATE TABLE EMP05
AS
SELECT * FROM EMP
WHERE DEPTNO=30;

SELECT * FROM EMP05;

-- EMP ���̺��� ������ �����Ͽ� EMP06 ���� : WHERE 1=0;

-- WHERE 1=1; ���� ����;
-- WHERE 1=0; WHERE 1=0; ������ �׻� �����Դϴ�. �����̶� ������ ���� �� �� ����

SELECT * FROM EMP;
DESC EMP;

CREATE TABLE EMP06
AS
SELECT * FROM EMP
WHERE 1=0;

SELECT * FROM EMP06;

-- DEPT ���̺�� ���� ������ �� ���̺� DEPT02 ����
CREATE TABLE DEPT02
AS
SELECT * FROM DEPT WHERE 1=0;
SELECT * FROM DEPT02;

CREATE TABLE EMP04_2
AS
SELECT  EMPNO �����ȣ, ENAME �����, TO_CHAR(SAL, 'L999,999')  �޿�, TO_CHAR(SAL*12, 'L999,999') ���� , TO_CHAR(HIREDATE , 'YYYY/MM/DD') �Ի��� 
FROM EMP
WHERE 1=0;

SELECT * FROM EMP04_2;


/**
  ���̺���� : ALTER TABLE
  - ADD( �÷��� Ÿ��, ...)
  - MODIFY(�÷��� Ÿ��, ...)
  - DROP COLUMN(�÷��� Ÿ��,...)
*/

--EMP01 ���̺� JOB�÷� �߰�

-- EMP01 ���̺� Ȯ��
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP01';
-- EMP01 ���̺� ���� Ȯ��
DESC EMP01;
-- JOB Į�� �߰�
ALTER TABLE EMP01
ADD (JOB VARCHAR2(9));

-- EMP01 ���̺��� JOB �÷� ������ 30���� ����
ALTER TABLE EMP01
MODIFY JOB VARCGAR2(30);

/**
  ���̺� ���� :DROP TABLE ���̺��;
*/

-- EMP01 ���̺� ����
DROP TABLE EMP01;
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP01';

/**
  ���̺��� �ο� ���� : TRUNCATE TABLE ���̺��; -- �����Ұ���(����)
*/
--EMP02 ���̺��� ��ü �� ��� ����
SELECT * FROM USER_ALTERS WHERE TABLE_NAME='EMP02';
SELECT * FROM EMP02;
TRUNCATE TABLE EMP02;

/**
  ���̺�� ġȯ : RENAME ���� ���̺�� TO ���ο� ���̺��
*/

-- EMP02���̺��� �̸��� TEST�� ġȯ
SELECT* FROM USER_TABLES WHERE TABLE_NAME ='EMP02';
RENAME EMP02 TO TEST;
SELECT *FROM USER_TABLES WHERE TABLE_NAME='TEST';

SELECT * FROM USER_TABLES;
SELECT COUNT(*) FROM ALL_TABLES; --84
SELECT COUNT(*) FROM DBA_TABLES; -- ���� �Ұ���

/**
  ������ �߰� : INSERT
  ���� : INSERT INTO ���̺��(Į������Ʈ) VALUES(Į����,...);
*/
-- DEPT01 ���̺� ����
SELECT * FROM USER_TABLES WHERE TABLE_NAME ='DEPT01';
DROP TABLE DEPT01;

-- DEPT ���̺��� ������ �����Ͽ� DEPT01 ����
CREATE TABLE DEPT01
AS
SELECT * FROM DEPT WHERE 1=0;

DESC DEPT01;

-- DEPT01 ������ �߰� , 10, ACCOUNTING, NEW YORK
INSERT INTO DEPT01(DEPTNO, DNAME, LOC) VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01(DEPTNO, DNAME, LOC) VALUES(20, 'SALES', 'SEOUL');
INSERT INTO DEPT01(LOC,DNAME, DEPTNO) VALUES('BUSAN', 'MANAGER', 30);
SELECT * FROM DEPT01;

-- �ڵ����� ������ �ȵǾ������� commit ���־�� db�� �ݿ��� �Ǿ�����.
COMMIT;

-- DICTIONALRY
SELECT *FROM USER_TABLES WHERE TABLE_NAME ='SAM01';

--EMP ���̺��� EMPNO, ENAME, JOB, SAL �÷� ������ �����Ͽ� SAM01 ���̺� ����
CREATE TABLE SAM01
AS
SELECT EMPNO, ENAME, JOB, SAL 
FROM EMP 
WHERE 1=0;

INSERT INTO SAM01(EMPNO, ENAME, JOB, SAL) VALUES(1000, 'APPLE', 'POLICE', NULL);
INSERT INTO SAM01(EMPNO, ENAME, JOB, SAL) VALUES(1010, 'BANANA', NULL, 15000);
INSERT INTO SAM01(EMPNO, ENAME, JOB, SAL) VALUES(1020, 'ORANGE', NULL, NULL);
INSERT INTO SAM01(EMPNO, ENAME, JOB, SAL) VALUES(NULL, NULL, NULL, NULL);

-- NOT NULL ������ ���� ���̺� ����

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
  ������(SEQUENCE) : �ڵ���ȣ ������ --> PK(Primary key) 
*/
-- ������ Ȯ��
SELECT * FROM USER_SEQUENCES;

-- ������ ����
CREATE SEQUENCE SEQU_EMP01
  START WITH 1
  INCREMENT BY 1
;

-- EMP ���̺��� EMPNO, ENAME, DEPTNO ������ �����Ͽ� EMP01 ����
CREATE TABLE EMP01
AS
SELECT EMPNO, ENAME, DEPTNO FROM EMP WHERE 1=0;

SELECT * FROM EMP01;

-- �������� �̿��Ͽ� ������ �߰��ϱ�

INSERT INTO EMP01 VALUES (SEQU_EMP01.NEXTVAL ,'SMITH',10); 
INSERT INTO EMP01 VALUES (SEQU_EMP01.NEXTVAL ,'SCOTT',20); 

-- EMP01 ������ ��ü ����
TRUNCATE TABLE EMP01;
SELECT * FROM EMP01;

-- SEQU_EMP01.NEXTVAL ���� 3���� ���´�. 1,2�� ���������� 1�� �ƴ϶� 3���� ������.****
INSERT INTO EMP01 VALUES (SEQU_EMP01.NEXTVAL ,'SMITH',10); 

-- ������ ����
DROP SEQUENCE SEQU_EMP01;
SELECT * FROM USER_SEQUENCES;


-- 1000���� ���� 1�� �����ϴ� �������� SEQU_EMP01 �̸����� �����ϰ�, EMP01 ���̺��� �����ȣ �÷��� �����Ͽ� INSERT
SELECT * FROM USER_SEQUENCES;
CREATE SEQUENCE SEQU_EMP01
  START WITH 1000
  INCREMENT BY 1
;

SELECT * FROM EMP01;
INSERT INTO EMP01 VALUES(SEQU_EMP01.NEXTVAL, 'SMITH', 10);
-- ROWNUM 
SELECT ROWNUM, EMPNO, ENAME, DEPTNO FROM EMP01;

-- STU ���̺� ����
-- SNO �й�,NAME �̸�,KOR ����,ENG ����,MATH ����,TOT ����,AVG ���

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

/**08/20 ���������� Ȱ���� insert */
-- DEPT ���̺� ������ ������ DEPT02 ���̺� ����
SELECT * FROM USER_TABLES WHERE TABLE_NAME= 'DEPT02';
DROP TABLE DEPT02;

CREATE TABLE DEPT02
AS
SELECT * FROM DEPT WHERE 1=0;

-- DEPT ���̺��� �����͵��� DEPT02�� �߰� (���������� ����)
 
INSERT INTO DEPT02 SELECT * FROM DEPT;
SELECT * FROM DEPT02;

-- SAM01
SELECT*FROM USER_TABLES WHERE TABLE_NAME = 'SAM01';
SELECT*FROM SAM01;

--EMP ���̺��� 10�� �μ��� �ִ� ������� SAM01�� �߰� (�÷������ ���� �ؾ� �Ѵ�.)
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO = 10;

SELECT * FROM EMP;

-- EMP ���̺��� EMPNO, ENAME, HIREDATE �÷��� ������ �����Ͽ� EMP_HIR ���̺� ����
-- 1�ܰ� : ���̺� Ȯ��
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


-- �ѹ��� ������ �ְ� INSERT �ϱ�
INSERT ALL
WHEN HIREDATE >'81/06/30' THEN
INTO EMP_HIR02 VALUES(EMPNO, ENAME, HIREDATE)
WHEN SAL > 2000 THEN
INTO EMP_SAL VALUES(EMPNO, ENAME, SAL)
SELECT EMPNO, ENAME, HIREDATE ,SAL FROM EMP;

SELECT * FROM EMP_HIR02;
SELECT * FROM EMP_SAL;

/**
  ������ ���� : UPDATE
  ���� : UPDATE ���̺�� SET �÷��� = ��, ... WHERE ������;
*/

-- EMP01 ���̺��� ��� �μ���ȣ�� 30������ ����
SELECT * FROM USER_TABLES WHERE TABLE_NAME ='EMP01';
SELECT * FROM EMP01;

UPDATE EMP01 SET DEPTNO =30;

-- INSERT �� ���ο� ROW �߰�, UPDATE�� ������ ROW �����Ҷ� ��� !!!!!!!!!!!
-- EMP01 ���̺� SAL �÷� �߰� - 
ALTER TABLE EMP01
ADD (SAL NUMBER(6,2));

-- �⺻ �޿��� 1000���� UPDATE �� ��� ����� �޿��� 10% �λ� ����
UPDATE EMP01 SET SAL = 1000; 
UPDATE EMP01 SET SAL = SAL*1.1;
SELECT * FROM EMP01;

-- EMPNO�� 1004���� ����� �޿��� 30% �λ�
UPDATE EMP01 SET SAL = SAL*1.3 WHERE EMPNO=1004;

COMMIT;

-- EMP_HIR ���̺��� �Ի��� �� 81/06/30 ���Ŀ� �Ի��� ������� ��¥�� ���� ��¥�� ����
SELECT * FROM EMP_HIR;
UPDATE EMP_HIR SET HIREDATE = SYSDATE WHERE HIREDATE > '81/06/30';

-- EMP01 ���̺��� �����ϰ�, EMP ���̺��� �����Ͽ� EMP01 ����
DROP TABLE EMP01;
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP01';
CREATE TABLE EMP01
AS
SELECT*FROM EMP;

--SMITH ����� �μ���ȣ�� 30������ , ������ MANAGER�� ����
SELECT * FROM EMP01;
UPDATE EMP01 SET DEPTNO = 30, JOB = 'MANAGER' WHERE ENAME = 'SMITH';

-- 81�⿡ �Ի��� ������� �μ���ȣ�� 50������, ������ SALESMAN���� ����
SELECT COUNT(*) FROM EMP01 WHERE SUBSTR(HIREDATE, 1,2) = 81;
UPDATE EMP01 SET DEPTNO = 50, JOB = 'SALESMAN' WHERE SUBSTR(HIREDATE, 1,2) =81;

-- EMP01 ���̺��� Ŀ�̼��� NULL �� ������� �μ��� 20������ ����
UPDATE EMP01 SET DEPTNO =20 WHERE COMM IS NULL;

-- EMP01 ���̺� LOC �÷� �߰�
DESC EMP01;
ALTER TABLE EMP01 ADD(LOC VARCHAR2(13));


-- 20�� �μ��� �������� 40�� �μ��� ���������� �����ϱ� ���ؼ� ���� ���� ���� ����� ���ô�.
SELECT * FROM EMP01;
SELECT * FROM DEPT;

UPDATE EMP01
SET LOC = (SELECT LOC FROM DEPT WHERE DEPTNO =20)
WHERE DEPTNO = 20;

/**
  ������ ���� : DELETE
  ���� : DELETE FROM ���̺�� WHERE ������;
*/

-- DEPT01 ���̺��� ��� �� ����
SELECT* FROM USER_TABLES WHERE TABLE_NAME = 'DEPT01';
SELECT * FROM DEPT01;
DELETE FROM DEPT01;

-- EMP01 ���̺��� 50�� �μ� ����
SELECT COUNT(*) FROM EMP01 WHERE DEPTNO = 50; --4
DELETE FROM EMP01 WHERE DEPTNO = 50;
SELECT *FROM EMP01;


-- SAM01 ���̺��� ��� ��ȣ�� 3000�̰�, ������ �������� ���� ������ ����
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'SAM01';
SELECT * FROM SAM01;

DELETE FROM SAM01 WHERE EMPNO =1020 AND JOB IS NULL;

/** ���������� ( ~~ ) �߰�ȣ �ȿ� �ۼ� */

-- SAM01 ���̺��� �����ȣ�� 1000�� ������� ������ ������ ����� EMP01 ���̺��� ����
DELETE FROM EMP01 WHERE SAL < ( SELECT SAL FROM SAM01 WHERE EMPNO = 1000 );

-- MERGE
-- EMP ���̺� ���� �� ����
DROP TABLE EMP01;
SELECT * FROM USERT_TABLES WHERE TABLE_NAME ='EMP01';
CREATE TABLE EMP01
AS
SELECT * FROM EMP;
SELECT * FROM EMP01;

-- EMP ���̺��� ������ MANAGER�� ����鸸 �����ؼ� EMP02 ����
CREATE TABLE EMP02 
AS 
SELECT * FROM EMP WHERE JOB = 'MANAGER';
SELECT * FROM EMP02;

-- EMP02 ���̺��� JOB�� TEST�� ����
UPDATE EMP02 SET JOB = 'TEST';

-- EMP02 ���̺� ���ο� ������ �߰�
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

-- UPDATE ���̺�� SET �÷��� = ��, ... WHERE ������;
update stu set sname = 'ȫȫ', skor = 100, seng = 90, smath = 80 where sno = 'st-0001';

/**
  ����(join) : ���� ���̺� ���� - ���ϱ�
*/
-- cross join ����� ������ �ϳ��� ������ ���Ѵ�.
select * from emp;
select * from dept;
select * from emp cross join dept;
select count(*) from emp, dept;
select count(*) from emp cross join dept;

-- Equi Joj


SELECT * FROM EMP;
SELECT * FROM DEPT;
-- ���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ����ϼ���.
SELECT ENAME, SAL FROM EMP, DEPT WHERE LOC = 'NEW YORK';


SELECT ENAME, SAL FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND LOC = 'NEW YORK';


-- ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, HIREDATE FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND DEPT.DNAME = 'ACCOUNTING';

-- ������ MANAGER�� ����� �̸�, �μ����� ����ϼ���.
SELECT ENAME, DNAME FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND JOB= 'MANAGER';\

--���� ��ɾ�� ���̺� ���� ������ �������? �� �ٵ� ������ 

-- ������ MANAGER�� ����� �����ȣ, �̸�, �޿�, �μ���, �޿������ ���\
SELECT * FROM SALGRADE;
SELECT EMPNO, ENAME, SAL, DNAME, GRADE 
FROM EMP, DEPT, SALGRADE
 -- EQUI ����  EMP.DEPTNO = DEPT.DEPTNO �� �� �־�� �Ѵ�.
WHERE EMP.DEPTNO = DEPT.DEPTNO 
  AND SAL BETWEEN LOSAL AND HISAL 
  AND JOB = 'MANAGER';
 
 --SELF JOIN
 SELECT * 
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO;

-- SMITH ����� �Ŵ��� �̸��� ������ּ���.
SELECT E1.ENAME, E2.ENAME
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO
AND E1.ENAME ='SMITH';

-- SMITH ����� �Ŵ��� �̸��� ���(��������)
SELECT ENAME ���
FROM EMP
WHERE EMPNO = (SELECT MGR FROM EMP WHERE ENAME ='SMITH');

-- BLAKE ����� �����ϴ� �Ĺ� ������� ������ּ���(��������)

-- ���� ���ǿ� �������� ���Ͽ����� �ش� �ο츦 ��Ÿ���� ���� ���� ����ϴ� ���� �ܺ� ����(Outer Join)
-- OUTER JOIN        (+) 
SELECT * FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- 40����  EMP�� ������� �ʾƼ� ����� �ȵȴ�.
SELECT* FROM DEPT;

-- EMP.DEPTNO �� NULL�� �߱� ������ NULL�� �ߴ� �ڸ��� (+) �� �־��ָ� �ȴ�. 

SELECT * FROM EMP, DEPT
WHERE EMP.DEPTNO(+) = DEPT.DEPTNO;

-- ���� ������ ���� FROM �� - EMP (����) DEPT - (RIGHT) DEPT �������� 
-- ANSI SQL 
SELECT * 
FROM EMP RIGHT OUTER JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO;

SELECT * FROM EMP, DEPT
WHERE EMP.DEPTNO(+) = DEPT.DEPTNO;


-- EMP ���̺��� ����߿��� 30�� �μ��� ���ϴ� ������� 
-- �����ȣ, �����, �޿�, �μ���ȣ, �μ����� �����͸� �����Ͽ� EMP9 ����

CREATE TABLE EMP9
AS
SELECT EMPNO, ENAME, SAL , E.DEPTNO, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.DEPTNO = 30;

SELECT * FROM EMP9;

-- EMP ���̺��� ����߿��� 30�� �μ��� ���ϴ� ����� ��
-- �Ի����� 81�� �Ϲݱ� �Ի��� ����
-- �����ȣ, �����, �޿�, �μ���ȣ, �μ����� �����͸� �����Ͽ� EMP10 ����
CREATE TABLE EMP10
AS
SELECT EMPNO, ENAME, SAL, E.DEPTNO, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.DEPTNO = 30
AND HIREDATE > '81/06/30'; 

SELECT * FROM EMP10;

-- EMP9 (6) ���̺�� EMP10(3) ���̺� CROSS JOIN (6*3 = 18)
SELECT * FROM EMP9, EMP10;
SELECT * FROM EMP9 CROSS JOIN EMP10;

-- EMP9 ���̺�� EMP10 ���̺� EQUI JOIN
SELECT * FROM EMP9, EMP10
WHERE EMP9.EMPNO = EMP10.EMPNO;

-- EMP9 ���̺�� EMP10 ���̺��� EMP9 �������� OUTER JOIN : 6
SELECT * FROM EMP9, EMP10
WHERE EMP9.EMPNO = EMP10.EMPNO(+);

-- EMP10 ���̺�� EMP9 ���̺��� EMP9 �������� OUTER JOIN : 3
SELECT * FROM EMP9, EMP10
WHERE EMP9.EMPNO(+) = EMP10.EMPNO;

COMMIT;
/**
  �������� : ���������� �������� ���ԵǾ� ������ ���� �����ϴ� ���� 
*/
-- SMITH ����� ���� �μ��� �ٹ��ϴ� ������� ���
SELECT * FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SMITH');


-- 7369�� ��� ��ȣ�� ���� ����� ���� �μ��� �ٹ��ϴ� ������� ���
SELECT * FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE EMPNO = '7369');

-- 7902 ����� �����ϴ� ����� ���� �μ��� �ٹ��ϴ� ������� ���
SELECT * FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE EMPNO =(SELECT EMPNO FROM EMP  WHERE MGR='7902'));

-- SMITH �� ������ ������ ���� ����� ���
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SMITH');
-- SMITH �� �޿��� �����ϰų� �� ���� �޴� ����� �Ť��� �޿��� ���
SELECT ENAME, SAL FROM EMP WHERE SAL >= (SELECT SAL FROM EMP WHERE ENAME ='SMITH');
SELECT * FROM EMP;
SELECT * FROM DEPT WHERE LOC = 'DALLAS';
-- DALLAS ���� �ٹ��ϴ� ����� �̸�, �μ� ��ȣ�� ���
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

SELECT E1.ENAME, E1.DEPTNO FROM EMP E1, DEPT D WHERE E1.DEPTNO = D.DEPTNO AND D.LOC = 'DALLAS';

-- SALES �μ����� �ٹ��ϴ� ��� ����� �̸��� �޿��� ���
SELECT ENAME, SAL FROM EMP WHERE DEPTNO= (SELECT DEPTNO FROM DEPT WHERE DNAME ='SALES');
SELECT ENAME, SAL FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND DNAME = 'SALES';

--���� ����� KING�� ����� �̸��� �޿��� ���
SELECT * FROM EMP;
SELECT ENAME, SAL FROM EMP WHERE MGR =(SELECT EMPNO FROM EMP WHERE ENAME='KING');

SELECT E1.ENAME, E1.SAL FROM EMP E1, EMP E2 WHERE E1.MGR = E2.EMPNO AND E2.ENAME='KING';

-- ��� �޿����� �޿��� ���� ����� ���
SELECT * FROM EMP WHERE SAL >(SELECT AVG(SAL) FROM EMP);

SELECT DISTINCT DEPTNO FROM EMP ; -- �������� ��� -> ������
SELECT DISTINCT DEPTNO FROM EMP WHERE ENAME ='SMITH'; --> ������ ��� = ������

-- ������ �������� : ���������� ����� ���������� ��� 
-- 3000 �̻� �޴� ����� �Ҽӵ� �μ�(10��, 20��)�� ������ �μ����� �ٹ��ϴ� ��� ���
SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL >=3000);

-- �μ� ��(GROUP BY �Լ�)
-- �μ����� ���� �޿��� ���� �޴� ����� ����
--(��� ��ȣ, ����̸�, �޿� , �μ� ��ȣ) �� ����Ͻÿ� (IN ������)
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE SAL IN(SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ���ȣ, �μ���, ������ ���
SELECT DEPTNO, DNAME, LOC FROM DEPT WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');

SELECT SAL FROM EMP WHERE DEPTNO = 30;

-- '> ALL ' : MAX() - ��� �񱳰� ���� �� ū ������ ��
-- 30�� �Ҽ� ����� �߿��� �޿��� ���� ���� �޴� ������� �� ���� �޿��� �޴� �����
-- �̸�, �޿��� ����ϴ� �������� �ۼ�

SELECT ENAME, SAL FROM EMP 
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30);

SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);

-- ���� ������ �ٲܼ� �ִ°��� ����غ����Ѵ� !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

-- '> ANY : MIN()'
-- 30�� �Ҽ� ����� �߿��� �޿��� ���� ���� �޴� ������� �� ���� �޿��� �޴� �����
-- �̸�, �޿��� ����ϴ� �������� �ۼ�
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


-- ������ ��ųʸ�  ���� Ȯ��

DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;
--  � Į���� � ���� �� ���� �����Ǿ����� �˷��ִ� ������ ��ųʸ�
SELECT * FROM USER_CONS_COLUMNS;

-- NOT NULL : �����Ͱ� �ݵ�� �ʿ��� �÷��� ���� ����
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'EMP01';
DROP TABLE EMP01;

CREATE TABLE EMP01(
  EMPNO NUMBER(4) NOT NULL,
  ENAME VARCHAR2(20) NOT NULL,
  HIREDATE DATE,
  SAL NUMBER(6,2)
);

SELECT * FROM EMP01;

--EMP01 ���̺��� ������� Ȯ��
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME ='EMP01';
-- C = CHECK OR NOT NULL 

SELECT * FROM USER_CONS_COLUMNS
WHERE TABLE_NAME = 'EMP01';

INSERT INTO EMP01(EMPNO, ENAME, HIREDATE,SAL)
VALUES(1000, 'HONG', SYSDATE, 100);

INSERT INTO EMP01(EMPNO, ENAME, HIREDATE,SAL)
VALUES(1000, 'ȫ�浿', NULL, 100);

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

INSERT INTO EMP02 VALUES(1000, 'ȫ�浿', 100);
INSERT INTO EMP02 VALUES(2000, 'ȫ�浿', 100);
INSERT INTO EMP02 VALUES(NULL, 'ȫ�浿', 100);
INSERT INTO EMP02 VALUES(NULL, NULL, 100);
-- NULL�� �ߺ�üũ���� �����̴�.!!!!!!! UNIQUE �� ��������� NULL�� ���ܵȴ�. 
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

INSERT INTO EMP03 VALUES(1000,'ȫ�浿',100);
INSERT INTO EMP03 VALUES(1001,'ȫ�浿',100);


--����� ����
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