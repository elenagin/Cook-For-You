package com.example.cookforyou.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: HomeViewModel view model for Home
*/
class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text
}