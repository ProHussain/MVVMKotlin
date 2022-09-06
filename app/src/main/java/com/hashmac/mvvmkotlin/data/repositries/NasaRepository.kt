package com.hashmac.mvvmkotlin.data.repositries

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hashmac.mvvmkotlin.data.network.MyApi
import com.hashmac.mvvmkotlin.ui.home.model.Data
import com.hashmac.mvvmkotlin.ui.home.model.Item
import com.hashmac.mvvmkotlin.ui.home.model.Model
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NasaRepository {
    private val mNasaDataList = ArrayList<Item>()
    private val mutableLiveData = MutableLiveData<List<Item>>()

    fun nasaResult() : MutableLiveData<List<Item>> {
        MyApi().nasaResponse()
            .enqueue(object : Callback<Model>{
                override fun onResponse(
                    call: Call<Model>,
                    response: Response<Model>,
                ) {
                    if (response.isSuccessful) {
                        val model: Model? = response.body();
                        mNasaDataList.addAll(model!!.collection.items)
                        mutableLiveData.value = mNasaDataList
                    } else {
                        Log.e("Res E",response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<Model>, t: Throwable) {
                    Log.e("Res F",t.message.toString())
                }

            })

        return mutableLiveData
    }
}