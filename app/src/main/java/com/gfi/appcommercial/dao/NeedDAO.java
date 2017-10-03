package com.gfi.appcommercial.dao;

import com.gfi.appcommercial.model.Need;

import java.util.ArrayList;
import java.util.List;

public class NeedDAO {

    /**
     * Pre-initialized instance of the DAO
     */
    private static NeedDAO instance = new NeedDAO();

    public static NeedDAO getInstance() {
        return instance;
    }

    /**
     * List of need sheets, retrieved from server
     *
     * @return ArrayList
     */
    public List<Need> getAll() {
        // todo: implement
        return new ArrayList<>();
    }

    /**
     * Retrieve a need by its title
     *
     * @param title need sheet title (unique)
     * @return Need
     */
    public Need get(String title) {
        // todo: implement
        return new Need();
    }

    /**
     * Add a new need in the server
     *
     * @param need Need to be added in the server
     * @return wether or not the need has been posted on the server
     */
    public boolean post(Need need) {
        // todo: implement
        return true;
    }

    /**
     * Update an existing need in the server
     *
     * @param need Need to be modified in the server
     * @return wether or not the need has been updated on the server
     */
    public boolean update(Need need) {
        // todo: implement
        return true;
    }
}
