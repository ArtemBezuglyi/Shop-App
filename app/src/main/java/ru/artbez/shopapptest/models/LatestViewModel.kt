package ru.artbez.shopapptest.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import ru.artbez.shopapptest.api.RetrofitRepository

class LatestViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RetrofitRepository()
    val myLatest: MutableLiveData<Response<LatestModel>> = MutableLiveData()
    val context = application

    fun getLatest(){
        viewModelScope.launch {
            myLatest.value = repository.getGoodsLatest()
        }
    }
}