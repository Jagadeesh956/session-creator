package com.spring.learn.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.learn.sessiondao.Session;

import java.util.List;
import java.util.UUID;

public class User {
    private long UserID;
      @JsonIgnore
    private List<Session> userSessions;

    public List<Session> getUserSessions() {
        return userSessions;
    }

    public User(long userID) {
        UserID = userID;
    }

    public void setUserSessions(List<Session> userSessions) {
        this.userSessions = userSessions;
    }

    public User() {
        UserID = System.currentTimeMillis();
    }


    public long getUserID() {
        return UserID;
    }

    public void setUserID(long userID) {
        this.UserID = userID;
    }


}
