package com.mrpro.app001.data.network

import com.mrpro.app001.ProfileDotaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface Dota2ApiClient {

    @GET("/api/players/{id_user}")
    suspend fun getProfileById(@Path("id_user") id: String): Response<ProfileDotaModel>

}