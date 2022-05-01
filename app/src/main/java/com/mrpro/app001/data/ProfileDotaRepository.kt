package com.mrpro.app001.data
import com.mrpro.app001.ProfileDotaModel
import com.mrpro.app001.data.network.Dota2ApiService

class ProfileDotaRepository {

    private val api= Dota2ApiService()

    suspend fun getDotaProfile(id:String): ProfileDotaModel?{
        val response=api.getProfileById(id)
        return response
    }
}