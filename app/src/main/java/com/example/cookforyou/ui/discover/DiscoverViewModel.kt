package com.example.cookforyou.ui.discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: DiscoverViewModel view model for Discover
*/
class DiscoverViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is discover Fragment"
    }
    val text: LiveData<String> = _text
}