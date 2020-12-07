CREATE TABLE flats
(
    id       INTEGER PRIMARY KEY AUTO_INCREMENT,
    owner_id INTEGER NOT NULL REFERENCES owners,
    district TEXT    NOT NULL,
    price    INTEGER NOT NULL CHECK (price > 0),
    rooms    INTEGER NOT NULL DEFAULT 1 CHECK (rooms > 0)
);
CREATE TABLE flights
(
    id            INTEGER PRIMARY KEY AUTO_INCREMENT,
    flight_id     INTEGER NOT NULL REFERENCES flightsIds,
    flight_number INTEGER CHECK (flight_number >= 0) flights,
    arrivalTime   DATE    NOT NULL CHECK (arrivalTime > 0) arrivalTimes,
    departureTime DATE    NOT NULL CHECK (arrivalTime > 0) arrivalTimes
);

CREATE TABLE passengers
(
    id               INTEGER PRIMARY KEY AUTO_INCREMENT,
    passenger_id     INTEGER NOT NULL REFERENCES passengersIds,
    first_name       TEXT    NOT NULL firstNames,
    second_name      TEXT    NOT NULL secondNames,
    passport_number  INTEGER CHECK (passport_number >= 0) passports,
    baggage_on_board BIT DEFAULT 0
);
CREATE TABLE baggage_declarations
(
    id                     INTEGER PRIMARY KEY AUTO_INCREMENT,
    baggage_declaration_id INTEGER NOT NULL REFERENCES baggageDeclarationIds,
    passenger_id           INTEGER CHECK (passenger_id >= 0) passengersIds,
    sum_item               INTEGER CHECK (sum_item >= 0) sumItems,
    first_item_number      INTEGER CHECK (first_item_number > 0) firstItemsNumber,
    second_number          INTEGER CHECK (second_number > 0) secondItemsNumber,
    third_item_number      INTEGER CHECK (third_item_number > 0) thirdItemsNumber,
    fourth_item_number     INTEGER CHECK (fourth_item_number > 0) fourthItemsNumber,
    sum_weight     INTEGER CHECK (sum_weight > 0) sumWeight,

);