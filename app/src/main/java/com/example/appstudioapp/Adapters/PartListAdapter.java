package com.example.appstudioapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appstudioapp.ComputerPart;
import com.example.appstudioapp.JsonReader;
import com.example.appstudioapp.PartType;
import com.example.appstudioapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PartListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    Context context;
    PartType type;
    ArrayList<ComputerPart> partArrayList;

    public PartListAdapter(Context context, PartType type){
        this.context = context;
        this.type = type;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        partArrayList = getPartArray();
    }

    @Override
    public int getCount() {
        return partArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;

        if (convertView == null) {
            v = inflater.inflate(R.layout.part_list_cell, null);
        } else {
            v = convertView;
        }

        TextView partName = v.findViewById(R.id.partName_TextView);
        TextView partPrice = v.findViewById(R.id.partPrice_TextView);
        partName.setText(partArrayList.get(position).getPartChosen());
        partPrice.setText(partArrayList.get(position).getPartPrice()+"");

        return v;
    }

    private String getPickedTypeJson(){
        JsonReader reader = new JsonReader();
        switch(type){
            case Motherboard:
                return reader.readJson(context, "motherboards.json");
            case GraphicsCard:
                return reader.readJson(context, "graphicscards.json");
            case Memory:
                return reader.readJson(context, "memory.json");
            case Processor:
                return reader.readJson(context, "processor.json");
            default:
                return "";
        }
    }

    private ArrayList<ComputerPart> getPartArray(){
        ArrayList<ComputerPart> partsArray = new ArrayList<>();

        String jsonString = getPickedTypeJson();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray parts = jsonObject.getJSONArray("part");
            for(int i = 0; i < parts.length(); i++){
                JSONObject part = parts.getJSONObject(i);
                ComputerPart computerPart = new ComputerPart(type);
                computerPart.setPartChosen(part.getString("name"));
                computerPart.setPartPrice(part.getDouble("price"));
                partsArray.add(computerPart);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return  partsArray;
    }

    public ComputerPart getPartAtIndex(int position){
        return partArrayList.get(position);
    }
}
