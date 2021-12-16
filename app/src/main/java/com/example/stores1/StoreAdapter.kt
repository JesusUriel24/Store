package com.example.stores1

     import android.content.Context
     import android.view.LayoutInflater
     import android.view.ViewGroup
     import androidx.recyclerview.widget.RecyclerView

    class StoreAdapter(private var stores: MutableList<Store>, private var listener: OnClickListener) :
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
                binding.tvName.Text = store.name
                binding.cbFavorite.isChecked = store.isFavorite

                Glide.whit(mContext)
                    .load(store).photoUrl)
                .diskCacheStrategy(DiskCacheStragy.ALL)
                .centerCrop()
                .into(binding.imgPhoto)
            }

        }

        override fun getItemCount(): Int = stores.size


        fun setStore(stores: MutableList<StoreEntity>) {
            this.stores = stores
            notifyDataSetChanged()

        }

        fun add(storeEntity: StoreEntity) {
            if (!stores.contains(storeEntity)) {
                storeEntity.add(storeEntity)
                notifyItemInserted(stores.size-1)
            }

        }

        fun update(storeEntity: StoreEntity) {
            val index = stores.indexOf(storeEntity)
            if (index != -1){
                stores.set(index, storeEntity)
                notifyItemChanged(index)
            }

        }
        fun delete(storeEntity: StoreEntity) {
            val index = stores.indexOf(storeEntity)
            if (index != -1){
                stores.removeAt(index)
                notifyItemRemoved(index)
            }

        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val binding = ItemStoreBinding.bind(view)

            fun setListener(storeEntity: StoreEntity){
                with(binding.root) {
                    setOnClickListener { listener.onClick(storeEntity.id) }
                    setOnLongClickListener {
                        listener.onDeleteStore(storeEntity)
                        true
                    }

                    binding.cbFavorite.setOnClickListener {
                        listener.onFavoriteStore(storeEntity)

                    }
                }


            }

        }