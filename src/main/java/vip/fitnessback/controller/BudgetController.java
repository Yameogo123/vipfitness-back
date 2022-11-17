package vip.fitnessback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.fitnessback.model.Budget;
import vip.fitnessback.service.BudgetService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/all/{mois}/{annee}")
    public List<Budget> getBudget(@PathVariable int mois, @PathVariable int annee){
        return budgetService.budgetByMonthAndYear(mois, annee);
    }

    @PostMapping("/new")
    public Budget addBudget(@RequestBody  Budget budget){
        return budgetService.add(budget);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBudget(@PathVariable long id){
        Budget budget= budgetService.getById(id);
        budgetService.remove(budget);
    }
}
