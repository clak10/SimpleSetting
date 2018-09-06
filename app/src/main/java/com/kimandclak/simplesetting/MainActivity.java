package com.kimandclak.simplesetting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.SwitchCompat;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of SettingObject objects
        ArrayList<SettingObject> arrayList = new ArrayList<>();
        SwitchCompat s1 = new SwitchCompat(this);
        SettingObject ob1 = new SettingObject("One", "this is one", s1);

        SwitchCompat s2 = new SwitchCompat(this);
        SettingObject ob2 = new SettingObject("Two", "this is two", s2);

        arrayList.add(ob1);
        arrayList.add(ob2);

        arrayList.add(new SettingObject("Three", "this is three", new AppCompatCheckBox(this)));

        SettingObject ob4 = new SettingObject("Four", "this is four"){
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "frog jump 4", Toast.LENGTH_SHORT).show();
            }
        };
        arrayList.add(ob4);

        //Set listener to create a toast when switch state is changed.
        s1.setOnCheckedChangeListener((e, f) -> {
            if (s1.isChecked())
                Toast.makeText(this, "frog jump 1", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "no frog jump 1", Toast.LENGTH_SHORT).show();
        });

        s2.setOnCheckedChangeListener((e, f) -> {
            if (s2.isChecked())
                Toast.makeText(this, "frog jump 2", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "no frog jump 2", Toast.LENGTH_SHORT).show();
        });


        // Create an SettingAdapter, whose data source is a list of
        // SettingObjects. The adapter knows how to create list item views for each item
        // in the list.
        SettingAdapter adapter = new SettingAdapter(this, arrayList);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = findViewById(R.id.list_view_settings);

        listView.setAdapter(adapter);

        // Setting on click listener for list item
        listView.setOnItemClickListener((parent, view, position, id)->{
            SettingObject settingObject = adapter.getItem(position);
            settingObject.onClick();
        });


    }
}
