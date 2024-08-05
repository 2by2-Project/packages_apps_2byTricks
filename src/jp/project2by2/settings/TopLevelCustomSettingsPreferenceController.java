/*
 * Copyright (C) 2024 The 2by2 Project
 * SPDX-License-Identifier: Apache-2.0
 */

package jp.project2by2.settings;

import android.content.Context;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class TopLevelCustomSettingsPreferenceController extends BasePreferenceController {

    public TopLevelCustomSettingsPreferenceController(Context context,
            String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }
}
