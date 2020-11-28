package com.example.cookforyou.ui.discover

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.cookforyou.R

class DiscoverFragment : Fragment() {

    private lateinit var discoverViewModel: DiscoverViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.discoverViewModel = ViewModelProvider(this).get(DiscoverViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_discover, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_settings)
        this.discoverViewModel.text.observe(this.viewLifecycleOwner, {
            textView.text = it
        })*/
        return root
    }
}