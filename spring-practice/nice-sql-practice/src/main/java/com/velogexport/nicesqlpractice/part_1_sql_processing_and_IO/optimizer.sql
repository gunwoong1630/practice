create table if not exists p1
(
    id    bigint primary key not null,
    uid   bigint             not null,
    name  varchar(10),
    email varchar(50)
);
create index idx1 on p1 (uid,name);
create index idx2 on p1 (uid, name, email);

###

explain analyze
select *
from p1
where uid = 0
  and name = 'gunwoong';
