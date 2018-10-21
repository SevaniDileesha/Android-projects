package com.industrialmaster.doca99.tasks;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.industrialmaster.doca99.adapters.SessionAdapter;
import com.industrialmaster.doca99.entity.Session;
import com.industrialmaster.doca99.util.DB;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorSessionListTask extends AsyncTask<ListView, Integer, ArrayList<Session>> {
    ListView lv;
    String params;
    public Map<String, Integer> data = new HashMap<>();

    public  DoctorSessionListTask(int sid, int did, int hid){
        params = "?sid="+sid+"&hid"+hid+"&did"+did;
    }
    @Override
    protected ArrayList<Session> doInBackground(ListView... listViews) {
        lv = listViews[0];
        ArrayList<Session> list = new ArrayList<>();

        String url = "http://idexserver.tk/im/channel/doctor_session/list.php"+params;

        String response  = DB.request(url, "GET");

        try{
            JSONArray jsonArray = new JSONArray(response);

            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj = new JSONObject(jsonArray.getString(i));
                Session session = new Session(obj.getInt("id"),obj.getString("doctor_name"), obj.getString("speciality_name"), obj.getString("hospital_name"),obj.getString("date"));
//                data.put(i,obj.getInt("id"));
                list.add(session);
            }
        }catch (Exception e){
            System.err.println(e);
        }
        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<Session> strings) {
        SessionAdapter adapter = new SessionAdapter(lv.getContext(), strings);
        lv.setAdapter(adapter);
    }
}
