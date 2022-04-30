package com.mrpro.app001.data.network

import com.mrpro.app001.ProfileDotaModel
import com.mrpro.app001.core.RetrofitHelper
import com.squareup.picasso.Callback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Dota2ApiService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProfileById(id: String): ProfileDotaModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(Dota2ApiClient::class.java).getProfileById(id)
            response.body()!!
        }

    }
}