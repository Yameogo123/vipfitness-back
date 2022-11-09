package vip.fitnessback.service;

import vip.fitnessback.model.User;
import vip.fitnessback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public User newUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public List<User> allUser(){
        return  userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUsername(username);
        Collection<SimpleGrantedAuthority> authorities= new ArrayList<>();
        if(user== null){
            throw new UsernameNotFoundException("utilisateur inexistant");
        }else{
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
        }
        return  new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    public User getById(long id){
        return userRepository.findById(id).get();
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
