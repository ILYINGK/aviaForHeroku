package mail.ilyin_gk.avia.mapper;


import mail.ilyin_gk.avia.model.Passenger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PassengerRowMapper implements RowMapper<Passenger> {
    public Passenger mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Passenger(

                rs.getLong("passenger_id"),
                rs.getString("first_name"),
                rs.getString("second_name"),
                rs.getInt("passport_number"),
                rs.getBoolean("baggage_on_board")

        );
    }
}