INSERT INTO flights(flight_id,flight_number,plane_model,arrival_time,departure_time )  VALUES
(1,345, 'A350','2020-12-31 23:47:00','2021-01-01 03:09:00'),
(2,604, 'Boeing787','2020-12-31 22:07:00','2021-01-01 05:34:00'),
(3,678, 'Boeing787','2020-12-31 23:15:00','2021-01-01 07:47:00');


INSERT INTO passengers(flight_id,
                       passenger_id,
                       first_name,
                       second_name,
                       passport_number,
                       passenger_on_board,
                       baggage_on_board )  VALUES
(1,1, 'Petrov','Ivan',980712345,0,1),
(2,2, 'Suvorov','Aleksey',634512345,0,0),
(2,3, 'Ivanov','Nikolay',987852323,1,1),
(3,4, 'Patin','Ivan',980712345,0,1),
(3,5, 'Volkov','Aleksey',634512345,1,0),
(3,6, 'Selin','Robert',934562323,0,1);

INSERT INTO baggage_declarations(baggage_declaration_id,
                                 passenger_id,
                                 sum_item,
                                 first_item_number,
                                 second_item_number,
                                 third_item_number,
                                 fourth_item_number,
                                 sum_weight)  VALUES
(101,1, 1,204,0,0,0,15),
(102,3, 2,205,206,0,0,25),
(103,4, 1,207,0,0,0,13),
(104,6, 3,208,209,210,0,31);

