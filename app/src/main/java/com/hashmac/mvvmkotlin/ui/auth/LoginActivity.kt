package com.hashmac.mvvmkotlin.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hashmac.mvvmkotlin.R
import com.hashmac.mvvmkotlin.databinding.ActivityLoginBinding
import com.hashmac.mvvmkotlin.utils.hide
import com.hashmac.mvvmkotlin.utils.show
import com.hashmac.mvvmkotlin.utils.toast
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity(), AuthListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView<ActivityLoginBinding>(this,R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progress_bar.hide()
        })
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}