package com.example.cookforyou.ui.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cookforyou.R

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: DiscoverFragment fragment from Navigation bar works as a search recipes module
 */
class DiscoverFragment : Fragment() {

    private lateinit var discoverViewModel: DiscoverViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.discoverViewModel = ViewModelProvider(this).get(DiscoverViewModel::class.java)
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }
}