package com.industrialmaster.doca99.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Nadun Shyn on 10/7/2018.
 */

public class DB {

    public static String request(String link, String method){
        String response = "";
        try{
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //Send Request
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));

            writer.flush();
            writer.close();
            os.close();

            int responseCode=conn.getResponseCode();
            //Read Response

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                InputStreamReader isr = new InputStreamReader(
                        conn.getInputStream());
                BufferedReader br=new BufferedReader(isr);
                String line;
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }

            System.out.println("RESPONSE = "+response);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
