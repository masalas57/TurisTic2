package com.example.fragmentmodule.ui.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.fragmentmodule.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}