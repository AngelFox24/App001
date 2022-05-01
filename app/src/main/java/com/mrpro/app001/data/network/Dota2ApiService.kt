package com.mrpro.app001.data.network

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.graphics.vector.EmptyPath
import com.mrpro.app001.ProfileDotaModel
import com.mrpro.app001.core.RetrofitHelper
import com.squareup.picasso.Callback
import io.reactivex.internal.util.EmptyComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Dota2ApiService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProfileById(id: String): ProfileDotaModel? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(Dota2ApiClient::class.java).getProfileById(id)
            var model:ProfileDotaModel?=null
            if(response.isSuccessful){
                model= response.body()
            }

            if(response.code()==404){
                model = null
            }
            model
        }
//Response{protocol=h2, code=404, message=, url=https://api.opendota.com/api/211612523}
    }
}