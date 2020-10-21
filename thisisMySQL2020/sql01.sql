CREATE TABLE indexTBL(
	first_name varchar(14),
    last_name varchar(16),
    hire_date date
);

INSERT INTO indexTBL(
	SELECT first_name, last_name, hire_date
    FROM employees.employees
    LIMIT 500
);

DROP TABLE indexTBL;

SELECT * FROM indexTBL;

SELECT * FROM indexTBL WHERE first_name = 'Mary';


CREATE INDEX idx_indexTBL_firstname ON indexTBL(first_name); -- 인덱스 생성





CREATE VIEW uv_memberTBL AS(
	SELECT memberID, memberAddress FROM memberTBL
); -- VIEW 생성uv_membertbl

SELECT * FROM uv_memberTBL;





-- stored procedure
DELIMITER //
CREATE PROCEDURE myProc()
BEGIN
	SELECT * FROM memberTBL WHERE memberName = '1';
    SELECT * FROM productTBL WHERE productName = '1';
END //
DELIMITER ;

CALL myProc();





-- 트리거
INSERT INTO memberTBL VALUES ('5', '5', '5');

UPDATE memberTBL SET memberAddress = '55' WHERE memberName = '5';

SELECT * FROM memberTBL;
SELECT * FROM deleteMemberTBL;

DELETE FROM memberTBL where memberID = 5;

CREATE TABLE deleteMemberTBL (
	memberID char(8),
    memberName char(5),
    memberAddress char(20),
    deleteDate date -- 삭제한 날짜
);

DELIMITER //
CREATE TRIGGER trg_deleteMemberTBL -- 트리거 이름
	AFTER DELETE -- 삭제 후에 작동하게 지정
    ON memberTBL -- 트리거를 부착할 테이블
    FOR EACH ROW -- 각 모든 행에 적용
BEGIN
	-- OLD 테이블의 내용을 백업테이블에 삽입
	INSERT INTO deleteMemberTBL 
		VALUES (OLD.memberID, OLD.memberName, OLD.memberAddress, CURDATE());
END //
DELIMITER ;





-- 백업과 업데이트
DELETE FROM producttbl;
SELECT * FROM producttbl;

use sys;
use shopdb;

