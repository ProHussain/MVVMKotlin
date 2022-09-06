package com.hashmac.mvvmkotlin.ui.home.model

data class Data(
    var album: List<String>,
    var center: String,
    val date_created: String,
    val description: String,
    val description_508: String,
    val keywords: List<String>,
    var location: String,
    val media_type: String,
    val nasa_id: String,
    val photographer: String,
    val secondary_creator: String,
    val title: String
)