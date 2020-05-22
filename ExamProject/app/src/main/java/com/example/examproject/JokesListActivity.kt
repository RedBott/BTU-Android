package com.example.examproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query


class JokesListActivity : AppCompatActivity() {

    private var db: FirebaseFirestore? = FirebaseFirestore.getInstance()
    private var jokeListRef  = db?.collection("Joke List")
    private val adapter: JokeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes_list)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        val query : Query? = jokeListRef?.orderBy("Id",Query.Direction.DESCENDING)
        val options : FirestoreRecyclerOptions<Joke> = FirestoreRecyclerOptions.Builder<Joke>().setQuery(
            query!!,Joke::class.java).build()
        val adapter = JokeAdapter(options)
        var recyclerView : RecyclerView = findViewById(R.id.jokes_list_recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter!!.stopListening()
    }

}
