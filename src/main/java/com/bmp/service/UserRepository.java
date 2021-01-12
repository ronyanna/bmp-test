package com.bmp.service;

import com.bmp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    private Logger log= LoggerFactory.getLogger(UserRepository.class);

    public User findByUsername(String username){
        try{
            User user=new User("bmp","bmp");
            return user;
        }
        catch (Exception e){
           log.error("Error From findUserByName"+e);
        }
        return  null;
    }
}
