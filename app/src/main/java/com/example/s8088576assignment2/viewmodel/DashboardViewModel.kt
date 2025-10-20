package com.example.s8088576assignment2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s8088576assignment2.data.ApiService
import com.example.s8088576assignment2.data.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private val _dashboardData = MutableLiveData<List<Entity>>()
    val dashboardData: LiveData<List<Entity>> = _dashboardData

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun loadDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                val response = apiService.getDashboardData(keypass)
                if (response.isSuccessful && response.body() != null) {
                    _dashboardData.postValue(response.body()!!.entities)
                } else {
                    _error.postValue("Failed to load data: ${response.message()}")
                }
            } catch (e: Exception) {
                _error.postValue("An error occurred: ${e.message}")
            }
        }
    }
}
