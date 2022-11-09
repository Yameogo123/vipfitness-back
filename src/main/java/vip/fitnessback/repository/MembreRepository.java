package vip.fitnessback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.fitnessback.model.Membre;

@Repository
public interface MembreRepository extends JpaRepository<Membre, Long> {
}
