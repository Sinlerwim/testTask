DROP TABLE IF EXISTS person;
CREATE TABLE person (
        id VARCHAR(255) PRIMARY KEY,
        first_name VARCHAR(255),
        last_name VARCHAR(255),
        date_Of_birth DATE
        );

INSERT INTO person VALUES ('e561ede7-0e0c-4673-b84c-47d1ac5fed69', 'John', 'Smith', '2000-05-23');
INSERT INTO person VALUES ('fb582b8d-f6ed-4922-b794-e4f228890c1e', 'Tom', 'Cruise', '1962-03-07');

