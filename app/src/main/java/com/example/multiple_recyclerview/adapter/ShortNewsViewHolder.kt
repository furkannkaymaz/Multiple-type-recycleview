package com.example.multiple_recyclerview.adapter

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.multiple_recyclerview.model.News
import com.example.multiple_recyclerview.R
import com.example.multiple_recyclerview.databinding.ItemShortBinding

class ShortNewsViewHolder(
    private val binding: ItemShortBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News, onItemClick: ((News) -> Unit)? = null) {

        with(binding) {
            tvHeader.text = news.header
            llContainer.setBackgroundColor(
                ContextCompat.getColor(
                    binding.tvHeader.context,
                    R.color.shortColor
                )
            )
            llContainer.setOnClickListener {
                onItemClick?.invoke(news)
            }
        }

    }
}