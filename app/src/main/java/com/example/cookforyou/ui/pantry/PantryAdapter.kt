package com.example.cookforyou.ui.pantry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import kotlinx.android.synthetic.main.pantry_card.view.*


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: PantryAdapter has holder for PantryFragment, adapts database info for recyclerview
 */
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

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: PantryHolder information holder for PantryAdapter
     */
    class PantryHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun render(pantryList: PantryItem) {
            itemView.label_name.text = pantryList.item
            itemView.label_amount.text = pantryList.amount.toString()
            itemView.label_unit.text = pantryList.unit
        }
    }

    /**
     * Receives all touch & gesture actions from user and responds.
     */
    /*private fun configuraItemTouchHelper() {
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT
        ) {

            /**
             * When users rearranges (moves), will override onMove and rearrange items from
             * view as well as notify the view model.
             */
            override fun onMove(
                recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val sourcePosition = viewHolder.adapterPosition
                val targetPosition = target.adapterPosition
                Collections.swap(tablaCosasViewModel.inventario, sourcePosition, targetPosition)
                adapter?.notifyItemMoved(sourcePosition, targetPosition)
                return true
            }

            /**
             * When users swipes, will override onSwiped and remove item from view as well as
             * update the view model.
             */
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (direction == ItemTouchHelper.LEFT) {
                    val dialogBuilder = AlertDialog.Builder(context)
                    dialogBuilder.setMessage("Are you sure you want to delete this Thingy?")
                        .setCancelable(false)
                        .setPositiveButton(
                            "Proceed"
                        ) { dialog, _ ->
                            dialog.run {
                                tablaCosasViewModel.remove(viewHolder.adapterPosition)
                                val rutaParaArchivo =
                                    context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                                File(rutaParaArchivo, "${this}.jpg").delete()
                                Log.d(TAG, rutaParaArchivo.toString())
                                cosaRecyclerView.adapter?.notifyItemRemoved(viewHolder.adapterPosition)
                                Log.d(TAG, "Deleted")
                            }
                        }
                        .setNegativeButton(
                            "Cancel"
                        ) { dialog, _ ->
                            dialog.run {
                                cosaRecyclerView.adapter?.notifyItemChanged(viewHolder.adapterPosition)
                                Log.d(TAG, "Cancelled")
                            }
                        }

                    val alert = dialogBuilder.create()
                    alert.setTitle("Delete Thingy?")
                    alert.show()
                }
            }
        }

        /**
         * Detected gesture acts on Recycler View
         */
        val gestureDetector = ItemTouchHelper(itemTouchCallback)
        gestureDetector.attachToRecyclerView(cosaRecyclerView)
    }*/
}