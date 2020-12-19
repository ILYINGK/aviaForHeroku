CREATE TABLE flights
(
    id             INTEGER PRIMARY KEY AUTO_INCREMENT,
    flight_number  INTEGER CHECK (flight_number >= 0),
    plane_model    TEXT      NOT NULL,
    arrival_time   TIMESTAMP NOT NULL,
    departure_time TIMESTAMP NOT NULL


);

CREATE TABLE passengers
(
    id                 INTEGER PRIMARY KEY AUTO_INCREMENT,
    flight_id          INTEGER REFERENCES flights,

    first_name         TEXT NOT NULL,
    second_name        TEXT NOT NULL,
    passport_number    TEXT NOT NULL,
    passenger_on_board BOOLEAN DEFAULT false,
    baggage_on_board   BOOLEAN DEFAULT false
);
CREATE TABLE baggage_declarations
(
    id                 INTEGER PRIMARY KEY AUTO_INCREMENT,
    passenger_id       INTEGER REFERENCES passengers,
    sum_item           INTEGER CHECK (sum_item >= 0),
    first_item_number  INTEGER CHECK (first_item_number >= 0),
    second_item_number INTEGER CHECK (second_item_number >= 0),
    third_item_number  INTEGER CHECK (third_item_number >= 0),
    fourth_item_number INTEGER CHECK (fourth_item_number >= 0),
    sum_weight         INTEGER CHECK (sum_weight >= 0)

);