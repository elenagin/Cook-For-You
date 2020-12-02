package com.example.cookforyou.ui.discover

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import kotlinx.android.synthetic.main.discover_card.view.*


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: DiscoverAdapter has holder for DiscoverFragment, adapts database info for recyclerview
 */
class DiscoverAdapter(private var recipesList: MutableList<DiscoverItem>) :
    RecyclerView.Adapter<DiscoverAdapter.DiscoverHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DiscoverHolder(layoutInflater.inflate(R.layout.discover_card, parent, false))
    }

    override fun onBindViewHolder(holder: DiscoverHolder, position: Int) {
        holder.render(recipesList[position])
    }

    override fun getItemCount(): Int = recipesList.size

    /**
     * author: Elena Ginebra Z.
     * date: 01 Dec 2020
     * description: DiscoverHolder information holder for DiscoverAdapter
     * */
    class DiscoverHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun render(recipesList: DiscoverItem) {
            itemView.discoverName.text = recipesList.name
            Log.d("recipe name", recipesList.name.toString())
            DownloadImageFromInternet(itemView.discoverImage).execute(recipesList.image_url.toString())
        }
    }

    fun updateDataSet(newDataSet: MutableList<DiscoverItem>){
        recipesList = newDataSet
        notifyDataSetChanged()
    }

    @SuppressLint("StaticFieldLeak")
    class DownloadImageFromInternet(var imageView: ImageView) :
        AsyncTask<String, Void, Bitmap?>() {
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
            Log.d("imageURL", imageURL)
            return image
        }

        override fun onPostExecute(result: Bitmap?) {
            imageView.setImageBitmap(result)
        }
    }
}