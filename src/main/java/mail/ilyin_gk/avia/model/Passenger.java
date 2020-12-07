package mail.ilyin_gk.avia.model;

import lombok.Value;

@Value
public class Passenger {
    long id;
    String firstName;
    String secondName;
    int passportNumber;
    boolean baggageOnBoard;
}
