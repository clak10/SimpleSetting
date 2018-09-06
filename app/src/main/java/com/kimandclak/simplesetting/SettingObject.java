package com.kimandclak.simplesetting;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * {@link SettingObject} represents a single Android platform release.
 * <p>
 * Each object has 3 properties: Title, Description and either a check box, a switch or none
 **/

public class SettingObject {
    private String mTitle;
    private String mDescription;
    private View mSettingsView;
    private boolean hasSettingsView = false;

    /**
     * Constructor for creating a new SettingObject
     *
     * @param Title        is the main title of the settings field.
     * @param descriptions is the description of the settings field.
     * @param settingsView is the type of view item to accompany the setting field either a check box, a switch or none
     */
    public SettingObject(String Title, String descriptions, @NonNull View settingsView) {
        mTitle = Title;
        mDescription = descriptions;
        mSettingsView = settingsView;
        hasSettingsView = true;
    }

    /**
     * Constructor for creating a new SettingObject
     *
     * @param Title        is the main title of the settings field.
     * @param descriptions is the description of the settings field.
     */
    public SettingObject(String Title, String descriptions) {
        mTitle = Title;
        mDescription = descriptions;
    }


    /**
     * @return the title
     */
    public String getmTitle() {
        return mTitle;
    }

    /**
     * @return the description
     */
    public String getmDescription() {
        return mDescription;
    }

    /**
     * @return the settingsView item
     */
    public View getmSettingsView() {
        return mSettingsView;
    }

    /**
     * @return true if Setting Object is created with settingsView item
     */
    public boolean isSettingsView() {
        return hasSettingsView;
    }

    public void onClick(){

    }
}
