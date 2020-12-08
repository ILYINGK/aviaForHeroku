package mail.ilyin_gk.avia.mapper;


import mail.ilyin_gk.avia.model.BaggageDeclaration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BaggageDeclarationRowMapper implements RowMapper<BaggageDeclaration> {
    public BaggageDeclaration mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BaggageDeclaration(

                rs.getLong("baggage_declaration_id"),
                rs.getInt("passenger_id"),
                rs.getInt("sum_item"),
                rs.getInt("first_item_number"),
                rs.getInt("second_item_number"),
                rs.getInt("third_item_number"),
                rs.getInt("fourth_item_number"),
                rs.getInt("sum_weight")


        );
    }
}