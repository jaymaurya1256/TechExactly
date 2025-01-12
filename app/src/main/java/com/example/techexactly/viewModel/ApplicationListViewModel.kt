package com.example.techexactly.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.techexactly.data.Application
import com.example.techexactly.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ApplicationListViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    val appData = liveData(Dispatchers.IO) {
        try {
            val response = apiService.getData()
            if (response.isSuccessful) {
                emit(response.body()?.data?.appList ?: emptyList())
            } else {
                emit(emptyList())
            }
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}
