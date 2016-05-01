package com.example.marcos.fourinaline;


import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NodeData {

    String getResponse(String url) throws IOException {
        //String url = "http://172.24.2.95:3000/getGameData";
        StringBuffer response = new StringBuffer();
        try{
            url = "http://"+url;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        }catch (Exception e){
            response.append("Error");
        }
        return response.toString();
    }


    JSONObject toJSON(String data){
        try {
            JSONObject obj = new JSONObject(data);
            return obj;
        }catch (Exception e){
            return null;
        }
    }


}
