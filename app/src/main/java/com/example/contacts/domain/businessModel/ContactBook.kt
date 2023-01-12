package com.example.contacts.domain.businessModel


data class ContactBook(val firstName:String,
                       val lastName:String?,
                       val personalEmail:String?,
                       val officialMailID:String,
                       val mobile:String,
                       val home:String?,
                       val work:String?,
                       val others:MutableList<String>?,
                       val address: Address?,
                       val workProfile: WorkProfile? )


