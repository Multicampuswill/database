-- oracle 
-- 테이블명 member
CREATE TABLE MEMBER (
	id varchar2(10), -- mysql -> varchar
	pw varchar2(10), -- varchar, varchar2 -> String
	name varchar2(10),
	tel varchar2(10)
)




SELECT * FROM tab -- oracle

-- 컨트롤 + 엔터(실행)
-- 한줄복사 컨트롤 + 알트 + 화살표 아래
INSERT INTO MEMBER VALUES ('100','100','park','011')

INSERT INTO MEMBER VALUES ('200','200','park','011')

INSERT INTO MEMBER VALUES ('300','300','park','011')

-- 3명의 현재 회원가입되어 있는 상태
-- 한 명당 가로줄로 한줄(행) 저장 ==> 레코드

SELECT * FROM MEMBER

insert into "MEMBER" values ('111','100','park','011')













CREATE USER scott identified BY tiger -- scott/tiger 

GRANT CONNECT, resource, dba TO scott

CREATE TABLE test (
	id varchar2(10),
	pw varchar2(10)
)

CREATE TABLE BONUS

(

ENAME VARCHAR2(10 BYTE),

JOB VARCHAR2(9 BYTE),

SAL NUMBER,

COMM NUMBER

)

LOGGING

NOCOMPRESS

NOCACHE

NOPARALLEL

MONITORING;




CREATE TABLE DEPT

(

DEPTNO NUMBER(2),

DNAME VARCHAR2(14 BYTE),

LOC VARCHAR2(13 BYTE)

)

LOGGING

NOCOMPRESS

NOCACHE

NOPARALLEL

MONITORING;




CREATE TABLE EMP

(

EMPNO NUMBER(4),

ENAME VARCHAR2(10 BYTE),

JOB VARCHAR2(9 BYTE),

MGR NUMBER(4),

HIREDATE DATE,

SAL NUMBER(7,2),

COMM NUMBER(7,2),

DEPTNO NUMBER(2)

)

LOGGING

NOCOMPRESS

NOCACHE

NOPARALLEL

MONITORING;




CREATE TABLE SALGRADE

(

GRADE NUMBER,

LOSAL NUMBER,

HISAL NUMBER

)

LOGGING

NOCOMPRESS

NOCACHE

NOPARALLEL

MONITORING;




CREATE UNIQUE INDEX PK_DEPT ON DEPT

(DEPTNO)

LOGGING

NOPARALLEL;




CREATE UNIQUE INDEX PK_EMP ON EMP

(EMPNO)

LOGGING

NOPARALLEL;




ALTER TABLE DEPT ADD (

CONSTRAINT PK_DEPT

PRIMARY KEY

(DEPTNO));

 

ALTER TABLE EMP ADD (

CONSTRAINT PK_EMP

PRIMARY KEY

(EMPNO));

 

ALTER TABLE EMP ADD (

CONSTRAINT FK_DEPTNO

FOREIGN KEY (DEPTNO)

REFERENCES DEPT (DEPTNO));

 
SELECT tel, id, name FROM MEMBER

SELECT tel, id, name FROM MEMBER WHERE id = '400'














-- SCOTT."MEMBER" definition

CREATE TABLE MEMBER3 
   (	ID VARCHAR2(100) NOT NULL, 
	PW VARCHAR2(100) NOT NULL , 
	NAME VARCHAR2(100) NOT NULL , 
	TEL VARCHAR2(100), 
	 CONSTRAINT "MEMBER_PK3" PRIMARY KEY (ID)
	)














