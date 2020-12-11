package mail.ilyin_gk.avia.service;

import mail.ilyin_gk.avia.model.BaggageDeclaration;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
public class TotalBaggageMassCountService {
    int result=7;
    public Integer calculate() {
        //List<Integer> result = new LinkedList<>();

        //result.add(7);
result = 7;
        return result;}
    /*public Integer calculate(List<BaggageDeclaration> array) {
        int totalWeight = 0;
        int i = 0;
        while (i < array.size()) {
            totalWeight = totalWeight + array.get(i).getSumWeight();
            i++;
        }

        return totalWeight;

    }*/
}
