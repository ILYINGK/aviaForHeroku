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
    public List<Passenger> getByAll() {
        return manager.getAllpassengers();
    }

    @GetMapping("/passengers/{id}")
    public Passenger getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @GetMapping("/passengers/search")
    public List<Passenger> search(@RequestParam String firstName, @RequestParam String secondName) {
        return manager.searchPassenger(firstName, secondName);
    }

    @GetMapping("/baggagebyowner/{passengerId}")
    public List<BaggageDeclaration> getByOwnerId(@PathVariable long passengerId) {
        return manager.getAllbaggageDeclarationByOwner(passengerId);
    }

    @PostMapping("/save")
    public Passenger save(@RequestBody Passenger item) {
        return manager.save(item);
    }

    @DeleteMapping("/{id}")
    public Passenger removeById(@PathVariable long id) {
        return manager.removeById(id);
    }

    @GetMapping("/totalbaggageweidht")
    public Integer getTotalWeight() {
        return manager.totalweight();
    }


}
