package mail.ilyin_gk.avia.mapper;

import org.springframework.jdbc.core.RowMapper;
import mail.ilyin_gk.avia.model.Flight;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FlightRowMapper implements RowMapper<Flight>{
    public Flight mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Flight(

                rs.getLong("flight_id"),
                rs.getInt("flight_number"),
                rs.getString("plane_model"),
                rs.getTimestamp("arrival_time"),
                rs.getTimestamp("departure_time")




        );
    }
}
