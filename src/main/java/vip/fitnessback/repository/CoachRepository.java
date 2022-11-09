package vip.fitnessback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vip.fitnessback.model.Coach;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

    @Query("select c from Coach c where c.active= true")
    List<Coach> findActive();
}
