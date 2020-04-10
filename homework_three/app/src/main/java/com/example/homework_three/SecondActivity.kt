package com.example.homework_three

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import java.time.LocalDateTime
@RequiresApi(Build.VERSION_CODES.O)
class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }
    private fun init() {
        saveButton.setOnClickListener {
            saveInfo()
        }
    }

    private fun saveInfo(){
            val intent = intent

            val itemModel = ItemModel(
                R.mipmap.baby_yoda,
                titleEditText.text.toString(),
                descriptionEditText.text.toString(),
                LocalDateTime.now().toString()
            )
            intent.putExtra("itemModel", itemModel)
            setResult(Activity.RESULT_OK,intent)

            finish()
        }
}