Drop TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    name  VARCHAR(50),
    email VARCHAR(100),
    age   INT,
    INDEX idx_age (age),
    INDEX idx_name(name)
);

CREATE TABLE IF NOT EXISTS accounts
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    money INT,
    Foreign Key (user_id) references users(id)
);

INSERT INTO users (name, email, age) VALUES ('Norma Fisher1', 'ysullivan1@yahoo.com', 42);
INSERT INTO users (name, email, age) VALUES ('Norma Fisher2', 'ysullivan2@yahoo.com', 42);
INSERT INTO users (name, email, age) VALUES ('Norma Fisher3', 'ysullivan3@yahoo.com', 42);
INSERT INTO users (name, email, age) VALUES ('Norma Fisher4', 'ysullivan4@yahoo.com', 42);
INSERT INTO users (name, email, age) VALUES ('Norma Fisher5', 'ysullivan5@yahoo.com', 42);

INSERT INTO users (name, email, age) VALUES ('Heather Snow', 'juancampos@lloyd.org', 44);
INSERT INTO users (name, email, age) VALUES ('Emily Blair', 'wcastro@yahoo.com', 20);
INSERT INTO users (name, email, age) VALUES ('Martin Harris', 'qgrimes@gmail.com', 34);
INSERT INTO users (name, email, age) VALUES ('Kimberly Smith', 'salazarmaria@yahoo.com', 50);
INSERT INTO users (name, email, age) VALUES ('Frederick Harrell', 'johnponce@west.net', 49);
INSERT INTO users (name, email, age) VALUES ('Mrs. Elizabeth Carter MD', 'tamaramorrison@hotmail.com', 43);
INSERT INTO users (name, email, age) VALUES ('Brandon Yates', 'kellylopez@gmail.com', 37);
INSERT INTO users (name, email, age) VALUES ('William Green', 'sheltondavid@mclean.net', 48);
INSERT INTO users (name, email, age) VALUES ('Sara Warren', 'pattylawrence@riley-hayes.com', 40);
INSERT INTO users (name, email, age) VALUES ('Louis Tucker', 'johndennis@gmail.com', 55);
INSERT INTO users (name, email, age) VALUES ('Jacqueline Jackson', 'garciadustin@hotmail.com', 31);
INSERT INTO users (name, email, age) VALUES ('Robert Walters', 'martinezjacob@wilson.com', 50);
INSERT INTO users (name, email, age) VALUES ('Alex Woodward', 'mendozajessica@giles.net', 26);
INSERT INTO users (name, email, age) VALUES ('Brian Green', 'lucasmichael@brown.com', 36);
INSERT INTO users (name, email, age) VALUES ('Melissa Myers', 'rebecca79@gmail.com', 26);
INSERT INTO users (name, email, age) VALUES ('Christina Saunders', 'matthewking@morse.biz', 24);
INSERT INTO users (name, email, age) VALUES ('Shelly Lowery', 'qmonroe@gmail.com', 57);
INSERT INTO users (name, email, age) VALUES ('Alexandria Harmon', 'stephensdennis@yahoo.com', 34);
INSERT INTO users (name, email, age) VALUES ('Dwayne Howard', 'paul61@wheeler.com', 52);
INSERT INTO users (name, email, age) VALUES ('Daniel West', 'moralesjacqueline@yahoo.com', 56);
INSERT INTO users (name, email, age) VALUES ('Michelle Martin', 'jacqueline78@odonnell-munoz.com', 27);
INSERT INTO users (name, email, age) VALUES ('Kathleen Collins', 'lambnancy@yahoo.com', 37);
INSERT INTO users (name, email, age) VALUES ('Zachary Schultz', 'valeriemorales@butler.com', 24);
INSERT INTO users (name, email, age) VALUES ('Miss Lisa Lee', 'joshua21@nash-sanders.com', 22);
INSERT INTO users (name, email, age) VALUES ('Thomas Marsh', 'dennis85@wiggins.com', 39);
INSERT INTO users (name, email, age) VALUES ('Daniel Green', 'sheena09@hotmail.com', 48);
INSERT INTO users (name, email, age) VALUES ('Mathew Ellis MD', 'nicholascarter@hernandez.com', 53);
INSERT INTO users (name, email, age) VALUES ('Michelle Morgan', 'nelsonedward@roberts.com', 24);
INSERT INTO users (name, email, age) VALUES ('Nicholas Peck', 'melodychandler@yahoo.com', 40);
INSERT INTO users (name, email, age) VALUES ('Gary Perry', 'zwells@martinez-wilson.info', 45);
INSERT INTO users (name, email, age) VALUES ('Eric Navarro', 'courtneybennett@miller.com', 38);
INSERT INTO users (name, email, age) VALUES ('Adam Long', 'ymora@hotmail.com', 57);
INSERT INTO users (name, email, age) VALUES ('Claudia Miller', 'brenda26@howard.com', 58);
INSERT INTO users (name, email, age) VALUES ('Jocelyn Rhodes', 'nsanders@williams.com', 31);
INSERT INTO users (name, email, age) VALUES ('Jimmy Ward', 'hintontonya@elliott.biz', 53);
INSERT INTO users (name, email, age) VALUES ('Kathleen Stark', 'obolton@hotmail.com', 48);
INSERT INTO users (name, email, age) VALUES ('Kimberly Velazquez', 'janice55@warren.org', 46);
INSERT INTO users (name, email, age) VALUES ('Sarah Aguilar', 'marshzachary@gmail.com', 51);
INSERT INTO users (name, email, age) VALUES ('Carlos Turner', 'michelle27@yahoo.com', 34);
INSERT INTO users (name, email, age) VALUES ('Stephanie Shaw', 'burgessrebecca@roberts.biz', 21);
INSERT INTO users (name, email, age) VALUES ('Karen Gibbs', 'melissayates@hotmail.com', 53);
INSERT INTO users (name, email, age) VALUES ('Natalie Turner', 'cameron44@yahoo.com', 18);
INSERT INTO users (name, email, age) VALUES ('James Martin', 'justingreer@mcmahon.biz', 23);
INSERT INTO users (name, email, age) VALUES ('Steve Guzman', 'lisagomez@carr.info', 43);
INSERT INTO users (name, email, age) VALUES ('John Hernandez', 'crystalgarcia@banks.info', 60);
INSERT INTO users (name, email, age) VALUES ('Antonio Haynes', 'montesjennifer@yahoo.com', 58);
INSERT INTO users (name, email, age) VALUES ('Bethany Buck', 'stonekristen@gmail.com', 18);
INSERT INTO users (name, email, age) VALUES ('James Watson', 'okelly@huber.info', 57);
INSERT INTO users (name, email, age) VALUES ('Alexander Meyer', 'claytonweiss@chan.com', 49);
INSERT INTO users (name, email, age) VALUES ('Brianna Snow', 'wallsrobert@gmail.com', 39);
INSERT INTO users (name, email, age) VALUES ('Christopher Blevins', 'bparks@yahoo.com', 33);
INSERT INTO users (name, email, age) VALUES ('Tonya Sharp', 'chad50@bailey-smith.com', 38);
INSERT INTO users (name, email, age) VALUES ('Andrea Barry', 'harrisemily@adkins.com', 22);
INSERT INTO users (name, email, age) VALUES ('Tasha Hall', 'shawnwoods@haley.com', 30);
INSERT INTO users (name, email, age) VALUES ('Tyler Phillips', 'brittanymiller@hotmail.com', 54);
INSERT INTO users (name, email, age) VALUES ('Brooke Hurst', 'lesliesanchez@carter.com', 32);
INSERT INTO users (name, email, age) VALUES ('Lindsay Long', 'robertpierce@house.com', 33);
INSERT INTO users (name, email, age) VALUES ('Jeremy Wood', 'aortiz@valenzuela.info', 27);
INSERT INTO users (name, email, age) VALUES ('Cody Rodriguez', 'lauragriffin@lopez-fisher.com', 52);
INSERT INTO users (name, email, age) VALUES ('Jesse Giles', 'steven17@phillips.info', 46);
INSERT INTO users (name, email, age) VALUES ('Aimee Evans', 'rogerpotter@gmail.com', 23);
INSERT INTO users (name, email, age) VALUES ('Olivia Hall', 'crystal01@yahoo.com', 23);
INSERT INTO users (name, email, age) VALUES ('Amanda Scott', 'qgarcia@yahoo.com', 38);
INSERT INTO users (name, email, age) VALUES ('Paul Stout', 'jonesjose@morgan.com', 50);
INSERT INTO users (name, email, age) VALUES ('Scott Campbell', 'amandajenkins@stephens.com', 49);
INSERT INTO users (name, email, age) VALUES ('Jacob Fuller', 'terrypatrick@mcdonald.info', 24);
INSERT INTO users (name, email, age) VALUES ('Claudia Burns', 'dpearson@yahoo.com', 37);
INSERT INTO users (name, email, age) VALUES ('Patrick Williams', 'kellypeter@mathis.com', 53);
INSERT INTO users (name, email, age) VALUES ('Natalie Caldwell', 'blake90@marks-lyons.com', 36);
INSERT INTO users (name, email, age) VALUES ('Kenneth Lee', 'ymoran@gmail.com', 25);
INSERT INTO users (name, email, age) VALUES ('Matthew Mcdaniel', 'jfitzpatrick@stewart.com', 53);
INSERT INTO users (name, email, age) VALUES ('Jasmine Roman', 'lauragonzales@gmail.com', 39);
INSERT INTO users (name, email, age) VALUES ('Amber Price', 'pittsmichael@little.org', 52);
INSERT INTO users (name, email, age) VALUES ('Sean Walton', 'oellis@hotmail.com', 31);
INSERT INTO users (name, email, age) VALUES ('Tina Blevins', 'thenry@yahoo.com', 56);
INSERT INTO users (name, email, age) VALUES ('Derek Williams', 'adam02@buchanan.com', 53);
INSERT INTO users (name, email, age) VALUES ('Jennifer Morse', 'matthewgarcia@gmail.com', 55);
INSERT INTO users (name, email, age) VALUES ('Erica Bryant', 'anthony03@yahoo.com', 36);
INSERT INTO users (name, email, age) VALUES ('Sergio Reed', 'emily44@heath.com', 46);
INSERT INTO users (name, email, age) VALUES ('Timothy Jones', 'dhardy@yahoo.com', 23);
INSERT INTO users (name, email, age) VALUES ('Julia Wilson', 'coreycannon@henson-lewis.org', 56);
INSERT INTO users (name, email, age) VALUES ('Jeffery Fischer', 'haleyjohn@gmail.com', 42);
INSERT INTO users (name, email, age) VALUES ('Seth Michael', 'srodriguez@hotmail.com', 38);
INSERT INTO users (name, email, age) VALUES ('Christina Phillips', 'qherrera@yahoo.com', 54);
INSERT INTO users (name, email, age) VALUES ('Bryan Logan', 'jessicawright@hobbs-osborn.com', 33);
INSERT INTO users (name, email, age) VALUES ('Kaylee Trevino', 'hbrewer@cunningham.net', 36);
INSERT INTO users (name, email, age) VALUES ('Connie Decker', 'holmesemily@brooks.com', 29);
INSERT INTO users (name, email, age) VALUES ('Breanna Smith', 'brenda02@yahoo.com', 30);
INSERT INTO users (name, email, age) VALUES ('Christopher Esparza', 'kimberlyhampton@saunders.com', 29);
INSERT INTO users (name, email, age) VALUES ('Olivia Gomez', 'glester@flowers.info', 20);
INSERT INTO users (name, email, age) VALUES ('Tyler Peters', 'vlamb@payne-padilla.com', 57);
INSERT INTO users (name, email, age) VALUES ('Larry Warner', 'patrick03@gmail.com', 60);
INSERT INTO users (name, email, age) VALUES ('Paul Wright', 'jordanpowers@yahoo.com', 34);
INSERT INTO users (name, email, age) VALUES ('Kenneth Brown', 'andrew00@williams.com', 48);
INSERT INTO users (name, email, age) VALUES ('Antonio Stanton', 'patriciarobinson@yahoo.com', 22);
INSERT INTO users (name, email, age) VALUES ('Eric Banks', 'qsmith@hotmail.com', 23);
INSERT INTO users (name, email, age) VALUES ('Nancy Parks', 'cunninghamdavid@yahoo.com', 26);
INSERT INTO users (name, email, age) VALUES ('Jonathan Howell', 'riveramary@wright.com', 27);
INSERT INTO users (name, email, age) VALUES ('Sara Hoffman', 'mpennington@oliver.com', 20);

