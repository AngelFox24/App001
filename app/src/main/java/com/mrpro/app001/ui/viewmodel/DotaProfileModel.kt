package com.mrpro.app001.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrpro.app001.ProfileDotaModel
import com.mrpro.app001.domain.GetDotaProfileUseCase
import kotlinx.coroutines.*

class DotaProfileModel : ViewModel() {

    private val _dotaProfileModel = MutableLiveData<ProfileDotaModel>()
    val dotaProfileModel: LiveData<ProfileDotaModel> get() = _dotaProfileModel

    var getDotaProfileUseCase = GetDotaProfileUseCase("")

    var job: Job? = null

    fun onCreate(id: String) {
        job = CoroutineScope(Dispatchers.IO).launch {
            Thread.sleep(5000)
            val response = getDotaProfileUseCase(id)
            if (!response.idDota2.equals("")) {
                _dotaProfileModel.value = response
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}