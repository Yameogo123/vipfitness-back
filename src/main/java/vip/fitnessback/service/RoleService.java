package vip.fitnessback.service;

import vip.fitnessback.model.Role;
import vip.fitnessback.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> allRole(){
        return roleRepository.findAll();
    }

    public Role addRole(Role role){
        return roleRepository.saveAndFlush(role);
    }

    public Role getRole(String name){
        return roleRepository.findByRoleName(name);
    }

    public List<Role> addListRoles(List<Role> roles){
        return roleRepository.saveAllAndFlush(roles);
    }
}

