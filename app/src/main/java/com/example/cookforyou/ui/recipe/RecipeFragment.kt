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
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cookforyou.R

private const val TAG = "RecipeFragment"


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: RecipesFragment fragment for RecipesItem, loads database data
 */
@Suppress("DEPRECATION")
class RecipeFragment : Fragment() {
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private lateinit var recipeName: TextView
    private lateinit var amountIngredient1: TextView
    private lateinit var unitIngredient1: TextView
    private lateinit var ingredient1: TextView
    private lateinit var amountIngredient2: TextView
    private lateinit var unitIngredient2: TextView
    private lateinit var ingredient2: TextView
    private lateinit var amountIngredient3: TextView
    private lateinit var unitIngredient3: TextView
    private lateinit var ingredient3: TextView
    private lateinit var description: TextView
    private lateinit var image: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.recipe_layout, container, false)
        recipeName = root.findViewById(R.id.label_recipe_name)
        amountIngredient1 = root.findViewById(R.id.label_amount_ingredient1)
        unitIngredient1 = root.findViewById(R.id.label_unit_ingredient1)
        ingredient1 = root.findViewById(R.id.label_ingredient1)
        amountIngredient2 = root.findViewById(R.id.label_amount_ingredient2)
        unitIngredient2 = root.findViewById(R.id.label_unit_ingredient2)
        ingredient2 = root.findViewById(R.id.label_ingredient2)
        amountIngredient3 = root.findViewById(R.id.label_amount_ingredient3)
        unitIngredient3 = root.findViewById(R.id.label_unit_ingredient3)
        ingredient3 = root.findViewById(R.id.label_ingredient3)
        description = root.findViewById(R.id.label_description)
        image = root.findViewById(R.id.recipe_imageView)


        val name = arguments?.getString("name")
        getCurrentRecipeData(name.toString())
        DownloadImageFromInternet(image)

        return root
    }

    @SuppressLint("StaticFieldLeak")
    private inner class DownloadImageFromInternet(var imageView: ImageView) :
        AsyncTask<String, Void, Bitmap?>() {
        init {
            Toast.makeText(context, "Loading image...", Toast.LENGTH_SHORT).show()
        }

        override fun doInBackground(vararg urls: String): Bitmap? {
            val imageURL = urls[0]
            var image: Bitmap? = null
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
            } catch (e: Exception) {
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
    private fun getCurrentRecipeData(Name: String) {
        firebaseRepo.getCurrentRecipe(Name).addOnCompleteListener {
            if (it.isSuccessful) {
                val recipe = it.result!!.toObjects(Recipe::class.java)
                Log.d(TAG, recipe.toString())
                recipeName.text = recipe.find { it.name == Name }?.name.toString()
                amountIngredient1.text =
                    recipe.find { it.name == Name }?.amount_ingredient1.toString()
                amountIngredient2.text =
                    recipe.find { it.name == Name }?.amount_ingredient2.toString()
                amountIngredient3.text =
                    recipe.find { it.name == Name }?.amount_ingredient3.toString()
                unitIngredient1.text = recipe.find { it.name == Name }?.unit_ingredient1.toString()
                unitIngredient2.text = recipe.find { it.name == Name }?.unit_ingredient2.toString()
                unitIngredient3.text = recipe.find { it.name == Name }?.unit_ingredient3.toString()
                ingredient1.text = recipe.find { it.name == Name }?.ingredient1.toString()
                ingredient2.text = recipe.find { it.name == Name }?.ingredient2.toString()
                ingredient3.text = recipe.find { it.name == Name }?.ingredient3.toString()
                description.text = recipe.find { it.name == Name }?.description.toString()
                DownloadImageFromInternet(image).execute(recipe.find { it.name == Name }?.image_url.toString())
            } else {
                Log.d(TAG, "Error")
            }
        }
    }
}
