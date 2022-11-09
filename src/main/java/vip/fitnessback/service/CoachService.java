package vip.fitnessback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.fitnessback.model.Coach;
import vip.fitnessback.repository.CoachRepository;

import java.util.List;

@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    public List<Coach> all(){
        return coachRepository.findAll();
    }

    public List<Coach> allActive(){
        return coachRepository.findActive();
    }

    public Coach newCoach(Coach coach){
        return coachRepository.saveAndFlush(coach);
    }

    public Coach update(Coach coach){
        return coachRepository.save(coach);
    }

    public Coach getById(long id){
        return coachRepository.findById(id).get();
    }

    public void delete(Coach coach){
        coachRepository.delete(coach);
    }
}
