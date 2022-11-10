package com.pranaya.wisdomleaf.data.api

import com.pranaya.wisdomleaf.data.model.ImageData

interface ApiHelper {

    suspend fun getImages(page : Int, limit : Int) : List<ImageData>
}