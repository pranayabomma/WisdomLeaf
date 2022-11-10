package com.pranaya.wisdomleaf.data.api

class ApiHelperImpl(private val service: ApiService) : ApiHelper {
    override suspend fun getImages(page : Int, limit : Int) = service.getImageList(page, limit)
}