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
        return inflater.inflate(R.layout.add_pantry_item, container, false)
    }
}