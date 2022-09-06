package com.hashmac.mvvmkotlin.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hashmac.mvvmkotlin.R
import com.hashmac.mvvmkotlin.databinding.ActivityMainBinding
import com.hashmac.mvvmkotlin.ui.auth.AuthViewModel
import com.hashmac.mvvmkotlin.ui.home.model.Item
import com.hashmac.mvvmkotlin.ui.home.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mHomeAdapter: HomeAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mHomeAdapter = HomeAdapter()
        nasaRV.setAdapter(mHomeAdapter)

        viewModel!!.nasaData.observe(this,
            Observer<List<Any>> { mNasaModel ->
                ///if any thing chnage the update the UI
                mHomeAdapter?.setItemsList(mNasaModel as ArrayList<Item>)
                nasaPD?.visibility = View.GONE
            })
    }
}