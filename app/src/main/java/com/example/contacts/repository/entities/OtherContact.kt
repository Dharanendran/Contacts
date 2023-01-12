package com.example.contacts.repository.entities

import android.arch.persistence.room.Entity

@Entity(tableName = "other_contact")
data class OtherContact(

    val contactId:Int,
    val extraContact:String
)