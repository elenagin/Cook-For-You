package com.example.cookforyou.ui.discover


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R

private const val TAG = "DiscoverFragment"


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: DiscoverFragment fragment for DiscoverItem, loads database data
 */
class DiscoverFragment : Fragment() {
    private lateinit var rvFirestoreList: RecyclerView
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var recipesList: MutableList<DiscoverItem> = ArrayList()
    private var adapter: DiscoverAdapter = DiscoverAdapter(recipesList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_discover, container, false)

        loadData()
        rvFirestoreList = root.findViewById(R.id.rvDiscoverImages) as RecyclerView
        rvFirestoreList.layoutManager = LinearLayoutManager(context)
        rvFirestoreList.adapter = adapter

        return root
    }


    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: load Data from FirebaseRepo
     */
    private fun loadData() {
        firebaseRepo.getRecipe().addOnCompleteListener {
            if (it.isSuccessful) {
                recipesList = it.result!!.toObjects(DiscoverItem::class.java)
                Log.d("DiscoverFragment", recipesList.toString())
                adapter.updateDataSet(recipesList)
            } else {
                Log.d(TAG, "Error")
            }
        }
    }

}
