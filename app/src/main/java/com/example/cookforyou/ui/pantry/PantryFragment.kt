package com.example.cookforyou.ui.pantry

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import kotlinx.android.synthetic.main.fragment_pantry.*
import java.util.*

class PantryFragment : Fragment(), Observer {
    private var mCakeListAdapter: CakeCardAdapter? = null
    //private lateinit var pantryViewModel: PantryViewModel
    //private lateinit var rvPantryList: RecyclerView
    //private lateinit var cakeListView: ListView: ListView
    //private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //pantryViewModel = ViewModelProviders.of(this).get(PantryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pantry, container, false)
        //rvPantryList = root.findViewById(R.id.rvPantryList) as RecyclerView
        CakeModel.addObserver(this)
        val dataList: ListView = root.findViewById(R.id.rvPantryList)
        val data: ArrayList<Cake> = ArrayList()
        Log.d("PantryFragment", data.toString())
        mCakeListAdapter = context?.let { CakeCardAdapter(it, R.layout.cake_card_item, data) }
        dataList.adapter = mCakeListAdapter
        return root
    }

    override fun update(o: Observable?, arg: Any?) {
        mCakeListAdapter?.clear()

        val data = CakeModel.getData()
        if (data != null) {
            mCakeListAdapter?.clear()
            mCakeListAdapter?.addAll(data)
            mCakeListAdapter?.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        CakeModel.addObserver(this)
    }

    override fun onPause() {
        super.onPause()
        CakeModel.deleteObserver(this)
    }

    override fun onStop() {
        super.onStop()
        CakeModel.deleteObserver(this)
    }
}

/*pantryViewModel =
ViewModelProviders.of(this).get(PantryViewModel::class.java)
val root = inflater.inflate(R.layout.fragment_pantry, container, false)
rvPantryList = root.findViewById(R.id.rvPantryList) as RecyclerView
rvPantryList.layoutManager = LinearLayoutManager(context)
val data: ArrayList<PantryItem> = ArrayList()
Log.d("PantryFragment", data.toString())
val adapter = CakeCardAdapter(this, R.layout.pantry_card, data)
rvPantryList.adapter = adapter
Log.d("PantryFragment", data.toString())
*/
//val dataList : ListView = findViewById(R.id.fragment_pantry)
//mCakeListAdapter = CakeCardAdapter(this, R.layout.pantry_card, data)
//dataList.adapter = mCakeListAdapter