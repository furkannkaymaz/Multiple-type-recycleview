package com.example.multiple_recyclerview.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.multiple_recyclerview.model.News
import com.example.multiple_recyclerview.model.NewsType
import com.example.multiple_recyclerview.databinding.ItemHugeBinding
import com.example.multiple_recyclerview.databinding.ItemMiddleBinding
import com.example.multiple_recyclerview.databinding.ItemShortBinding
import com.example.multiple_recyclerview.util.showToast

class NewsAdapter(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: List<News> = emptyList()
    var onItemClick: ((News) -> Unit)? = null

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
                (holder as ShortNewsViewHolder).bind(list[position]) {
                    holder.itemView.context showToast it.id.toString()
                }
            }
            NewsType.MIDDLE.value -> {
                (holder as MiddleViewHolder).bind(list[position]){
                    holder.itemView.context showToast it.id.toString()
                }
            }
            NewsType.HUGE.value -> {
                (holder as HugeViewHolder).bind(list[position]){
                    holder.itemView.context showToast it.id.toString()
                }
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

    fun setData(newNewsList: List<News>) {
        val diffUtil = NewsDiffUtil(list, newNewsList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        list = newNewsList
        diffResults.dispatchUpdatesTo(this)
    }

}