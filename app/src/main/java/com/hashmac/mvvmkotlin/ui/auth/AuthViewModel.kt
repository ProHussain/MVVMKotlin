package com.hashmac.mvvmkotlin.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.hashmac.mvvmkotlin.data.repositries.NasaRepository

class AuthViewModel:ViewModel() {
    var email : String? = null
    var password : String? = null
    var authListener : AuthListener? = null

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
//            authListener?.onFailure("Invalid email or password")
//            return
        }

        val loginResponse = NasaRepository().nasaResult()
//        authListener?.onSuccess(loginResponse)
    }
}
