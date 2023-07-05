CREATE TABLE "SCOTT"."MEMBER4" 
   (	ID VARCHAR2(100) PRIMARY KEY, 
	PW VARCHAR2(100), 
	NAME VARCHAR2(100), 
	TEL VARCHAR2(100), 
	TEAM DATE, - - 나중에 sysdate를 넣을 항목
	COMPANY VARCHAR2(100) DEFAULT 'multi' NOT NULL, 
	LOCATION VARCHAR2(100) UNIQUE 
)

CREATE TABLE productorder (
	id varchar2(100) PRIMARY KEY, -- NOT NULL, UNIQUE
	title varchar2(100) UNIQUE,
	price NUMBER, -- int
	buydate DATE, -- now(), sysdate
	addr varchar2(100) DEFAULT 'home' NOT NULL
)

INSERT INTO PRODUCTORDER(id, BUYDATE, addr) VALUES ('100', sysdate, 'office')

INSERT INTO PRODUCTORDER(id, title, BUYDATE) VALUES ('200', 'hat', sysdate)

INSERT INTO PRODUCTORDER(id, title, BUYDATE) VALUES ('300', 'mouse', sysdate)

SELECT * FROM PRODUCTORDER 

-- ----------------------------------
SELECT DISTINCT deptno FROM emp

SELECT DISTINCT job FROM emp


SELECT ename, sal * 12 AS "yearsal" FROM emp 

SELECT ename, job, sal FROM emp ORDER BY sal --default asc(오름차순)

SELECT ename, job, sal FROM emp ORDER BY sal DESC 


SELECT * FROM emp WHERE comm IS NOT NULL

CREATE TABLE "SCOTT"."MEMBER9" 
   (	"ID" VARCHAR2(100) NOT NULL ENABLE, 
	"PW" VARCHAR2(100) NOT NULL ENABLE, 
	"NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"TEL" VARCHAR2(100)
	)

