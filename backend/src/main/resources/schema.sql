DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    id BIGINT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(127) NOT NULL
);

CREATE TYPE ACTION_TYPE AS ENUM ('BUY', 'SELL');

DROP TABLE IF EXISTS Transactions;
CREATE TABLE Transactions (
    id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    ticker VARCHAR(4) NOT NULL,
    action ACTION_TYPE NOT NULL,
    quantity BIGINT NOT NULL,
    price_per_unit FLOAT(7),
    timestamp TIMESTAMP NOT NULL DEFAULT now()
);
