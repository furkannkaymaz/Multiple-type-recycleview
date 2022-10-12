package com.example.multiple_recyclerview.adapter

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.multiple_recyclerview.model.News
import com.example.multiple_recyclerview.R
import com.example.multiple_recyclerview.base.BaseViewHolder
import com.example.multiple_recyclerview.databinding.ItemMiddleBinding

class MiddleViewHolder(
    val binding: ItemMiddleBinding
) : BaseViewHolder<News>(binding) {

    override fun bind(data: News, onItemClick: ((News) -> Unit)?) {
        super.bind(data, onItemClick)
        with(binding){
            tvHeader.text = data.header
            llContainer.setBackgroundColor(ContextCompat.getColor(binding.tvHeader.context, R.color.middleColor))
            llContainer.setOnClickListener {
                onItemClick?.invoke(data)
            }
        }
    }
}