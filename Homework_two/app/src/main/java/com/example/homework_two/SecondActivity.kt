package com.example.homework_two

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }
    private fun init(){
        saveButton.setOnClickListener {
            saveInfo()
        }
    }
    private fun saveInfo(){
        val intent = intent

        val userModel = UserModel(
            firstNameEditText.text.toString(),
            lastNameEditText.text.toString(),
            birthYearEditText.text.toString().toInt(),
            genderEditText.text.toString(),
            emailEditText.text.toString()
        )
        intent.putExtra("userModel", userModel)
        setResult(Activity.RESULT_OK,intent)

        finish()
    }
}
