package com.hashmac.mvvmkotlin.ui.home.model

data class Item(
    val data: List<Data>,
    val href: String,
    val links: List<Link>
)