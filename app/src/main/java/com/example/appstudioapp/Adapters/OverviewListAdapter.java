package com.example.appstudioapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appstudioapp.ComputerBuild;
import com.example.appstudioapp.MainActivity;
import com.example.appstudioapp.R;

public class OverviewListAdapter extends BaseAdapter {

    Context context;
    private LayoutInflater inflater;


    public OverviewListAdapter(Context context){
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
                               @Override
    public int getCount() {
        return ComputerBuild.getInstance().getAllParts().size();
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
            v = inflater.inflate(R.layout.overview_list_cell, null);
        } else {
            v = convertView;
        }

        TextView type = v.findViewById(R.id.partType_TextView);
        TextView name = v.findViewById(R.id.partName_TextView);
        TextView price = v.findViewById(R.id.partPrice_TextView);
        type.setText(ComputerBuild.getInstance().getAllParts().get(position).getPartType().name());
        name.setText(ComputerBuild.getInstance().getAllParts().get(position).getPartChosen());
        double amount = ComputerBuild.getInstance().getAllParts().get(position).getPartPrice();
        if(amount != 0){
            price.setText(ComputerBuild.getInstance().getAllParts().get(position).getPartPrice()+"");
        }

        return v;
    }
}
