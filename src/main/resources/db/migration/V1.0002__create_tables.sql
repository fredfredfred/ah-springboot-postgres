CREATE TABLE player
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name     TEXT NOT NULL,
    birthday DATE NOT NULL
);

CREATE TABLE booking
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    court      INT    NOT NULL,
    player_id  BIGINT NOT NULL REFERENCES player (id),
    start_time TIMESTAMP WITH TIME ZONE,
    end_time   TIMESTAMP WITH TIME ZONE
);

