package vip.fitnessback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.fitnessback.model.Message;
import vip.fitnessback.service.MessageService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> all(){
        return messageService.allMessages();
    }

    @PostMapping("/new")
    public Message newMess(@RequestBody Message message){
        return messageService.newMessage(message);
    }

    @PutMapping("/update")
    public Message update(@RequestBody Message message){
        return messageService.updateMessage(message);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        Message message= messageService.getById(id);
        messageService.delete(message);
    }


}
