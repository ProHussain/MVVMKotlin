package com.hashmac.mvvmkotlin.ui.home

import androidx.lifecycle.LiveData

interface HomeListener {
    fun onStarted()
    fun onSuccess(nasaResponse: LiveData<String>)
    fun onFailure(message: String)
}