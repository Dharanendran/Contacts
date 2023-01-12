package com.example.contacts.repository.daos

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.contacts.repository.entities.Address
import com.example.contacts.repository.entities.ContactBook

interface ContactBookDao {
    @Update
    fun updateContact(contact:ContactBook)

    @Insert
    fun insertContact(contact:ContactBook)

    @Delete
    fun deleteContact(contact:ContactBook)

    @Query("SELECT * FROM contact_table WHERE contactBookId==:contactId")
    fun getContact(contactId:Int):ContactBook

    @Query("SELECT * FROM contact_table")
    fun getAllContacts():List<ContactBook>
}