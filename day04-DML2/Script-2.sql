use school

create table member2 (
	id varchar(10),
	id2 varchar(10),
	id3 varchar(10)
)

CREATE TABLE BONUS

(

ENAME VARCHAR(10),

JOB VARCHAR(9),

SAL int(11),

COMM int(11)

)


CREATE TABLE DEPT

(

DEPTNO int(2),

DNAME VARCHAR(14),

LOC VARCHAR(13)

)



CREATE TABLE EMP

(

EMPNO int(11),

ENAME VARCHAR(10),

JOB VARCHAR(9),

MGR int(11),

HIREDATE DATE,

SAL int(11),

COMM decimal(7,2),

DEPTNO int(2)

)




CREATE TABLE SALGRADE

(

GRADE int(11),

LOSAL  int(11),

HISAL  int(11)

)





CREATE UNIQUE INDEX PK_DEPT ON DEPT

(DEPTNO)




CREATE UNIQUE INDEX PK_EMP ON EMP

(EMPNO)




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

