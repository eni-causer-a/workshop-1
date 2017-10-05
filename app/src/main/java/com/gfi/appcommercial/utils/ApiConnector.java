package com.gfi.appcommercial.utils;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnector {

    private static final String API_URL = "http://213.32.75.128/web/app.php/";

    public static final String NEED = "needs";
    public static final String COMMERCIAL = "commercials";
    public static final String CONSULTANT = "consultants";

    public String getData(String entity, String method, String content) {
        try {
            URL url = new URL(API_URL + entity + ".json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json");

            if (method.equals("POST" ) || method.equals("PUT")) {
                OutputStream os = connection.getOutputStream();
                os.write(content.getBytes());
                os.close();
            }

            if (connection.getResponseCode() == 400) {

                InputStream in = new BufferedInputStream(connection.getErrorStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder builder = new StringBuilder();

                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                Log.e("AppCommercial", builder.toString());
            }

            try {
                InputStream in = new BufferedInputStream(connection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder builder = new StringBuilder();

                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                return builder.toString();
            }
            catch (IOException e) {
                Log.e("AppCommercial", e.getMessage());
            }
            finally {
                connection.disconnect();
            }

        }
        catch (IOException e) {
            Log.e("AppCommercial", e.getMessage());
        }

        return "";
    }
}
