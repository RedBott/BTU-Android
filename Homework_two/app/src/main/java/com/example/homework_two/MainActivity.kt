package com.example.homework_two

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE = 173
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        editProfileInfo.setOnClickListener {
            openSecondActivity()
        }
    }
    private fun openSecondActivity(){
        val intent = Intent(this,SecondActivity::class.java)
        startActivityForResult(intent,REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            val userModel = data?.extras?.getParcelable<UserModel>("userModel")

            firstNameTextView.text = userModel?.firstName
            emailTextView.text = userModel?.email
            birthYearTextView.text = userModel?.birthYear.toString()
            lastNameTextView.text = userModel?.lastName
            genderTextView.text = userModel?.gender
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
