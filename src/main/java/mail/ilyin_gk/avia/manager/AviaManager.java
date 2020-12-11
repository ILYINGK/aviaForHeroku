package mail.ilyin_gk.avia.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import mail.ilyin_gk.avia.mapper.BaggageDeclarationRowMapper;

import mail.ilyin_gk.avia.mapper.PassengerRowMapper;
import mail.ilyin_gk.avia.mapper.FlightRowMapper;
import mail.ilyin_gk.avia.model.BaggageDeclaration;
import mail.ilyin_gk.avia.model.Passenger;
import mail.ilyin_gk.avia.model.Flight;

import mail.ilyin_gk.avia.service.OveralBaggageMassCountService;

import java.util.List;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class AviaManager {
    private final NamedParameterJdbcTemplate template;
    //private final OveralBaggageMassCountService overalBaggageMassCountService;

   // private final FlightRowMapper flightRowMapper;

    private final PassengerRowMapper passengerRowMapper;
    private final BaggageDeclarationRowMapper baggageDeclarationRowMapper;

    public List<Passenger> getAllpassengers() {
        return template.query(
                "SELECT id, flight_id, passenger_id, first_name, second_name,passport_number,passenger_on_board,baggage_on_board FROM passengers ORDER BY id LIMIT 50",
                passengerRowMapper
        );
    }

    public Passenger getById(long id) {
        return template.queryForObject(
                "SELECT id, flight_id, passenger_id, first_name, second_name,passport_number,passenger_on_board,baggage_on_board FROM passengers WHERE id = :id",
                Map.of("id", id),
                passengerRowMapper
        );
    }
    public List<Passenger> searchPassenger(String firstName, String secondName) {
        return template.query(
                "SELECT id, flight_id, passenger_id, first_name, second_name,passport_number,passenger_on_board,baggage_on_board FROM passengers WHERE first_name = :first_name AND second_name= :second_name",
                //Map.of("first_name", firstName, "second_name", secondName),
                Map.of("first_name",firstName,"second_name",secondName),
                passengerRowMapper
        );
    }

    public List<Passenger> getPassportDyId(long id) {
        return template.query(
                "SELECT passenger_id, first_name, second_name,passport_number FROM passengers WHERE passenger_id = :passenger_id",
                Map.of("passenger_id", id),
                passengerRowMapper
        );
    }

    public List<BaggageDeclaration> getAllbaggageDeclarationByOwner(long passengerId) {
        return template.query(
                "SELECT id," +
                        "baggage_declaration_id," +
                        "passenger_id,sum_item," +
                        "first_item_number," +
                        "second_item_number," +
                        "third_item_number," +
                        "fourth_item_number," +
                        "sum_weight " +
                        "FROM baggage_declarations WHERE passenger_id = :passenger_id",
                Map.of("passenger_id", passengerId),
                baggageDeclarationRowMapper
        );
    }
    public Passenger save(Passenger item) {
        if (item.getId() == 0) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            template.update(
                    "INSERT INTO passengers(flight_id, passenger_id, first_name, second_name,passport_number,passenger_on_board,baggage_on_board) " +
                            "VALUES (:flight_id, :passenger_id, :first_name, :second_name, :passport_number, :passenger_on_board, :baggage_on_board)",
                    new MapSqlParameterSource(Map.of(
                            "flight_id", item.getFlightId(),
                            "passenger_id", item.getId(),
                            "first_name", item.getFirstName(),
                            "second_name", item.getSecondName(),
                            "passport_number", item.getPassportNumber(),
                            "passenger_on_board", item.isPassengerOnBoard(),
                            "baggage_on_board", item.isBaggageOnBoard()

                    )),
                    keyHolder
            );
            long id = keyHolder.getKey().longValue();
            return getById(id);
        }

        template.update(
                "UPDATE passengers SET flight_id = :flight_id, passenger_id = :passenger_id, first_name = :first_name, second_name = :second_name," +
                        " passport_number = :passport_number, passenger_on_board = :passenger_on_board, baggage_on_board = :baggage_on_board WHERE id = :id",
                Map.of(
                        "flight_id", item.getFlightId(),
                        "passenger_id", item.getId(),
                        "first_name", item.getFirstName(),
                        "second_name", item.getSecondName(),
                        "passport_number", item.getPassportNumber(),
                        "passenger_on_board", item.isPassengerOnBoard(),
                        "baggage_on_board", item.isBaggageOnBoard()
                )
        );

        return getById(item.getId());
    }

}
