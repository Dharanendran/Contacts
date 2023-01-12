package com.example.contacts.repository.daos

import android.arch.persistence.room.*
import com.example.contacts.repository.entities.WorkProfile

@Dao
interface OtherContactDao {
    @Update
    fun updateWorkProfile(workProfile: WorkProfile)

    @Insert
    fun insertWorkProfile(workProfile: WorkProfile)

    @Delete
    fun deleteWorkProfile(workProfile: WorkProfile)

    @Query("SELECT * FROM ADDRESS_TABLE WHERE addressId==:workProfileId")
    fun getWorkProfile(workProfileId:Int)

    @Query("SELECT * FROM ADDRESS_TABLE")
    fun getAllWorkProfile():List<WorkProfile>
}