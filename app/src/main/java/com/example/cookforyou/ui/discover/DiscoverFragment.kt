package com.example.cookforyou.ui.discover


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import kotlinx.android.synthetic.main.discover_card.view.*


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
    private lateinit var root: View
    //private lateinit var card: View
    //private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_discover, container, false)
        //card = inflater.inflate(R.layout.discover_card, container, false)
        //val imageButton = card.findViewById(R.id.discoverImage)
        //val title = card.findViewById(R.id.discoverName)


        loadData()
        rvFirestoreList = root.findViewById(R.id.rvDiscoverImages) as RecyclerView
        rvFirestoreList.layoutManager = GridLayoutManager(context, 2)
        rvFirestoreList.adapter = adapter

        /*imageView.setOnClickListener{
            val bundle = bundleOf("name" to title)
            findNavController().navigate(R.id.recipeFragment, bundle)
        }*/
        return root
    }

    /*fun onItemClick(view: View?, position: Int) {
        Log.d(TAG, "Clicked on a recipe")
    }*/

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
