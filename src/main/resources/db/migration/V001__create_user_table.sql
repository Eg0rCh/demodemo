CREATE SEQUENCE user_info_sequence start 2 increment 1;

CREATE TABLE if not exists user_info(
    id int8 primary key not null ,
    nick varchar ,
    email varchar ,
    password varchar
);

INSERT INTO user_info(id,nick,email) VALUES (1, 'TestsUser', 'testuser@mail.ru');
