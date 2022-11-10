package com.pranaya.wisdomleaf.Utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pranaya.wisdomleaf.ListDashboardViewModel
import com.pranaya.wisdomleaf.data.api.ApiHelper
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListDashboardViewModel::class.java)) {
            return ListDashboardViewModel(apiHelper) as T
        }

        throw IllegalArgumentException("Unknown Class")
    }
}