# type별 성능 비교 : const > eq_ref > ref > range > index > ALL
## full scan => all
EXPLAIN
SELECT name
FROM users
WHERE name LIKE '%kim%';

## index range scan ( 테이블 읽지않고 인덱스만 전체 스캔 ) => type = index
explain
select age
from users;

## index range scan ( 완전 , 고유 , 여러개) => type = range
explain
select name
from users
where id between 1 and 10;

## index range scan ( 부분 , 비고유 , 여러개) => type = ref
explain
select name
from users
where age = 42;

## index range scan ( join ) => type = eq_ref
explain
select u.id
from users u
         join accounts a on u.id = a.user_id;

## index range scan ( 완전 , 고유, 한개 ) => type = const
explain
select name
from users
where id = 1;

### index range scan 안되는 경우들
## 1. OR
# type = all
EXPLAIN
select *
from users
where name = 'a'
   or email = 'c';

## 해결 : or을 union all로 합집합으로 하면 all을 ref 2개로
EXPLAIN
select *
from users
where name = 'a'
union all
select *
from users
where name = 'b';

## 2. LIKE
# type = all or index (select을 name으로 하면 해당 인덱스 컬럼밖에 쓰지않아서 index가 되고 select을 email로 하면 all)
EXPLAIN
SELECT email
FROM users
WHERE name LIKE '%kim%';
EXPLAIN
SELECT name
FROM users
WHERE name LIKE '%kim';

