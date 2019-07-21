package com.kkalletla.AWSCodeDeploy.service;


import com.kkalletla.AWSCodeDeploy.database.DatabaseClass;
import com.kkalletla.AWSCodeDeploy.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

    private Map<String,Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService(){
        profiles.put("Kranthi",new Profile(1L, "Kranthi", "Kranthi Kiran", "Kalletla"));
        profiles.put("Me", new Profile(2L, "AgainMe","Me","Again"));
    }
    public List<Profile> getProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName){
        System.out.println("In getProfile with "+profileName);
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty())
            return null;
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }

    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }
}
