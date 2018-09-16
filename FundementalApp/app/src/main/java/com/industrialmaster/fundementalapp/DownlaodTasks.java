package com.industrialmaster.fundementalapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.URL;

public class DownlaodTasks extends AsyncTask<ImageView, Integer, Bitmap> {

    ImageView tv;
    @Override
    protected Bitmap doInBackground(ImageView... tvs) {
        tvs[0] = tv;
        Bitmap bmp = null;
        try {
            URL url = new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
            InputStream in = url.openConnection().getInputStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }

    protected void onPostExecute(Bitmap b){
        tv.setImageBitmap(b);
    }
}
