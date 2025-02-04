package com.example.cookforyou.ui.addPantryItem

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cookforyou.R

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: AddPantryItemFragment fragment from Navigation bar
 */
class AddPantryItemFragment : Fragment() {
    private lateinit var root: View
    private lateinit var itemEditText: EditText
    private lateinit var unitEditText: EditText
    private lateinit var amountEditText: EditText
    private lateinit var item: String
    private lateinit var unit: String
    private var amount: Int = 0
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.add_pantry_item, container, false)
        val addButton = root.findViewById<Button>(R.id.button)
        itemEditText = root.findViewById(R.id.itemInput)
        item = itemEditText.text.toString()
        amountEditText = root.findViewById(R.id.amountInput)
        amount = amountEditText.text.toString().toInt()
        unitEditText = root.findViewById(R.id.unitInput)
        unit = unitEditText.text.toString()


        val observer = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                item = ""
                amount = 0
                unit = ""
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("AddPantryItemFragment", "onTextChanged")
                if (s != null) {
                    if (s.isEmpty()) {
                        item = ""
                        amount = 0
                        unit = ""
                    } else {
                        item = itemEditText.text.toString()
                        unit = unitEditText.text.toString()
                        amount = amountEditText.text.toString().toInt()
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("AddPantryItemFragment", "afterTextChanged")
            }
        }

        /**
         * Sets listeners for actions from user
         */
        itemEditText.addTextChangedListener(observer)
        amountEditText.addTextChangedListener(observer)
        unitEditText.addTextChangedListener(observer)


        addButton.setOnClickListener {
            val items = PantryItem(item, amount, unit)
            item = itemEditText.text.toString()
            amount = amountEditText.text.toString().toInt()
            unit = unitEditText.text.toString()
            addDataToDatabase(items)
            findNavController().navigate(R.id.navigation_pantry)
        }

        return root
    }

    /**
     * author: Elena Ginebra Z.
     * date: 01 Dec 2020
     * description: add Data to FirebaseRepo
     */
    private fun addDataToDatabase(items: PantryItem) {
        firebaseRepo.addToPantry(items).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(context, "Item added successfully", Toast.LENGTH_LONG).show()
            } else {
                Log.d("TAG", "Error")
            }
        }
    }
}