package com.example.contacts.repository.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "contact_table")
data class ContactBook(

    @PrimaryKey(autoGenerate = true)
    val contactBookId:Int,
    val firstName:String,
    val lastName:String?,
    val personalEmail:String?,
    val officialMailID:String,
    val mobile:String,
    val home:String?,
    val work:String?,
    val addressId:Int,
    val workProfileId:Int
)