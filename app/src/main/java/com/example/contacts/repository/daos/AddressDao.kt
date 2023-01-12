package com.example.contacts.repository.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.contacts.repository.entities.Address

@Dao
interface AddressDao {
    @Update
    fun updateAddress(address: Address)

    @Insert
    fun insertAddress(address:Address)

    @Delete
    fun deleteAddress(address:Address)

    @Query("SELECT * FROM ADDRESS_TABLE WHERE addressId==:addressId")
    fun getAddress(addressId:Int)

    @Query("SELECT * FROM ADDRESS_TABLE")
    fun getAllAddress()
}