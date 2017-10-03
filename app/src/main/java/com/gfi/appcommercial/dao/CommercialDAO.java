package com.gfi.appcommercial.dao;

/**
 * CommercialDAO
 *
 * Handles everything related to user (commercial) management.
 * It only handles login in this POC but could also handle password change, signup and such.
 */
public class CommercialDAO {

    /**
     * Commercial email
     *
     * Stored to enable auto-login when token expires
     */
    private String email;

    /**
     * Commercial password
     *
     * Stored to enable auto-login when token expires
     */
    private String password;

    /**
     * Singleton instance
     */
    private static CommercialDAO instance;

    /**
     * Singleton getter
     * @return CommercialDAO
     */
    public static synchronized CommercialDAO getInstance() {
        if (instance == null) {
            instance = new CommercialDAO();
        }

        return instance;
    }

    /**
     *
     * @param email commercial email
     * @param password commercial password
     * @return login success
     */
    public boolean login(String email, String password) {
        this.email = email;
        this.password = password;

        return true;
    }
}
