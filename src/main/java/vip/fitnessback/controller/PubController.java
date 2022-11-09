package vip.fitnessback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.fitnessback.model.Pub;
import vip.fitnessback.service.PubService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pub")
public class PubController {

    @Autowired
    public PubService pubService;

    @GetMapping("/all")
    public List<Pub> all(){
        return pubService.all();
    }

    @GetMapping("/last")
    public Pub last(){
        return pubService.lastPub();
    }

    @PostMapping("/new")
    public Pub add(@RequestBody Pub pub){
        return pubService.add(pub);
    }

    @PutMapping("/update")
    public Pub update(@RequestBody Pub pub){
        return pubService.update(pub);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        Pub pub= pubService.getOne(id);
        pubService.delete(pub);
    }
}
