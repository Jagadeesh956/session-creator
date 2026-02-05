package com.self.learn.springbootapp.controllers;

import com.self.learn.springbootapp.dao.Session;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserSessions {

    Map<UUID,Session> sessionMap = new HashMap<>();
    Map<Long,List<Session>> userSessions = new HashMap<>();
    @GetMapping("/createSession")
    public Session createSession(@RequestParam Long Id){
         UUID sessionID = UUID.randomUUID();
         String status = "Active";
         long lastActive = System.currentTimeMillis();
       Session createdSession = new Session(Id,sessionID,status,lastActive);
           sessionMap.put(sessionID,createdSession);
           userSessions.computeIfAbsent(Id,k->new ArrayList<Session>());
           List<Session> currentUserSessionList = userSessions.get(Id);
           currentUserSessionList.add(createdSession);
           return createdSession;
    }
    @GetMapping("/getSession")
    public Session getSessionByID(@RequestParam UUID sessionID){
        return sessionMap.get(sessionID);
    }
    @GetMapping("/getallsessions")
    public List<Session> getAllSessions(@RequestParam  Long Id){
        return userSessions.get(Id);
    }
    @GetMapping("/updatesessionstatus")
    public Session updateSessionStatus(@RequestParam UUID ID){
        Session session = sessionMap.get(ID);
        session.setStatus("INACTIVE");
        return session;
    }
     @GetMapping("/updateSessionTime")
    public Session updateSessionTime(@RequestParam UUID ID){
        Session session = sessionMap.get(ID);
        session.setLastActive(System.currentTimeMillis());
        return session;
    }
    //Look up a specific session using its unique identifier

}
