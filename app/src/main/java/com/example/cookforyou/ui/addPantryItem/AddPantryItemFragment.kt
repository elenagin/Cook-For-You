package com.example.cookforyou.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cookforyou.R


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: SettingsFragment fragment from Navigation bar
 */
class AddPantryItemFragment : Fragment() {

    private lateinit var addPantryItemViewModel: AddPantryItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addPantryItemViewModel =
            ViewModelProvider(this).get(AddPantryItemViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        val textView: TextView = root.findViewById(R.id.text_settings)
        addPantryItemViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}