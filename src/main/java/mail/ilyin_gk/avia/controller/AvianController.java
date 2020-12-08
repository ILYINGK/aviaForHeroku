package mail.ilyin_gk.avia.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import mail.ilyin_gk.avia.manager.AviaManager;
import mail.ilyin_gk.avia.model.Passenger;
import mail.ilyin_gk.avia.model.Flight;
import mail.ilyin_gk.avia.model.BaggageDeclaration;

import java.util.List;


@RestController
@RequestMapping("/avian")
@RequiredArgsConstructor

public class AvianController {
    private final AviaManager manager;

    @GetMapping("/passengers")
    public List<Passenger> getByAll() {return manager.getAllpassengers();
    }

}
