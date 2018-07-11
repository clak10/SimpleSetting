package com.kimandclak.simplesetting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.SwitchCompat;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<SettingObject> arrayList = new ArrayList<>();
        arrayList.add(new SettingObject("One", "this is one", new SwitchCompat(this)));
        arrayList.add(new SettingObject("two", "this is two", new AppCompatCheckBox(this)));

        SettingAdapter adapter = new SettingAdapter(this, arrayList);

        ListView listView = findViewById(R.id.list_view_settings);

        listView.setAdapter(adapter);


    }
}
