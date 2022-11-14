package vip.fitnessback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.fitnessback.model.Membre;
import vip.fitnessback.service.MembreService;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/membre")
public class MembreController {

    @Autowired
    private MembreService membreService;

    @GetMapping("/all")
    public List<Membre> all(){
        return membreService.allMember();
    }

    @PutMapping("/update")
    public Membre Update(@RequestBody Membre membre){
        return membreService.updateMembre(membre);
    }

    @PostMapping("/new")
    public Membre nouveau(@RequestBody Membre membre){
        return membreService.newMember(membre);
    }

    @PutMapping("/renouveler/{id}")
    public Membre renouveler(@PathVariable Long id){
        Membre member= membreService.oneById(id);
        member.setFinInscription(LocalDate.now().plusMonths(1));
        member.setConfirmation(true);
        member.increase();
        return membreService.updateMembre(member);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String info(@PathVariable Long id){
        Membre member= membreService.oneById(id);
        String result= "<h1>nom : "+ member.getNom()+ "<br>téléphone: "+member.getTelephone() ;
        if(member.getFinInscription().isAfter(LocalDate.now())){
            result= result + "<br>\nabonnement valide</h1>";
        }else{
            result= result + "<br>\nabonnement expiré</h1>";
        }
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public void del(@PathVariable Long id){
        Membre member= membreService.oneById(id);
        membreService.remove(member);
    }
}
