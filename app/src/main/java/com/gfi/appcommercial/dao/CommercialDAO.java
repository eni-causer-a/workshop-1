package com.gfi.appcommercial.dao;

import com.gfi.appcommercial.model.Commercial;

/**
 * CommercialDAO
 *
 * Handles everything related to user (commercial) management
 */
public class CommercialDAO {

    /**
     * Commercial
     *
     * Stored to enable auto-login when token expires
     */
    private Commercial user;

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
        //todo: login, retrieve name and store it into the user object
        user = new Commercial(email, password);

        user.setName("Jean Dupont");
        
        return true;
    }

    /**
     * Get commercial name
     *
     * @return String
     */
    public String getName() {
        return user.getName();
    }
}
