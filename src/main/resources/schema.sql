CREATE SCHEMA GAME;
CREATE TABLE IF NOT EXISTS GAME.RESULT
(
    ID         BIGINT       NOT NULL AUTO_INCREMENT,
    WINNER     VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);