package com.example.cookforyou.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cookforyou.R


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: SettingsFragment fragment from Navigation bar, will contain user settings
 */
class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
}