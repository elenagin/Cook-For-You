package com.example.cookforyou.ui.pantry

import android.util.Log
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList

object CakeModel : Observable() {

    private var mValueDataListener: ValueEventListener? = null
    private var mCakeList: ArrayList<Cake>? = ArrayList()


    private fun getDatabaseRef(): DatabaseReference? {
        return FirebaseDatabase.getInstance().reference.child("cake")
    }

    init {
        if (mValueDataListener != null) {
            getDatabaseRef()?.removeEventListener(mValueDataListener!!)
        }
        mValueDataListener = null
        Log.d("CakeModel", "data init line 26")

        mValueDataListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                try {
                    Log.d("CakeModel", "data updated line 29")
                    val data: ArrayList<Cake> = ArrayList()
                    for (snapshot: DataSnapshot in dataSnapshot.children) {
                        try {
                            data.add(Cake(snapshot))
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    mCakeList = data
                    Log.d("CakeModel", "data updated, entries: " + mCakeList!!.size)
                    setChanged()
                    notifyObservers()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("CakeModel", "line 51 data updated")
            }
        }
        getDatabaseRef()?.addValueEventListener(mValueDataListener as ValueEventListener)
    }

    fun getData(): ArrayList<Cake>? {
        Log.d("CakeModel", mCakeList.toString())
        return mCakeList
    }
}