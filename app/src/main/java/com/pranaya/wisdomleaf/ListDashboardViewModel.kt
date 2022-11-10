package com.pranaya.wisdomleaf

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pranaya.wisdomleaf.Utils.Resource
import com.pranaya.wisdomleaf.data.api.ApiHelper
import com.pranaya.wisdomleaf.data.model.ImageData
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ListDashboardViewModel(private val apiHelper: ApiHelper) : ViewModel() {

    private val images = MutableLiveData<Resource<List<ImageData>>>()

    init {
        getImages()
    }

    fun getImages(page :Int =1,limit : Int = 20 ) : LiveData<Resource<List<ImageData>>>{

        MainScope().launch {
            images.postValue(Resource.loading())
            coroutineScope {
               val usersloaded = apiHelper.getImages(page,limit)

                images.postValue(Resource.success(usersloaded))
            }


        }
        return images
    }

}