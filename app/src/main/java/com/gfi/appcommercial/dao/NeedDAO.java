package com.gfi.appcommercial.dao;

import android.app.Application;
import android.util.Log;

import com.gfi.appcommercial.mocks.NeedMock;
import com.gfi.appcommercial.model.Need;
import com.gfi.appcommercial.utils.ApiConnector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class NeedDAO {

    /**
     * Pre-initialized instance of the DAO
     */
    private static NeedDAO instance = new NeedDAO();

    private NeedMock mock;

    public static NeedDAO getInstance() {
        return instance;
    }

    public NeedDAO() {
        mock = new NeedMock();
    }
    /**
     * List of need sheets, retrieved from server
     *
     * @return ArrayList
     */
    public List<Need> getAll() {
        // todo: implement

        ApiConnector connector = new ApiConnector();
        String response = connector.getData(ApiConnector.NEED, "GET", "");

        Log.i("AppCommercial", response);

        return convertJSONArrayToNeedList(response);
    }

    /**
     * Retrieve a need by its title
     *
     * @param title need sheet title (unique)
     * @return Need
     */
    public Need get(String title) {
        // todo: implement
        return mock.getNeeds(1).get(0);
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

    public List<Need> convertJSONArrayToNeedList(String raw) {

        List<Need> needs = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(raw);

            for (int i=0 ; i < jsonArray.length() ; i++) {
                needs.add(convertJSONObject(jsonArray.getJSONObject(i)));
            }
        }
        catch (JSONException e) {
            Log.e("AppCommerciak", e.getMessage());
        }

        return needs;
    }

    public Need convertJSONObject(JSONObject obj) {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.FRANCE);

        try {
            return new Need(
                    obj.getString("commercial"),
                    obj.getString("client"),
                    obj.getString("contactName"),
                    obj.getString("title"),
                    obj.getString("fullDescription"),
                    obj.getString("location"),
                    obj.getString("geolocation"),
                    obj.getString("status"),
                    new ArrayList<String>(),
                    new ArrayList<String>(),
                    obj.getInt("durationMonths"),
                    obj.getInt("durationDaysPerWeek"),
                    formatter.parse(obj.getString("startAtLatest")),
                    formatter.parse(obj.getString("date")),
                    new HashMap<String, File>()
            );
        }
        catch (JSONException | ParseException e) {
            Log.e("AppCommercial", e.getMessage());

            return null;
        }
    }
}
