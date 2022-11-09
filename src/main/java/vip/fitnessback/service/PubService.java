package vip.fitnessback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.fitnessback.model.Pub;
import vip.fitnessback.repository.PubRepository;

import java.util.List;

@Service
public class PubService {

    @Autowired
    private PubRepository pubRepository;

    public List<Pub> all(){
        return pubRepository.findAll();
    }

    public Pub add(Pub pub){
        return pubRepository.saveAndFlush(pub);
    }

    public Pub update(Pub pub){
        return pubRepository.save(pub);
    }

    public void delete(Pub pub){
        pubRepository.delete(pub);
    }

    public Pub getOne(long id){
        return pubRepository.findById(id).get();
    }

    public Pub lastPub(){
        return all().get(all().size()-1);
    }
}
