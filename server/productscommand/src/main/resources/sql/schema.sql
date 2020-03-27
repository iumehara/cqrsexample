drop table if exists products;
create table products(
    id serial unique,
    name varchar(100) not null,
    description varchar(200),
    unit_price int
);

drop table if exists ratings;
create table ratings(
    id serial unique,
    product_id int,
    rating int,
    user_id int
);

drop table if exists inventory;
create table inventory(
    id serial unique,
    product_id int,
    current_stock int default 0,
    out_of_stock bool default true
);