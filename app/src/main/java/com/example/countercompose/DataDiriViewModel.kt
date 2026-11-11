package com.example.countercompose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DataDiriViewModel : ViewModel(){
    // Menginisialisasi nama pribadi
    private val _name = mutableStateOf("")
    val name: State<String> = _name

    // Menginisialisasi umur pribadi
    private val _age = mutableStateOf("")
    val age: State<String> = _age

    fun onNameChange(newName: String){
        _name.value = newName
    }

    fun onAgeChange(newAge: String){
        if (newAge.all { it.isDigit() }){
            _age.value = newAge
        }
    }
}