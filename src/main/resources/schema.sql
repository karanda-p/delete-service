CREATE TABLE DATA(
    ID BIGINT NOT NULL,
    DATETIME TIMESTAMP NOT NULL,
    CONSTRAINT DATA_PK PRIMARY KEY (ID)
);

INSERT INTO DATA(id, datetime)
VALUES (generate_series(1,10000000),
        timestamp '2021-04-01 00:00:00' +
        random() * (timestamp '2021-04-26 00:00:00' - timestamp '2021-04-01 00:00:00')
        );