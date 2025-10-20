package com.example.s8088576assignment2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s8088576assignment2.data.ApiService
import com.example.s8088576assignment2.data.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private val _loginResult = MutableLiveData<String?>()
    val loginResult: LiveData<String?> = _loginResult

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun login(location: String, username: String, studentId: String) {
        viewModelScope.launch {
            try {
                val response = apiService.login(location, LoginRequest(username, studentId))
                if (response.isSuccessful && response.body() != null) {
                    _loginResult.postValue(response.body()!!.keypass)
                } else {
                    _error.postValue("Login failed: ${response.message()}")
                }
            } catch (e: Exception) {
                _error.postValue("An error occurred: ${e.message}")
            }
        }
    }
}
