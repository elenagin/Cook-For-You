package com.example.cookforyou.ui.recipe

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R

private const val TAG = "RecipesFragment"


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: RecipesFragment fragment for RecipesItem, loads database data
 */
@Suppress("DEPRECATION")
class RecipeFragment : Fragment() {
    private lateinit var rvFirestoreList: RecyclerView
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var recipesList: List<Recipe> = ArrayList()
    private var adapter: RecipeAdapter = RecipeAdapter(recipesList)
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadData()
        val root = inflater.inflate(R.layout.recipe_layout, container, false)
        //val textView: TextView = root.findViewById(R.id.text_settings)
        //var title = "KotlinApp"
        DownloadImageFromInternet(root.findViewById(R.id.recipe_imageView)).execute("https://images.unsplash.com/photo-1535332371349-a5d229f49cb5?ixlib=rb-1.2.1&w=1000&q=80")
        return root
    }

    @SuppressLint("StaticFieldLeak")
    private inner class DownloadImageFromInternet(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {
        init {
            Toast.makeText(context, "Please wait, it may take a few minute...",     Toast.LENGTH_SHORT).show()
        }
        override fun doInBackground(vararg urls: String): Bitmap? {
            val imageURL = urls[0]
            var image: Bitmap? = null
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
            }
            catch (e: Exception) {
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
            return image
        }
        override fun onPostExecute(result: Bitmap?) {
            imageView.setImageBitmap(result)
        }
    }


    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: load Data from FirebaseRepo
     */
    private fun loadData() {
        firebaseRepo.getRecipe().addOnCompleteListener {
            if (it.isSuccessful) {
                recipesList = it.result!!.toObjects(Recipe::class.java)
                Log.d(TAG, recipesList.toString())
                adapter.recipesList = recipesList
                adapter.notifyDataSetChanged()
            } else {
                Log.d(TAG, "Error")
            }
        }
    }
}
