package com.hashmac.mvvmkotlin.ui.home.model

data class Collection(
    val href: String,
    val items: List<Item>,
    val metadata: Metadata,
    val version: String
)