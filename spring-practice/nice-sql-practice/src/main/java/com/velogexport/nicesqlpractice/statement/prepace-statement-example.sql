PREPARE prepare_statement FROM 'SELECT * FROM car WHERE car_id = ?';

-- 파라미터 지정하여 prepare statement 실행
SET @car_id = 1;
EXECUTE prepare_statement USING @car_id;

-- prepare statement 제거
DEALLOCATE PREPARE prepare_statement;

