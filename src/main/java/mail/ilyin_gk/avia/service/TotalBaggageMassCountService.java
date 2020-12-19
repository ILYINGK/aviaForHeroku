package mail.ilyin_gk.avia.service;

import lombok.Value;
import mail.ilyin_gk.avia.exception.NotFoundException;
import mail.ilyin_gk.avia.exception.ServiseException;
import mail.ilyin_gk.avia.model.BaggageDeclaration;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@Value
public class TotalBaggageMassCountService {

public  TotalBaggageMassCountService(){

}


    public Integer calculate(List<BaggageDeclaration> array) {
        int totalWeight = 0;
        int i = 0;
        while (i < array.size()) {
            totalWeight = totalWeight + array.get(i).getSumWeight();
        if(i> array.size())throw new ServiseException("wrong array size");
            i++;
        }
        System.out.println("passId=  "+array.get(0).getId());
        System.out.println("size=  "+array.size());
        return totalWeight;

    }
}
