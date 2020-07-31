package com.qienProgramma.controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qienProgramma.model.Messages;

@Service
@Transactional
public class MessageService {
	
	@Autowired
	MessageRepository mr;
	
	public Messages getById(long id) {
        return mr.findById(id).get();
    }
    public void inDeService() {
        mr.save(new Messages());
        System.out.println("We zijn in de service ");
    }

    public Messages addMessages(Messages messages){
        System.out.println("In messages Service");
        return mr.save(messages);
    }

    public Iterable<Messages> getAllMessages(){
        System.out.println("getAllMessages aangeroepen");
        return mr.findAll();
    }

    public void deleteMessagesById(long id) {
        System.out.println("DELETE IN SERVICE");
        mr.deleteById(id);
    }

    public Messages updateMessages(long id, Messages messages) {
        System.out.println("UPDATE MESSAGES BY ID");
        Messages msg = mr.findById(id).get();
        if(messages.getMessage() != null && msg.getMessage() != "") {
            msg.setMessage(messages.getMessage());
        }
        
        return mr.save(msg);
    }
}