# 앞에 % 없을경우에는 예외
# type = range
EXPLAIN
SELECT name
FROM users
WHERE name LIKE 'kim%';

## 3. In => Or와 마찬가지

## 4. 인덱스 중간자 빠질경우 빠진 부분은 인덱스 탐색 안하고 필터링 진행
explain analyze
select *
from 상태변경이력
where 장비번호 = ''
  and 변경순번 = '';
# ref = const
# -> Filter: (`상태변경이력`.`변경순번` = '')  (cost=0.35 rows=1) (actual time=0.00973..0.00973 rows=0 loops=1)
#     -> Covering index lookup on 상태변경이력 using PRIMARY (장비번호='')  (cost=0.35 rows=1) (actual time=0.00899..0.00899 rows=0 loops=1)

# Order By 절에서 컬럼 가공
## 인덱스 순서가 있으면 sort 생략
explain analyze
select *
from 상태변경이력
where 장비번호 = 'C'
order by 변경일자, 변경순번;
# -> Covering index lookup on 상태변경이력 using PRIMARY (장비번호='C')  (cost=0.35 rows=1) (actual time=0.0105..0.0105 rows=0 loops=1)

## 순서가 다르면 Sort 추가됨
explain analyze
select *
from 상태변경이력
where 장비번호 = 'C'
order by 변경순번, 변경일자;
# -> Sort: `상태변경이력`.`변경순번`, `상태변경이력`.`변경일자`  (cost=0.35 rows=1) (actual time=0.0134..0.0134 rows=0 loops=1)
#     -> Index lookup on 상태변경이력 using PRIMARY (장비번호='C')  (cost=0.35 rows=1) (actual time=0.00815..0.00815 rows=0 loops=1)

