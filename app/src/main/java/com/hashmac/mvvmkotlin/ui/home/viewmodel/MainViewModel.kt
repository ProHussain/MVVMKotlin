package com.hashmac.mvvmkotlin.ui.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.hashmac.mvvmkotlin.data.repositries.NasaRepository
import com.hashmac.mvvmkotlin.ui.home.model.Item

class MainViewModel(application: Application):AndroidViewModel(application) {
    private val repository:NasaRepository = NasaRepository()
    val nasaData: LiveData<List<Item>>
        get() = repository.nasaResult()

}