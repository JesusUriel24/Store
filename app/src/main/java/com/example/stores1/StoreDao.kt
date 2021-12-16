package com.example.stores1

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface StoreDao {
    abstract fun addStore(store: StoreEntity)
    abstract fun getAllStores(): Any
    abstract fun updateStore(storeEntity: StoreEntity)

    interface StoreDao {
        @Query("SELECT * FROM StoreEntity")
        fun getAllStores() : MutableList<StoreEntity>

        @Insert
        fun addStore(storeEntity: StoreEntity)

        @Update
        fun updateStore(storeEntity: StoreEntity)

        @Delete
        fun deleteStore(storeEntity: StoreEntity)
    }
}