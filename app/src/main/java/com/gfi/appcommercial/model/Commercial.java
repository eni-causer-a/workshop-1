package com.gfi.appcommercial.model;

public class Commercial {

    /**
     * Commercial email
     */
    private String email;

    /**
     * Commercial password
     */
    private String password;

    /**
     * Commercial name
     */
    private String name;

    public Commercial(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
