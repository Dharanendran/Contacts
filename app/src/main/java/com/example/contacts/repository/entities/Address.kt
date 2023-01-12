package com.example.contacts.repository.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "address_table")
data class Address(
    @PrimaryKey(autoGenerate = true)
    val addressId:Int,
    val doorNo:String?,
    val street:String? ,
    val state:String? ,
    val pincode:String? ,
    val country:String?
)
