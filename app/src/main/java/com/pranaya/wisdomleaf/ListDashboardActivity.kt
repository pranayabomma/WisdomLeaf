package com.pranaya.wisdomleaf

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pranaya.wisdomleaf.Utils.Resource
import com.pranaya.wisdomleaf.Utils.Status
import com.pranaya.wisdomleaf.Utils.Utils
import com.pranaya.wisdomleaf.Utils.ViewModelFactory
import com.pranaya.wisdomleaf.data.api.ApiHelperImpl
import com.pranaya.wisdomleaf.data.api.RetrofitBuilder
import com.pranaya.wisdomleaf.data.model.ImageData
import com.pranaya.wisdomleaf.databinding.ActivityDashboardListBinding

class ListDashboardActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityDashboardListBinding
    private lateinit var viewModel : ListDashboardViewModel
    private lateinit var  adapter : ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //use databinding to setcontentview
        setupViewModel()
        dataBinding = ActivityDashboardListBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
        setupUI()
        setupObservers()


    }

    fun setupUI() {
       adapter = ImageAdapter(arrayListOf())
        dataBinding.rvListElements.adapter = adapter
    }

    fun setupObservers() {
        viewModel.getImages().observe(this) {
            when (it.status) {
                Status.ERROR -> dataBinding.rvListElements.visibility = View.GONE
                Status.SUCCESS -> {
                    dataBinding.rvListElements.visibility = View.VISIBLE
                    renderData(it.data!!)
                }
            }
        }
    }

    fun renderData(images : List<ImageData>) {
        adapter.addData(images)
        adapter.notifyDataSetChanged()
    }

    fun setupViewModel() {
        viewModel = ViewModelProvider(this,
        ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService)))[ListDashboardViewModel::class.java]
    }


    fun onViewClick(view : View) {
        Utils.showDialog(view.tag.toString(),view.context)
    }

}