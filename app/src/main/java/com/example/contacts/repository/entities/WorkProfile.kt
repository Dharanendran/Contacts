package com.example.contacts.repository.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "work_profile")
data class WorkProfile(
    @PrimaryKey(autoGenerate = true)
    val workProfileId:Int,
    val jobTitle:String? ,
    val department:String? ,
    val company:String?
)