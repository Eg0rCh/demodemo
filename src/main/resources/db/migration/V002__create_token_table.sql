CREATE SEQUENCE token_sequence start 2 increment 1;

CREATE TABLE if not exists token(
    id int8 primary key not null,
    token varchar,
    token_type varchar,
    expired bool,
    date_valid_to timestamp,
    user_id int8 references user_info(id)
);

INSERT INTO token (id, token, token_type, expired, date_valid_to, user_id)
VALUES (1,
'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZGFzc2RmYWFkZkBhc2QucnUiLCJpYXQiOjE3MDAzNzk4MjAsImV4cCI6MTcwMDQ2NjIyMH0.pWhLkzTGAZRxpiRUjwsS1WUYsfcjqiMtASudJHTNJZA',
        'BEARER',
        false,
        '2030-11-19 10:40:35.301044',
        1);
