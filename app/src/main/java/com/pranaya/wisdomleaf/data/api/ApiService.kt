package com.pranaya.wisdomleaf.data.api

import com.pranaya.wisdomleaf.data.model.ImageData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("list")
    suspend fun getImageList(@Query("page")  page : Int = 1,@Query("limit") limit  : Int = 20) : List<ImageData>
}