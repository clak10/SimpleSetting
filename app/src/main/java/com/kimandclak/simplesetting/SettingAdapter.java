package com.kimandclak.simplesetting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**

 * {@link SettingAdapter} is an {@link ArrayAdapter} that can provide the layout for each list

 * based on a data source, which is a list of {@link SettingObject} objects.

 **/
public class SettingAdapter extends ArrayAdapter<SettingObject> {

    public SettingAdapter(Context context, ArrayList<SettingObject> objects) {
        super(context, 0, objects);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    <p>
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        //Getting the SettingObject at the current position
        SettingObject settingObject = getItem(position);
        assert settingObject != null;
        ViewHolder viewHolder;

        // Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.simple_list_item_for_settings,
                    parent, false);

            //Bind the views using the IDs
            viewHolder.mainText = convertView.findViewById(R.id.view_text1);
            viewHolder.descriptions = convertView.findViewById(R.id.view_text2);
            if(settingObject.isSettingsView()) {
                LinearLayout rootLayout = convertView.findViewById(R.id.list_root_layout);
                rootLayout.addView(settingObject.getmSettingsView());
                viewHolder.settingsView = settingObject.getmSettingsView();
            }

            //Save ViewHolder object as Tag to convertView
            convertView.setTag(viewHolder);

        } else {
            //get viewHolder from recycled view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mainText.setText(settingObject.getmTitle());
        viewHolder.descriptions.setText(settingObject.getmDescription());

        return convertView;
    }

    /**
     * The ViewHolder is a static inner class of SettingAdapter class used to hold the views for faster recycling
     */

    static class ViewHolder {
        TextView mainText;
        TextView descriptions;
        View settingsView;

    }
}
