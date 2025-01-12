package com.example.techexactly.network

import com.example.techexactly.data.Application
import com.example.techexactly.data.ApplicationResponseWrapper
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("g-mee-api/api/v1/apps/list?kid_id=378")
    suspend fun getData(): Response<ApplicationResponseWrapper>

}
