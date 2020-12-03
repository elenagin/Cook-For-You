package com.example.cookforyou.ui.pantry

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: Receives all touch & gesture actions from user and responds.
 */
class SwipeToDelete (private var adapter: PantryAdapter) :ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }


    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val pos = viewHolder.adapterPosition
        adapter.deletePantryItem(pos)
    }

}