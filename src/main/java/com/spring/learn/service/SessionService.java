package com.spring.learn.service;

import com.spring.learn.sessiondao.Session;
import com.spring.learn.sessiondao.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public String SaveSession(Long UserID, UUID sessionID, String status, long lastActive){
          sessionRepository.save(new Session(UserID,sessionID,status,lastActive));
          //System.out.println("saved successfully");
          return "Successfully Saved session";
      }
      public Session getSession(UUID id){
       Session session =  sessionRepository.getReferenceById(id);
        System.out.println(session.toString());
        return new Session(session.getUserID(),session.getSessionId(),session.getStatus(),session.getLastActive());
      }
      public Session updateStatus(UUID id){
        sessionRepository.updateStatus(id);
        return sessionRepository.getReferenceById(id);
      }
      public Session updateLastActiveTime(UUID id){
        Long time = System.currentTimeMillis();
        sessionRepository.updateTime(id,time);
        return sessionRepository.getReferenceById(id);
      }

      public List<Session> userTotalSessions(long Id){
       List<Session> allSessions = sessionRepository.userSessions(Id);
       return allSessions;
      }

}
