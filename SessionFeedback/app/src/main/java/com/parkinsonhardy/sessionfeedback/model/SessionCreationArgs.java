package com.parkinsonhardy.sessionfeedback.model;

/**
 * Created by Ben on 24/01/2018.
 */
public class SessionCreationArgs {

    private final String email;
    private final int pin;

    public SessionCreationArgs(String email, int pin) {
        this.email = email;
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public int getPin() {
        return pin;
    }
}
