package com.spring.learn.service;

import com.self.learn.session.dao.Session;
import com.self.learn.session.dao.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public String SaveSession(Long UserID, UUID sessionID, String status, long lastActive){
          sessionRepository.save(new Session(UserID,sessionID,status,lastActive));
          System.out.println("saved succesfully");
          return "Successfully Saved session";
      }
      public Session getSession(UUID id){
       Session session =  sessionRepository.getReferenceById(id);
        System.out.println(session.toString());
        return new Session(session.getUserID(),session.getSessionId(),session.getStatus(),session.getLastActive());
      }
}
