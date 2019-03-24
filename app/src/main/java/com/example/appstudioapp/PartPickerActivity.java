package com.example.appstudioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appstudioapp.Adapters.PartListAdapter;

import java.io.Serializable;

public class PartPickerActivity extends AppCompatActivity {

    int selectedItem = -1;
    TextView headerText;
    ListView partList;
    PartListAdapter partListAdapter;
    PartType partType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_picker);
        partType = (PartType) getIntent().getSerializableExtra("TYPE");

        linkElements();
        initListView();
        setTitle();
    }

    private void linkElements(){
        headerText = findViewById(R.id.partPickerHeader_TextView);
        partList = findViewById(R.id.partPicker_ListView);
    }

    private void setTitle(){
        headerText.setText(partType.name());
    }

    private void initListView(){
        partListAdapter = new PartListAdapter(this, partType);
        partList.setAdapter(partListAdapter);

        partList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(selectedItem == position){
                    ComputerPart part = partListAdapter.getPartAtIndex(position);
                    ComputerBuild.getInstance().addPart(part);
                    sendBackResult(part);
                } else {
                    selectedItem = position;
                }
            }
        });
    }

    private void sendBackResult(ComputerPart part){
        Intent intent = new Intent();
        //intent.putExtra("PART", (Serializable) part);
        setResult(123, intent);
        finish();
    }
}
