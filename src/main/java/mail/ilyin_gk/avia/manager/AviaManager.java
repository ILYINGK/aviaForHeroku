package mail.ilyin_gk.avia.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import mail.ilyin_gk.avia.mapper.BaggageDeclarationRowMapper;
import mail.ilyin_gk.avia.mapper.FlightRowMapper;
import mail.ilyin_gk.avia.mapper.PassengerRowMapper;

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

    private final FlightRowMapper flightRowMapper;
    private final BaggageDeclarationRowMapper baggageDeclarationRowMapper;
    private final PassengerRowMapper passengerRowMapper;

    public List<Passenger> getAllpassengers() {
        return template.query(
                "SELECT id, flight_id, passenger_id, first_name, second_name,passport_number,baggage_on_board FROM passengers ORDER BY id LIMIT 50",
                passengerRowMapper
        );
    }

    public List<BaggageDeclaration> getAllbaggageDeclarations() {
        return template.query(
                "SELECT id," +
                        "baggage_declaration_id," +
                        "passenger_id,sum_item," +
                        "first_item_number," +
                        "second_item_number," +
                        "third_item_number," +
                        "fourth_item_number," +
                        "sum_weight " +
                        "FROM baggage_declarations ORDER BY id LIMIT 50",
                baggageDeclarationRowMapper
        );
    }
}
