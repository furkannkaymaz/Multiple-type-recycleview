package com.example.multiple_recyclerview.adapter

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.multiple_recyclerview.model.News
import com.example.multiple_recyclerview.R
import com.example.multiple_recyclerview.databinding.ItemMiddleBinding

class MiddleViewHolder(
    private val binding: ItemMiddleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News) {
        binding.tvHeader.text = news.header
        binding.llContainer.setBackgroundColor(ContextCompat.getColor(binding.tvHeader.context, R.color.middleColor))
    }
}