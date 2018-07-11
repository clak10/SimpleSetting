package com.kimandclak.simplesetting;

import android.view.View;

public class SettingObject {
    public String mMainText;
    public String mDescription;
    public View mSettingsView;

    public SettingObject(String mainText, String descriptions, View settingsView) {
        mMainText = mainText;
        mDescription = descriptions;
        mSettingsView = settingsView;
    }

    public String getmMainText() {
        return mMainText;
    }

    public String getmDescription() {
        return mDescription;
    }

    public View getmSettingsView() {
        return mSettingsView;
    }
}