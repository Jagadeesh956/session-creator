package com.self.learn.springbootapp.dao;
//Session Session Management Service
//Context: We need a service to manage user sessions within our platform. A session is created when a user logs in and is updated as they interact with the system.
//Objective: Implement a RESTful API using Java and Spring Boot that allows the system to manage these sessions.
//Functional Requirements:
//Create a Session: A user should be able to start a new session.
//Retrieve a Session: Look up a specific session using its unique identifier.
//List Session Sessions: Retrieve all sessions belonging to a specific userId.
//Update Session: Update the session's state (e.g., changing the "Last Activity" timestamp or a status flag).
//Constraints:
//You may use an in-memory data structure (like a Map) for persistence.
//Focus on making the code production-ready and maintainable.
//The design of the API and the internal data structure is entirely up to you.

//<SessionId,

import java.util.UUID;
public class Session {

    private long userID;

    private UUID sessionId;

    private String Status;

    private long LastActive;

    public Session(long userID, UUID sessionId, String status, long lastActive) {
        this.userID = userID;
        this.sessionId = sessionId;
        Status = status;
        LastActive = lastActive;

    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public long getLastActive() {
        return LastActive;
    }

    public void setLastActive(long lastActive) {
        LastActive = lastActive;
    }
}
