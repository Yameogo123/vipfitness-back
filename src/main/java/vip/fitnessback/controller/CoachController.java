package vip.fitnessback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.fitnessback.model.Coach;
import vip.fitnessback.service.CoachService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @GetMapping("/all")
    public List<Coach> retrieveAll(){
        return coachService.all();
    }

    @GetMapping("/all/active")
    public List<Coach> retrieveAllActive(){
        return coachService.allActive();
    }

    @PutMapping("/update")
    public Coach update(@RequestBody Coach coach){
        return coachService.update(coach);
    }

    @PostMapping("/new")
    public Coach newOne(@RequestBody Coach coach){
        return coachService.newCoach(coach);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        Coach coach=coachService.getById(id);
        coachService.delete(coach);
    }

    @PutMapping("/inactive/{id}")
    public Coach inactive(@PathVariable long id){
        Coach coach=coachService.getById(id);
        coach.setActive(!coach.isActive());
        return coachService.update(coach);
    }
}
