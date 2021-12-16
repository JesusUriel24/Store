package com.example.stores1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stores1.databinding.ItemStoreBinding


class StoreAdapter(private var stores : MutableList<StoreEntity>, private var listener: OnClickListener):
    RecyclerView.Adapter<StoreAdapter.ViewHolder>(){


    private lateinit var mContext: Context



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_store, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = stores.get(position)

        with(holder){
            setListener(store)

            binding.tvName.text = store.name
            binding.cbFavorite.isChecked = store.isFavorite

        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun add(store: StoreEntity) {
        stores.add(store)
        notifyDataSetChanged()

    }

    fun setStore(stores: MutableList<StoreEntity>){
        this.stores = stores
        notifyDataSetChanged()

    }

    fun update(storeEntity: StoreEntity) {
        val index = stores.indexOf(storeEntity)
        if (index != -1){
            stores.set(index, storeEntity)
            notifyDataSetChanged(index)
        }

    }

    private fun notifyDataSetChanged(index: Int) {

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemStoreBinding.bind(view)

        fun setListener(storeEntity: StoreEntity){
            binding.root.setOnClickListener { listener.onClick(storeEntity) }
            binding.cbFavorite.setOnClickListener{
                listener.onFavoriteStore(storeEntity)
            }
        }
    }

}