package com.example.stores1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stores1.databinding.ActivityMainBinding


class MainActivity(override var binding: ActivityMainBinding, override val biding: Any) : AppCompatActivity(), OnClickListener{

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding.btnSave.setOnClickListener {
            val store = StoreEntity (name = mBinding.etName.text.toString().trim())
            Thread {
                StoreApplication.database.storeDao().addStore(store)
            }.start()
            mAdapter.add(store)


        }


        setupRecylcerView()


    }

    private fun setupRecylcerView() {
        mAdapter = StoreAdapter(mutableListOf(), this)
        mGridLayout= GridLayoutManager(this, 2)

        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter

        }
    }

    /*
    *OnClickListener
     **/
    override fun onClick(store: StoreEntity) {
        TODO("Not yet implemented")
    }

    override fun GrinLayoutManager(mainActivity: MainActivity, i: Int): GridLayoutManager {
        TODO("Not yet implemented")
    }

}

