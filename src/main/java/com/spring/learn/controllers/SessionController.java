package com.spring.learn.controllers;

import com.self.learn.session.dao.Session;
import com.spring.learn.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    SessionService sessionService;
    Map<UUID, Session> sessionMap = new HashMap<>();
    Map<Long,List<Session>> userSessions = new HashMap<>();
    @GetMapping("/create")
    public Session createSession(@RequestParam Long Id){
         UUID sessionID = UUID.randomUUID();
         String status = "ACTIVE";
         long lastActive = System.currentTimeMillis();
       Session createdSession = new Session(Id,sessionID,status,lastActive);
       sessionService.SaveSession(Id,sessionID,status,lastActive);
           sessionMap.put(sessionID,createdSession);
           userSessions.computeIfAbsent(Id,k->new ArrayList<Session>());
           List<Session> currentUserSessionList = userSessions.get(Id);
           currentUserSessionList.add(createdSession);
           return createdSession;

    }
    @GetMapping("/get")
    public ResponseEntity<Session> getSessionByID(@RequestParam UUID Id) {
        Session session = sessionService.getSession(Id);
        if(session==null){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(session,HttpStatusCode.valueOf(200));
    }
    @GetMapping("/getall")
    public List<Session> getAllSessions(@RequestParam  Long Id){
        return userSessions.get(Id);
    }
    @GetMapping("/updatestatus")
    public Session updateSessionStatus(@RequestParam UUID Id){
        Session session = sessionMap.get(Id);
        session.setStatus("INACTIVE");
        return session;
    }
     @GetMapping("/updateTime")
    public Session updateSessionTime(@RequestParam UUID ID){
        Session session = sessionMap.get(ID);
        session.setLastActive(System.currentTimeMillis());
        return session;
    }
    //Look up a specific session using its unique identifier

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, String>> handleMissingParams(MissingServletRequestParameterException ex) {
        String paramName = ex.getParameterName();
        Map<String, String> error = new HashMap<>();
        error.put("error", "Missing required parameter: " + paramName);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }




}