# Select-list에서 컬럼 가공
## 정렬 연산 생략 가능
explain analyze
select min(변경순번)
from 상태변경이력
where 장비번호 = 'A1'
  and 변경일자 = '20240601';
# -> Rows fetched before execution  (cost=0..0 rows=1) (actual time=49e-6..78e-6 rows=1 loops=1)

# max 또한 마찬가지
explain analyze
select max(변경순번)
from 상태변경이력
where 장비번호 = 'A1'
  and 변경일자 = '20240601';
# -> Rows fetched before execution  (cost=0..0 rows=1) (actual time=36e-6..63e-6 rows=1 loops=1)

# 인덱스 컬럼을 집계 후 컬럼 가공하면 집계 쿼리 생략 가능
explain analyze
select COALESCE(MAX(변경순번) + 0, 0)
from 상태변경이력
where 장비번호 = 'A1'
  and 변경일자 = '20240601';

# 컬럼 가공하고 집계하면 추가적인 집계 쿼리 생략 불가능
explain analyze
select max(coalesce(변경순번, 0))
from 상태변경이력
where 장비번호 = 'A1'
  and 변경일자 = '20240601';
# -> Aggregate: max(coalesce(`상태변경이력`.`변경순번`,0))  (cost=0.658 rows=1) (actual time=0.0224..0.0225 rows=1 loops=1)
#     -> Covering index lookup on 상태변경이력 using PRIMARY (장비번호='A1', 변경일자='20240601')  (cost=0.458 rows=2) (actual time=0.0154..0.0187 rows=2 loops=1)

# 서브 쿼리에도 집계 쿼리 생략 가능
explain analyze
select 장비번호,
       변경일자,
       변경순번,
       (select coalesce(max(변경순번), 0)
        from 상태변경이력
        where 장비번호 = 'A1'
          and 변경일자 = '20240601')
from 상태변경이력 p;
# -> Covering index scan on p using PRIMARY  (cost=3.25 rows=30) (actual time=0.00888..0.0146 rows=30 loops=1)
# -> Select #2 (subquery in projection; run only once)
#        -> Rows fetched before execution  (cost=0..0 rows=1) (actual time=38e-6..75e-6 rows=1 loops=1)
