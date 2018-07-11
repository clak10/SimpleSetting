package com.kimandclak.simplesetting;

import android.content.Context;
import android.support.annotation.NonNull;
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

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        SettingObject currentSettingObject = getItem(position);
        assert currentSettingObject != null;
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            if (currentSettingObject.getmSettingsView() instanceof AppCompatCheckBox) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.simple_list_item_2_single_check_box,
                        parent, false);
                viewHolder.mainText = convertView.findViewById(R.id.check_text1);
                viewHolder.descriptions = convertView.findViewById(R.id.check_text2);
                viewHolder.setSettingsView(convertView.findViewById(R.id.check_box1));
                convertView.setTag(viewHolder);

            } else {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.simple_list_item_2_single_switch,
                        parent, false);
                SwitchCompat s = (SwitchCompat) viewHolder.settingsView;

                //Set listener to print to the log when switch is turn on.
                s.setOnCheckedChangeListener((e, f) -> {
                    if (s.isChecked())
                        Log.v("frog", "jump");
                });

                viewHolder.mainText = convertView.findViewById(R.id.switch_text1);
                viewHolder.descriptions = convertView.findViewById(R.id.switch_text2);
                viewHolder.settingsView = convertView.findViewById(R.id.switch1);

                convertView.setTag(viewHolder);

            }

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mainText.setText(currentSettingObject.getmMainText());
        viewHolder.descriptions.setText(currentSettingObject.getmDescription());
        viewHolder.setSettingsView(currentSettingObject.getmSettingsView());

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
