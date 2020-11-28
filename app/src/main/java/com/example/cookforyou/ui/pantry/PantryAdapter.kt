package com.example.cookforyou.ui.pantry

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import kotlinx.android.synthetic.main.pantry_card.view.*


class PantryAdapter(var pantryList: List<PantryItem>) :
    RecyclerView.Adapter<PantryAdapter.PantryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PantryHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PantryHolder(layoutInflater.inflate(R.layout.pantry_card, parent, false))
    }

    override fun onBindViewHolder(holder: PantryHolder, position: Int) {
        holder.render(pantryList[position])
    }

    override fun getItemCount(): Int = pantryList.size


    class PantryHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun render(pantryList: PantryItem) {
            itemView.label_name.text = pantryList.item
            itemView.label_amount.text = pantryList.amount.toString()
        }
    }
}



//view holders for all types of items
/*class DescViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(pantryItem: PantryItem){

    }
}

class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(pantryItem: PantryItem){

    }
}*/



/*override fun getItemViewType(position: Int): Int {
    return if (pantryList[position].post_type == 0L){
        POST_TYPE_DESC
    } else{
        POST_TYPE_IMAGE
    }
}*/