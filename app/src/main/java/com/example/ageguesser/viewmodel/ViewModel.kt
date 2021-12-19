package com.example.ageguesser.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import com.example.ageguesser.model.Calculations
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {
    var resultJoke by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    fun getData(name: String){
        viewModelScope.launch{
            isLoading = true
            resultJoke = Calculations().getData(name)
            delay(1000)
            isLoading = false
        }
    }
}