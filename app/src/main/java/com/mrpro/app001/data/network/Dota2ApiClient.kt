package com.mrpro.app001.data.network

import com.mrpro.app001.ProfileDotaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface Dota2ApiClient {

    @GET
    suspend fun getProfileById(@Url url: String): Response<ProfileDotaModel>

}