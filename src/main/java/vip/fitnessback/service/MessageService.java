package vip.fitnessback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.fitnessback.model.Message;
import vip.fitnessback.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message newMessage(Message message){
        return messageRepository.saveAndFlush(message);
    }

    public Message updateMessage(Message message){
        return messageRepository.save(message);
    }

    public List<Message> allMessages(){
        return messageRepository.findAll();
    }

    public void delete(Message message){
        messageRepository.delete(message);
    }

    public Message getById(long id){
        return messageRepository.findById(id).get();
    }
}
