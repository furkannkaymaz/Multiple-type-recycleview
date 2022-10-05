package com.example.multiple_recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiple_recyclerview.model.News
import com.example.multiple_recyclerview.model.NewsType
import com.example.multiple_recyclerview.databinding.ItemHugeBinding
import com.example.multiple_recyclerview.databinding.ItemMiddleBinding
import com.example.multiple_recyclerview.databinding.ItemShortBinding

class NewsAdapter(
    private val list: List<News>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var bindingItemShortBinding: ItemShortBinding
    private lateinit var bindingItemMiddleBinding: ItemMiddleBinding
    private lateinit var bindingItemHugeBinding: ItemHugeBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            NewsType.SHORT.value -> {
                bindingItemShortBinding = ItemShortBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ShortNewsViewHolder(bindingItemShortBinding)
            }
            NewsType.MIDDLE.value -> {
                bindingItemMiddleBinding = ItemMiddleBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                MiddleViewHolder(bindingItemMiddleBinding)
            }
            NewsType.HUGE.value -> {
                bindingItemHugeBinding = ItemHugeBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                HugeViewHolder(bindingItemHugeBinding)
            }
            else -> {

                bindingItemMiddleBinding = ItemMiddleBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                MiddleViewHolder(bindingItemMiddleBinding)
            }
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (list[position].type) {
            NewsType.SHORT.value -> {
                (holder as ShortNewsViewHolder).bind(list[position])
            }
            NewsType.MIDDLE.value -> {
                (holder as MiddleViewHolder).bind(list[position])
            }
            NewsType.HUGE.value -> {
                (holder as HugeViewHolder).bind(list[position])
            }
        }

    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int =
        when (list[position].type) {
            0 -> {
                NewsType.SHORT.value
            }
            1 -> {
                NewsType.MIDDLE.value
            }
            2 -> {
                NewsType.HUGE.value
            }
            else -> {
                0
            }
        }

}