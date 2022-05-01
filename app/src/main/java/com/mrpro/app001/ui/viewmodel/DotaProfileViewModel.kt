package com.mrpro.app001.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrpro.app001.ProfileDotaModel
import com.mrpro.app001.domain.GetDotaProfileUseCase
import kotlinx.coroutines.*

class DotaProfileViewModel : ViewModel() {

    private val _dotaProfileModel = MutableLiveData<ProfileDotaModel?>()
    val dotaProfileModel: LiveData<ProfileDotaModel?> get() = _dotaProfileModel

    var getDotaProfileUseCase = GetDotaProfileUseCase()


    fun getProfile(id: String) {
        viewModelScope.launch {
            val response = getDotaProfileUseCase(id)
            _dotaProfileModel.value = response
        }
    }




}