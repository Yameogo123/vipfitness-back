package vip.fitnessback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.fitnessback.model.Budget;

import java.time.LocalDate;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    Budget findBudgetByDate(LocalDate date);
}
