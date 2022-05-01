package com.mrpro.app001.domain

import com.mrpro.app001.data.ProfileDotaRepository

class GetDotaProfileUseCase (){

    private val repository = ProfileDotaRepository()

    suspend operator fun invoke(id:String) = repository.getDotaProfile(id)
}