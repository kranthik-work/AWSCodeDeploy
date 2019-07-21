package com.kkalletla.AWSCodeDeploy.service;

import org.kranthi.application.database.DatabaseClass;
import org.kranthi.application.exception.DataNotFoundException;
import org.kranthi.application.model.Comment;
import org.kranthi.application.model.Message;

import java.util.*;


public class MessageService {

    private Map<Long,Message> messages = DatabaseClass.getMessages();

    public MessageService(){
        Map<Long,Comment> comments1 = new HashMap<>();
        Map<Long,Comment> comments2 = new HashMap<>();
        comments1.put(1L, new Comment(1L,"Hey! How are you?", "Kiran"));
        comments1.put(2L, new Comment(2L,"Am Fine THank you.", "Kranthi"));
        comments1.put(3L, new Comment(3L,"How are you?", "Kranthi"));
        comments2.put(1L, new Comment(1L,"Hey! How are you?", "Kiran"));

        messages.put(1L,new Message(1L, "Hello There.....","Kranthi",comments1));
        messages.put(2L, new Message(2L, "Hello Here.....","Kranthi",comments2));
    }
    public List<Message> getMessages(){
        return new ArrayList<Message>(messages.values());
    }

    public List<Message> getAllMessagesForYear(short year){
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for(Message msg:messages.values()){
            cal.setTime(msg.getDate());
            if(cal.get(Calendar.YEAR)==year)
                messagesForYear.add(msg);
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size){
        ArrayList<Message> messagesPaginated = new ArrayList<>(messages.values());
        if(start + size > messagesPaginated.size())
            return messagesPaginated;
        return messagesPaginated.subList(start,(start + size >= messagesPaginated.size()) ? messagesPaginated.size() : size);
    }

    public Message getMessage(Long id){
        Message returnMessage = messages.get(id);
        if(returnMessage == null)
            throw new DataNotFoundException("Error caused as there is no value to return");
        return messages.get(id);
    }

    public Message addMessage(Message message){
        message.setId(messages.size()+1);
        messages.put(message.getId(),message);
        return message;
    }

    public Message updateMessage(Message message){
        if(message.getId() <=0)
            return null;
        messages.put(message.getId(),message);
        return message;
    }

    public Message removeMessage(Long id){
        return messages.remove(id);
    }
}
