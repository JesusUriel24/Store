package com.example.stores1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stores1.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class MainActivity(override var binding: ActivityMainBinding, override val biding: Any,
                   override val stores: MutableList<StoreEntity>
) : AppCompatActivity(), OnClickListener {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding.btnSave.setOnClickListener {
            val store = StoreEntity(name = mBinding.etName.text.toString().trim())
            Thread {
                StoreApplication.database.storeDao().addStore(store)
            }.start()
            mAdapter.add(store)


        }


        setupRecylcerView()


    }

    private fun setupRecylcerView() {
        mAdapter = StoreAdapter(mutableListOf(), this)
        mGridLayout = GridLayoutManager(this, 2)
        getStore()

        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter

        }
    }

    private fun getStore() {
        doAsync {
            val store = StoreApplication.database.storeDao().getAllStores()
            uiThread {
                mAdapter.setStore(stores)
            }
        }
    }

    /*
    *OnClickListener
     **/
    override fun onClick(store: StoreEntity) {
        TODO("Not yet implemented")
    }

    override fun onFavoriteStore(storeEntity: StoreEntity) {
        storeEntity.isFavorite = !storeEntity.isFavorite
        doAsync {
            StoreApplication.database.storeDao().updateStore(storeEntity)
            uiThread {
                mAdapter.update(storeEntity)
            }
        }
    }

    override fun doAsync(function: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun uiThread(function: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun updateStore(storeEntity: StoreEntity) {
        TODO("Not yet implemented")
    }

    fun onDeleteStore(storeEntity: StoreEntity) {
        val items = arrayOf("Eliinar", "Llamar", "Ir al web site")


    }
}



