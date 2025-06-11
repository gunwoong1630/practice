SELECT @@performance_schema;

SELECT *
FROM performance_schema.setup_instruments
WHERE NAME LIKE '%prepared%';

UPDATE performance_schema.setup_instruments
SET ENABLED = 'YES',
    TIMED   = 'YES'
WHERE NAME LIKE '%prepared%';

SELECT *
FROM performance_schema.setup_consumers;


UPDATE performance_schema.setup_consumers
SET ENABLED = 'YES'
WHERE NAME LIKE '%prepared%';

UPDATE performance_schema.setup_consumers
SET ENABLED = 'YES'
WHERE NAME IN (
               'events_statements_current',
               'events_statements_history',
               'events_statements_history_long'
    );

SHOW GLOBAL STATUS LIKE 'Prepared_stmt_count';
