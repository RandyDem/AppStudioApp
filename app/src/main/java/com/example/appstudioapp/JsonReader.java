package com.example.appstudioapp;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonReader {


    public String readJson(Context context, String filename){
        String json;
        try{
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
