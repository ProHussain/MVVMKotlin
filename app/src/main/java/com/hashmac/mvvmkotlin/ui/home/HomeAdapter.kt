package com.hashmac.mvvmkotlin.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hashmac.mvvmkotlin.R
import com.hashmac.mvvmkotlin.databinding.ItemHomeRvBinding
import com.hashmac.mvvmkotlin.ui.home.HomeAdapter.*
import com.hashmac.mvvmkotlin.ui.home.model.Item

class HomeAdapter: RecyclerView.Adapter<HomeViewHolder>() {

    private var mNasaItems: ArrayList<Item>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val mDeveloperListItemBinding = DataBindingUtil.inflate<ItemHomeRvBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home_rv, parent, false
        )

        return HomeViewHolder(mDeveloperListItemBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val nasaItem = mNasaItems!![position]
        holder.homeViewHolderBinding.mainViewModel = nasaItem.data.get(0)
    }

    override fun getItemCount(): Int {
        return if (mNasaItems != null) {
            mNasaItems!!.size
        } else {
            0
        }
    }

    fun setItemsList(mItemModel: ArrayList<Item>) {
        this.mNasaItems = mItemModel
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(var homeViewHolderBinding:ItemHomeRvBinding):RecyclerView.ViewHolder(homeViewHolderBinding.root)
}