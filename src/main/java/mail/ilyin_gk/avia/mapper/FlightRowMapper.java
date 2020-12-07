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
                rs.getLong("id"),
                rs.getLong("flight_id"),
                rs.getLong("flight_number"),
                rs.getString("plane_model"),
                rs.getLong("arrivalTime"),
                rs.getLong("departureTime")



        );
    }
}
@Component
public class FlatRowMapper implements RowMapper<Flat> {
    public Flat mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Flat(
                rs.getLong("id"),
                rs.getLong("owner_id"),
                rs.getString("district"),
                rs.getInt("price"),
                rs.getInt("rooms")
        );
    }
}