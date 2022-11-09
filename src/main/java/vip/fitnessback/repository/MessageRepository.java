package vip.fitnessback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.fitnessback.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
