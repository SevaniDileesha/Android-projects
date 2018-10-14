package com.industrialmaster.doca99.tasks;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.industrialmaster.doca99.util.DB;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorListTask extends AsyncTask <AutoCompleteTextView, Integer, List<String>>{

    AutoCompleteTextView actv;
    public Map<String, Integer> data = new HashMap<>();

    @Override
    protected List<String> doInBackground(AutoCompleteTextView... autoCompleteTextViews) {
        actv = autoCompleteTextViews[0];
        List<String> list = new ArrayList<>();

        String url = "http://idexserver.tk/im/channel/doctor/list.php";

        String response  = DB.request(url, "GET");

        try{
            JSONArray jsonArray = new JSONArray(response);

            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj = new JSONObject(jsonArray.getString(i));
                String text = obj.getString("name");
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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(actv.getContext(),android.R.layout.simple_list_item_1, strings);
        actv.setAdapter(adapter);
    }
}
