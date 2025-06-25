drop table if exists emp;
create table if not exists emp
(
    ename  varchar(10) not null,
    deptno int         not null,
    job    varchar(10) not null,
    sal    int         not null,
    index emp_x01 (deptno, job)
);
INSERT INTO emp (ename, deptno, job, sal)
VALUES ('SMITH', 10, 'CLERK', 800),
       ('ALLEN', 20, 'SALESMAN', 1600),
       ('WARD', 30, 'SALESMAN', 1250),
       ('JONES', 20, 'MANAGER', 2975),
       ('MARTIN', 30, 'SALESMAN', 1250),
       ('BLAKE', 30, 'MANAGER', 2850),
       ('CLARK', 10, 'MANAGER', 2450),
       ('SCOTT', 20, 'ANALYST', 3000),
       ('KING', 10, 'PRESIDENT', 5000),
       ('TURNER', 30, 'SALESMAN', 1500),
       ('ADAMS', 20, 'CLERK', 1100),
       ('JAMES', 30, 'CLERK', 950),
       ('FORD', 20, 'ANALYST', 3000),
       ('MILLER', 10, 'CLERK', 1300),
       ('LEE', 20, 'CLERK', 1000),
       ('KIM', 10, 'CLERK', 900),
       ('PARK', 30, 'SALESMAN', 1400),
       ('CHOI', 20, 'MANAGER', 2800),
       ('YOUNG', 30, 'MANAGER', 2700),
       ('HAN', 10, 'CLERK', 1200);

## 1. 인덱스 컬럼 추가
explain analyze
select *
from emp
where deptno = 30
  and sal >= 2000;
# -> Filter: (emp.sal >= 2000)  (cost=0.733 rows=2.33) (actual time=0.0263..0.0325 rows=2 loops=1)
#     -> Index lookup on emp using emp_x01 (deptno=30)  (cost=0.733 rows=7) (actual time=0.02..0.0302 rows=7 loops=1)

ALTER TABLE emp
    DROP INDEX emp_x01;
ALTER TABLE emp
    ADD INDEX emp_x01_upgrade (deptno, job, sal);

explain analyze
select *
from emp
where deptno = 30
  and sal >= 2000;
# -> Index lookup on emp using emp_x01_upgrade (deptno=30), with index condition: (emp.sal >= 2000)  (cost=0.733 rows=7) (actual time=0.0272..0.0351 rows=2 loops=1)

## 2. Covered 쿼리를 통한 테이블 액세스 아예 발생하지 않도록
explain
select deptno, job
from emp
where deptno = 10
  and job = '';
# using index

## 3. 인덱스 구조 테이블
SHOW VARIABLES LIKE 'default_storage_engine';
# innoDB는 기본적으로 클러스터드 인덱스 사용하고 있음, 다른 DB에서 사용하는 기존의 테이블(힙 구조 테이블)을 mysql에서 사용하려면 아래와 같이 사용
CREATE TABLE temp_table
(
    id   INT,
    name VARCHAR(50)
) ENGINE = MEMORY;

# 이렇게하면 힙 구조 테이블로 생성할것같지만, 사실 아님. 내부적으로 row_id를 생성하여 클러스터 테이블로 관리함
create table temp
(
    id int
);

select *
from temp;

## 4. 해시 클러스터 테이블
# mysql에서 memory 엔진에서 default로 해시 인덱스를 사용하고있음
# 그래서 보통 적은 데이터이거나 동등 조건을 비교하는 부분에서 사용
create table hash_example_table
(
    hash_id   int,
    b_tree_id int,
    index hash_id (hash_id) using hash,
    index b_tree_id (b_tree_id) using btree
);
show index from hash_example_table;
# 참고로 show index 했을때 hash 인덱스 또한 btree로 보이는데 이는 MySQL MEMORY 엔진의 오래된 표시 버그
select *
from hash_example_table
where hash_id = 1;

select *
from hash_example_table
where b_tree_id between 1 and 2;




