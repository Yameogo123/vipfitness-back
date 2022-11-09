package vip.fitnessback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.fitnessback.model.Pub;

@Repository
public interface PubRepository extends JpaRepository<Pub, Long> {
}
