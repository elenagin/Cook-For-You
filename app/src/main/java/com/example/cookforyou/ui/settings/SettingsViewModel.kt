package com.example.cookforyou.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: SettingsViewModel view model for Settings
 */
class SettingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "User settings here"
    }
    val text: LiveData<String> = _text
}