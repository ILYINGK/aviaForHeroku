package mail.ilyin_gk.avia.model;

import lombok.Value;

import java.sql.Timestamp;
import java.util.Date;

@Value
public class Flight {
    long id;
    int flightNumber;
    String planeModel;
    Timestamp arrivalTime;
    Timestamp departureTime;


    }
