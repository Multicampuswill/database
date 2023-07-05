-- 2.

SELECT * FROM PRODUCT 
ORDER BY price DESC

-- 3.

SELECT NAME, CONTENT, PRICE, COMPANY 
FROM PRODUCT 
ORDER BY COMPANY 

-- 4. 

SELECT DISTINCT COMPANY 
FROM PRODUCT 

-- 5. 

SELECT price * 5 AS price5 
FROM PRODUCT

-- 6.

SELECT NAME, COMPANY 
FROM PRODUCT 
WHERE PRICE = 5000

-- 7. 

SELECT PRICE, COMPANY 
FROM PRODUCT 
WHERE PRICE BETWEEN 3000 AND 6000 

-- 8. 

SELECT NAME, COMPANY 
FROM PRODUCT 
WHERE COMPANY != 'c100'

-- 9.

SELECT NAME, PRICE 
FROM PRODUCT 
WHERE COMPANY = 'c100' OR COMPANY  = 'c200'

-- 10. 조건 건색(문자열 포함)

SELECT * 
FROM PRODUCT 
WHERE NAME LIKE '%4'

-- 11. 조건 건색(문자열 포함)

SELECT * 
FROM PRODUCT 
WHERE NAME LIKE '%food%'

-- 12. update

UPDATE PRODUCT 
SET CONTENT = '품절'
WHERE PRICE = 5000

SELECT * FROM PRODUCT 
WHERE PRICE = 5000

-- 13. 

UPDATE PRODUCT 
SET IMG = '0.png', PRICE = 10000
WHERE id = '100' OR id = '102'

SELECT * FROM PRODUCT

-- 14. delete는 컬럼명을 지정하지 않음.
--> insert, delete, update의 결과는 실행된 Row수!(정수)
--> select의 결과는 테이블이다.! 

DELETE FROM PRODUCT
WHERE COMPANY = 'c100'

SELECT * 
FROM PRODUCT 
WHERE COMPANY = 'c100'

-- 15. DELETE 
--> varchar2, char의 차이 
--> varchar2(100) : var(변하다, variable) + char(문자)
-->           2글자이면 2글자들어갈 만큼만 저장공간을 사용
-->           100글자이면 100글자들어갈 만큼 저장공간을 저장 
--> char(100) : 저장공간이 고정, 주민번호, 전화번호, 우편번호, 사번 

DELETE FROM PRODUCT -- row수 
--> 저장공간은 남겨두고, 데이터만 지움.
--> 데이터를 복구/취소(rollback, 롤백) 가능 
--> truncate로 지우면 저장공간도 남겨두지 않고, 복구/취소 불가능 

SELECT * FROM PRODUCT  

--------------------------------

SELECT concat(CONCAT(empno, ':'), ENAME) AS concat_result FROM emp 

SELECT empno || ':' || ename AS concat_result FROM emp 


SELECT LENGTH(trim(ename)) FROM emp

SELECT LENGTH(ename) FROM emp

SELECT TRIM(BOTH 'A' from ename) FROM emp 
SELECT TRIM(LEADING 'A' from ename) FROM emp
SELECT TRIM(TRAILING 'A' from ename) FROM emp