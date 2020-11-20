package com.example.cookforyou.ui.pantry

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.cookforyou.R


class CakeCardAdapter(context: Context, resource: Int, list: ArrayList<Cake>) :
    ArrayAdapter<Cake>(context, resource, list) {
    private var mResource: Int = 0
    private var mList: ArrayList<Cake>
    private var mLayoutInflator: LayoutInflater
    private var mContext: Context = context

    init {
        this.mResource = resource
        this.mList = list
        this.mLayoutInflator =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val returnView: View?
        if (convertView == null) {
            returnView = try {
                mLayoutInflator.inflate(mResource, null)
            } catch (e: Exception) {
                e.printStackTrace()
                View(context)
            }
            if (returnView != null) {
                setUI(returnView, position)
            }
            return returnView
        }
        setUI(convertView, position)
        return convertView
    }

    private fun setUI(view: View, position: Int) {
        val cake: Cake? = if (count > position) getItem(position) else null

        val cakeName: TextView? = view.findViewById(R.id.cake_card_name)
        cakeName?.text = cake?.name ?: ""

        val cakeDateBaked: TextView? = view.findViewById(R.id.cake_card_date_bake)
        cakeDateBaked?.text = cake?.dateBaked ?: ""

        val cakeExpiryDate: TextView? = view.findViewById(R.id.cake_card_expiry_date)
        cakeExpiryDate?.text = cake?.expiryDate ?: ""
    }
}