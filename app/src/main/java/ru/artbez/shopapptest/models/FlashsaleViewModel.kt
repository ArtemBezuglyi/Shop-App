package ru.artbez.shopapptest.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import ru.artbez.shopapptest.api.RetrofitRepository

class FlashsaleViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RetrofitRepository()
    val myFlashsale: MutableLiveData<Response<FlashsaleModel>> = MutableLiveData()
    val context = application

    fun getFlashsale(){
        viewModelScope.launch {
            myFlashsale.value = repository.getGoodsFlashsale()
        }
    }
}