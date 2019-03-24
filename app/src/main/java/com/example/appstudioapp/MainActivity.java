package com.example.appstudioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.appstudioapp.Adapters.OverviewListAdapter;

public class MainActivity extends AppCompatActivity {
    int RESULT_CODE = 123;
    int REQUEST_CODE = 456;
    ListView buildListView;
    OverviewListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkElements();
        initListView();
    }

    private void linkElements(){
        buildListView = findViewById(R.id.build_ListView);
    }

    private void initListView(){
        listAdapter = new OverviewListAdapter(this);
        buildListView.setAdapter(listAdapter);
        buildListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PartType partType =  ComputerBuild.getInstance().getAllParts().get(position).getPartType();
                gotoPartPicker(partType);
            }
        });
    }

    public void gotoPartPicker(PartType type){
        Intent intent = new Intent(MainActivity.this, PartPickerActivity.class);
        intent.putExtra("TYPE", type);
        startActivityForResult(intent, REQUEST_CODE);
        //startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_CODE){
                listAdapter.notifyDataSetChanged();
            }
        }
    }
}
