package com.industrialmaster.doca99.tasks;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.industrialmaster.doca99.util.DB;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorSessionListTask extends AsyncTask<ListView, Integer, List<String>> {
    ListView lv;
    String params;
    public Map<String, Integer> data = new HashMap<>();

    public  DoctorSessionListTask(int sid, int did, int hid){
        params = "?sid="+sid+"&hid"+hid+"&did"+did;
    }
    @Override
    protected List<String> doInBackground(ListView... listViews) {
        lv = listViews[0];
        List<String> list = new ArrayList<>();

        String url = "http://idexserver.tk/im/channel/doctor_session/list.php"+params;

        String response  = DB.request(url, "GET");

        try{
            JSONArray jsonArray = new JSONArray(response);

            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj = new JSONObject(jsonArray.getString(i));
                String text = obj.getString("doctor_name") +"-"+ obj.getString("date");
                data.put(text,obj.getInt("id"));
                list.add(text);
            }
        }catch (Exception e){
            System.err.println(e);
        }
        return list;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(lv.getContext(),android.R.layout.simple_list_item_1, strings);
        lv.setAdapter(adapter);
    }
}
