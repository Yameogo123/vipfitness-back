package vip.fitnessback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.fitnessback.model.Budget;
import vip.fitnessback.repository.BudgetRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> allBudget(){
        return budgetRepository.findAll();
    }

    public Budget getBudgetByDate(LocalDate date){
        return budgetRepository.findBudgetByDate(date);
    }

    public List<Budget> budgetByMonthAndYear(int month, int year){
        List<Budget> budgets= allBudget();
        if(month==0 && year==0){
            return budgets;
        }
        List<Budget> result= new ArrayList<>();
        for(Budget b: budgets){
            if(b.getDate().getMonthValue()== month && b.getDate().getYear()==year){
                result.add(b);
            }
        }
        return result;
    }

    public Budget add(Budget budget){
        if(budget.getDate()==null){
            budget.setDate(LocalDate.now());
        }
        return budgetRepository.saveAndFlush(budget);
    }

    public void remove(Budget budget){
        budgetRepository.delete(budget);
    }

    public Budget getById(long id) {
        return budgetRepository.findById(id).get();
    }
}
