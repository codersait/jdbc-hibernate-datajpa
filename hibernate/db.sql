CREATE TABLE IF NOT EXISTS student
(
    id
    BIGSERIAL
    PRIMARY
    KEY,
    first_name
    TEXT
    NOT
    NULL,
    last_name
    TEXT
    NOT
    NULL,
    email
    TEXT
    NOT
    NULL
    UNIQUE,
    age
    INT
    NOT
    NULL
)
    insert into student
(
    first_name,
    last_name,
    email,
    age
) values
(
    'ali',
    'veli',
    'ali@mail.com',
    40
);