package com.kkalletla.AWSCodeDeploy.database;


import com.kkalletla.AWSCodeDeploy.model.Message;
import com.kkalletla.AWSCodeDeploy.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

    private static Map<Long,Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Long,Message> getMessages(){
        return messages;
    }

    public static Map<String,Profile> getProfiles(){
        return profiles;
    }

    public static void convertString(){
        for(Message msg: messages.values()){
            System.out.println("Message: "+msg.getId()+" Comment Count: "+msg.getComments().size());
        }
    }
}
