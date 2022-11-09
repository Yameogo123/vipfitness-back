package vip.fitnessback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vip.fitnessback.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select r from Role r where r.name= ?1")
    Role findByRoleName(String name);
}
