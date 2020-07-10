package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.news_item_layout,
            parent,false
        )
        return NewsHolder(v)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int,model:News) {
        holder.textViewTitle = model.getTitle()
        holder.textViewDescription = model.getDescription()
    }

    inner class NewsHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView = itemView.findViewById(R.id.news_title_text_view)
        var textViewDescription: TextView = itemView.findViewWithTag(R.id.cc)
    }

    override fun getItemCount(): Int {
        return 10
    }


}