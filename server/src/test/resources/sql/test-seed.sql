insert into products(id, name, description, unit_price)
values (111, 'stapler', 'staples things', 500),
       (112, 'paper clip', 'holds things together', 10),
       (113, 'Paper (A4)', 'you can write stuff on this', 100);

insert into ratings(product_id, rating, user_id)
values (111, 10, 888),
       (112, 5, 537),
       (112, 7, 123),
       (112, 8, 444),
       (113, 8, 123);

insert into inventory(product_id, current_stock, out_of_stock)
values (111, 100, false),
       (112, 100, false),
       (113, 0, true);

