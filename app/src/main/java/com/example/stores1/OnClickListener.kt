package com.example.stores1

import androidx.recyclerview.widget.GridLayoutManager
import com.example.stores1.databinding.ActivityMainBinding

interface OnClickListener {

    abstract val stores: MutableList<StoreEntity>
    abstract val biding: Any
    abstract var binding: ActivityMainBinding

    fun onClick(store: StoreEntity)
    fun onFavoriteStore(storeEntity: StoreEntity)
    abstract fun doAsync(function: () -> Unit)
    abstract fun uiThread(function: () -> Unit)
    abstract fun updateStore(storeEntity: StoreEntity)
}