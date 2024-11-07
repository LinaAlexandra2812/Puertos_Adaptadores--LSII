package application.controllers;

import domain.model.Chair;
import domain.ports.input.IChairUseCase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chair")
public class ChairController {

    @Autowired
    private IChairUseCase chairUseCase;

    // GET all chairs
    @GetMapping
    public List<Chair> findAll() {
        return chairUseCase.findAllChairs();
    }

    // POST create chair
    @PostMapping
    public Chair create(@RequestBody Chair chair) {
        return chairUseCase.createChair(chair);
    }

    // GET chair by id
    @GetMapping("/{id}")
    public Chair getChairById(@PathVariable Long id) {
        return chairUseCase.findChairById(id);
    }
}