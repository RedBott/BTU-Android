package com.example.examproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examproject.JokeAdapter.JokeHolder
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class JokeAdapter(options: FirestoreRecyclerOptions<Joke>) :
    FirestoreRecyclerAdapter<Joke, JokeHolder>(options) {
    override fun onBindViewHolder(
        holder: JokeHolder,
        position: Int,
        model: Joke
    ) {
        holder.textViewAnswer.text = model.getAnswer()
        holder.textViewQuestion.text = model.getQuestion()
        holder.textViewId.text = model.getId().toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.joke_item_layout,
            parent, false
        )
        return JokeHolder(v)
    }

    inner class JokeHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textViewQuestion: TextView = itemView.findViewById(R.id.joke_question_text_view)
        var textViewAnswer: TextView = itemView.findViewById(R.id.joke_answer_text_view)
        var textViewId: TextView = itemView.findViewById(R.id.joke_id_text_view)

    }
}