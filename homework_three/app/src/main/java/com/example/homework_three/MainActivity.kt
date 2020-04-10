package com.example.homework_three

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerViewAdapter
    val items = ArrayList<ItemModel>()
    private val REQUEST_CODE = 173
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        addItemButton.setOnClickListener {
            openSecondActivity()
            adapter.notifyItemInserted(0)
            recyclerView.scrollToPosition(0)
        }
        setData()
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(items,this)
        recyclerView.adapter = adapter
    }
    private fun openSecondActivity(){
        val intent = Intent(this,SecondActivity::class.java)
        startActivityForResult(intent,REQUEST_CODE)
    }
    private fun setData(){
        items.add(ItemModel(R.mipmap.baby_yoda,"title1","description1",LocalDateTime.now().toString()))
        items.add(ItemModel(R.mipmap.baby_yoda,"title2","description2",LocalDateTime.now().toString()))
        items.add(ItemModel(R.mipmap.baby_yoda,"title3","description3",LocalDateTime.now().toString()))
        items.add(ItemModel(R.mipmap.baby_yoda,"title4","description4",LocalDateTime.now().toString()))
        items.add(ItemModel(R.mipmap.baby_yoda,"title5","description5",LocalDateTime.now().toString()))
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            val itemModel = data?.extras?.getParcelable<ItemModel>("itemModel")
            items.add(ItemModel(R.mipmap.baby_yoda,itemModel?.title.toString(),itemModel?.description.toString(),itemModel?.time.toString()))
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
