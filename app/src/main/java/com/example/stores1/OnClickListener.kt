package com.example.stores1

import androidx.recyclerview.widget.GridLayoutManager
import com.example.stores1.databinding.ActivityMainBinding

interface OnClickListener {

    abstract val biding: Any
    abstract var binding: ActivityMainBinding

    fun onClick(store: StoreEntity)
    abstract fun GrinLayoutManager(mainActivity: MainActivity, i: Int): GridLayoutManager
    //fun onFavoriteStore(storeEntity: StoreEntity)
    //fun onDeleteStore(storeEntity: StoreEntity)
}