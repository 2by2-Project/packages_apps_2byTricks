/*
 * Copyright (C) 2025 The 2by2 Project
 * SPDX-License-Identifier: Apache-2.0
 */

package jp.project2by2.settings.preferences;

import android.content.Context;
import android.os.SystemProperties;
import android.util.AttributeSet;

import com.android.settings.custom.preference.SelfRemovingSwitchPreference;

import com.android.settingslib.development.SystemPropPoker;

public class SystemPropertySwitchPreference extends SelfRemovingSwitchPreference {

    public SystemPropertySwitchPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SystemPropertySwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SystemPropertySwitchPreference(Context context) {
        super(context);
    }

    @Override
    protected boolean isPersisted() {
        return !SystemProperties.get(getKey(), "").isEmpty();
    }

    @Override
    protected void putBoolean(String key, boolean value) {
        SystemProperties.set(key, Boolean.toString(value));
        SystemPropPoker.getInstance().poke();
    }

    @Override
    protected boolean getBoolean(String key, boolean defaultValue) {
        return SystemProperties.getBoolean(key, defaultValue);
    }
}
