package mail.ilyin_gk.avia.model;

import lombok.Value;


@Value
public class BaggageDeclaration {
    long id;
    int passengerId;
    int sumItem;
    int firstItemNumber;
    int secondItemNumber;
    int thirdItemNumber;
    int fourthItemNumber;
    int sumWeight;  // весы округляют до килограмма
}
