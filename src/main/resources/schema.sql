CREATE TABLE flights
(
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    flight_id     INTEGER CHECK (flight_id >= 0),
    flight_number INTEGER CHECK (flight_number >= 0),
    plane_model   TEXT NOT NULL


);

CREATE TABLE passengers
(
    id               INTEGER PRIMARY KEY AUTOINCREMENT,
    flight_id INTEGER REFERENCES flights,
    passenger_id     INTEGER NOT NULL,
    first_name       TEXT    NOT NULL,
    second_name      TEXT    NOT NULL,
    passport_number  INTEGER CHECK (passport_number >= 0),
    baggage_on_board BIT DEFAULT 0
);
CREATE TABLE baggage_declarations
(
    id                     INTEGER PRIMARY KEY AUTOINCREMENT,
    baggage_declaration_id INTEGER NOT NULL,
    passenger_id           INTEGER REFERENCES passengers,
    sum_item               INTEGER CHECK (sum_item >= 0),
    first_item_number      INTEGER CHECK (first_item_number > 0),
    second_item_number     INTEGER CHECK (second_item_number > 0),
    third_item_number      INTEGER CHECK (third_item_number > 0),
    fourth_item_number     INTEGER CHECK (fourth_item_number > 0),
    sum_weight             INTEGER CHECK (sum_weight > 0)

);