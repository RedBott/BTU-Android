package com.example.examproject

interface CustomCallback {
    fun onSuccess(result:String){}
    fun onFailure(errorMessage:String){}
}