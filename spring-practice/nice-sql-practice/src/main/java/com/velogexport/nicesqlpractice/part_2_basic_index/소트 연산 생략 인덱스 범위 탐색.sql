drop table if exists 상태변경이력;
create table if not exists 상태변경이력
(
    장비번호 varchar(10)     not null,
    변경일자 varchar(10)    not null,
    변경순번 varchar(10) not null,
    PRIMARY KEY (장비번호, 변경일자, 변경순번)
);
INSERT INTO 상태변경이력 (장비번호, 변경일자, 변경순번) VALUES
                                          ('A1', '20240601', '001'),
                                          ('A1', '20240601', '002'),
                                          ('A1', '20240602', '001'),
                                          ('A1', '20240602', '002'),
                                          ('A2', '20240601', '001'),
                                          ('A2', '20240601', '002'),
                                          ('A2', '20240603', '001'),
                                          ('A3', '20240601', '001'),
                                          ('A3', '20240602', '001'),
                                          ('A3', '20240602', '002'),
                                          ('B1', '20240601', '001'),
                                          ('B1', '20240601', '002'),
                                          ('B1', '20240602', '001'),
                                          ('B2', '20240601', '001'),
                                          ('B2', '20240602', '001'),
                                          ('B2', '20240602', '002'),
                                          ('C1', '20240601', '001'),
                                          ('C1', '20240601', '002'),
                                          ('C1', '20240602', '001'),
                                          ('C1', '20240603', '001'),
                                          ('C2', '20240601', '001'),
                                          ('C2', '20240601', '002'),
                                          ('C2', '20240601', '003'),
                                          ('D1', '20240602', '001'),
                                          ('D1', '20240602', '002'),
                                          ('D1', '20240603', '001'),
                                          ('D2', '20240601', '001'),
                                          ('D2', '20240601', '002'),
                                          ('D2', '20240602', '001'),
                                          ('D2', '20240602', '002');



explain analyze
select *
from 상태변경이력
where 장비번호 = ''
  and 변경일자 = '20180316';
# ref = const, const
# -> Covering index lookup on 상태변경이력 using PRIMARY (장비번호='', 변경일자='')  (cost=0.35 rows=1) (actual time=0.00877..0.00877 rows=0 loops=1)


### 소트 연산 생략

explain analyze
select *
from 상태변경이력
where 장비번호 = 'C'
  and 변경일자 = '20180316' order by 변경순번;
# -> Covering index lookup on 상태변경이력 using PRIMARY (장비번호='C', 변경일자='20180316')  (cost=0.35 rows=1) (actual time=0.0102..0.0102 rows=0 loops=1)


explain analyze
select *
from 상태변경이력
where 장비번호 = 'C'
  and 변경일자 = '20180316' order by 변경순번 desc;
# -> Covering index lookup on 상태변경이력 using PRIMARY (장비번호='C', 변경일자='20180316') (reverse)  (cost=0.35 rows=1) (actual time=0.00895..0.00895 rows=0 loops=1)

