package com.example.homework_four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun getUsers(){
        DataLoader.getRequest("users",object :CustomCallback{
            override fun onSuccess(result: String) {
                val model = Gson().fromJson(result,UserModel::class.java)
            }

        })
    }
}
