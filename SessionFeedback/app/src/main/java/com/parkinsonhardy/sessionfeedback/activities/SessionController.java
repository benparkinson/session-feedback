package com.parkinsonhardy.sessionfeedback.activities;

import com.parkinsonhardy.sessionfeedback.model.SessionCreationArgs;

import java.io.Serializable;

/**
 * Created by Ben on 24/01/2018.
 */
public class SessionController implements Serializable {

    private static SessionController instance;

    private SessionController() {}

    public static SessionController getInstance() {
        if (instance == null) {
            instance  = new SessionController();
        }
        return instance;
    }

    public String createNewSession(SessionCreationArgs args) {
        return null;
    }

    public String loadSession(SessionCreationArgs args) {
        return null;
    }

}
