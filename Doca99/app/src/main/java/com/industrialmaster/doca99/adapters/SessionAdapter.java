package com.industrialmaster.doca99.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.industrialmaster.doca99.BookActivity;
import com.industrialmaster.doca99.R;
import com.industrialmaster.doca99.entity.Session;
import java.util.ArrayList;

public class SessionAdapter extends ArrayAdapter<Session> implements View.OnClickListener{

    Context context;
    ArrayList<Session> data;
    public SessionAdapter(Context context, ArrayList<Session> data) {
        super(context, R.layout.session_list_item, data);
        this.context = context;
        this.data = data;
    }

    private static class viewHolder{
        TextView tvDoctor;
        TextView tvSpec;
        TextView tvHospital;
        TextView tvDate;
        Button btnSubmit;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Session session = getItem(position);

        viewHolder viewHolder;

        final View results;

        if(convertView == null){
            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
             convertView = inflater.inflate(R.layout.session_list_item, parent, false);

             viewHolder.tvDoctor = convertView.findViewById(R.id.tvDoctor);
             viewHolder.tvSpec = convertView.findViewById(R.id.tvSpeciality);
             viewHolder.tvHospital = convertView.findViewById(R.id.tvHospital);
             viewHolder.tvDate = convertView.findViewById(R.id.tvDate);
             viewHolder.btnSubmit = convertView.findViewById(R.id.btnBookNow);

             convertView.setTag(viewHolder);
        }else{
            viewHolder = (viewHolder) convertView.getTag();
            results = convertView;
        }

        viewHolder.tvDoctor.setText(session.getDoctorName());
        viewHolder.tvDate.setText(session.getDate());
        viewHolder.tvSpec.setText(session.getSpecialityName());
        viewHolder.tvHospital.setText(session.getHospitalName());
        viewHolder.btnSubmit.setOnClickListener(this);
        viewHolder.btnSubmit.setTag(position);

        return convertView;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Session session = getItem(position);
        Intent intent = new Intent(context, BookActivity.class);
        intent.putExtra("id", session.getId());
        context.startActivity(intent);
    }
}
