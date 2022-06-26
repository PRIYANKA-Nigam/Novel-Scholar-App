package com.example.novelscholar;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DictionaryRequest extends AsyncTask<String, Integer, String> {
    Context context;
    TextView textView;

    public DictionaryRequest(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }
    @Override
    protected String doInBackground(String... params) {
        final String app_id = "fdf9b127";
        final String app_key = "c7632c884e4d06e380d4c27b4343bef8";
        try {
            URL url = new URL(params[0]);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setRequestProperty("app_id",app_id);
            urlConnection.setRequestProperty("app_key",app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        }
        catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        String def;
        try {
            JSONObject js=new JSONObject(result);
            JSONArray results=js.getJSONArray("results");
            JSONObject iEnteries=results.getJSONObject(0);
            JSONArray isArray =iEnteries.getJSONArray("lexicalEntries");
            JSONObject entries=isArray.getJSONObject(0);
            JSONArray e=entries.getJSONArray("entries");
            JSONObject jsonObject=e.getJSONObject(0);
            JSONArray senArray=jsonObject.getJSONArray("senses");
            JSONObject de=senArray.getJSONObject(0);
            JSONArray d=de.getJSONArray("definitions");
            def=d.getString(0);
            textView.setText(def);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
