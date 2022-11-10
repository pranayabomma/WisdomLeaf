package com.pranaya.wisdomleaf

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.pranaya.wisdomleaf.databinding.ActivityDashboardListBinding

class ListDashboardActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityDashboardListBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //use databinding to setcontentview
        dataBinding = ActivityDashboardListBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

    }
}