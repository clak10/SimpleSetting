package com.kimandclak.simplesetting;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class SettingAdapter extends ArrayAdapter<SettingObject> {

    public SettingAdapter(Context context, ArrayList<SettingObject> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SettingObject currentSettingObject = getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            viewHolder = new ViewHolder();
            if (currentSettingObject.getmSettingsView() instanceof AppCompatCheckBox) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.simple_list_item_2_single_check_box,
                        parent, false);
                viewHolder.mainText = convertView.findViewById(R.id.check_text1);
                viewHolder.descriptions = convertView.findViewById(R.id.check_text2);
                viewHolder.setSettingsView(convertView.findViewById(R.id.check_box1));
                convertView.setTag(viewHolder);
//                TextView nameTextView = (TextView)convertView.findViewById(R.id.check_text1);
//
//                nameTextView.setText(currentSettingObject.mMainText);
//
//                TextView numberTextView = convertView.findViewById(R.id.check_text2);
//
//                numberTextView.setText(currentSettingObject.getmDescription());
            } else {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.simple_list_item_2_single_switch,
                        parent, false);
                viewHolder.mainText = convertView.findViewById(R.id.switch_text1);
                viewHolder.descriptions = convertView.findViewById(R.id.switch_text2);
                viewHolder.settingsView = convertView.findViewById(R.id.switch1);
                SwitchCompat s = (SwitchCompat) viewHolder.settingsView;

                //Set listener to print to the log when switch is turn on.
                s.setOnCheckedChangeListener((e, f) -> {
                    if (s.isChecked())
                        Log.v("frog", "jump");
                });
                convertView.setTag(viewHolder);
//                TextView nameTextView = convertView.findViewById(R.id.switch_text1);
//
//                nameTextView.setText(currentSettingObject.mMainText);
//
//                TextView numberTextView = convertView.findViewById(R.id.switch_text2);
//
//                numberTextView.setText(currentSettingObject.getmDescription());
            }

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        assert currentSettingObject != null;
        viewHolder.mainText.setText(currentSettingObject.getmMainText());
        viewHolder.descriptions.setText(currentSettingObject.getmDescription());
        viewHolder.setSettingsView(currentSettingObject.getmSettingsView());


//        View iconView =  convertView.findViewById(R.id.check_box1);

        return convertView;
    }

    //Used to hold the views for faster recycling
    static class ViewHolder {
        TextView mainText;
        TextView descriptions;
        View settingsView;


        void setSettingsView(View settingsView) {
            this.settingsView = settingsView;
        }
    }
}
