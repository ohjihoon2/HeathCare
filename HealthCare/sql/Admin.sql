
-- ��üȸ�� ���(������ ����)
select cno, name, gender, phone, TO_CHAR(birth_date, 'MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr from member where division =1;

-- ȸ�� �˻��ϱ�
select cno, name, gender, phone, TO_CHAR(birth_date, 'MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr from member where cno = 1004;

-- ȸ�� ����

-- ȸ�� ����

-- ���� ����

-- ���� ����