package com.example.multiple_recyclerview.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.multiple_recyclerview.base.BaseAdapter
import com.example.multiple_recyclerview.model.News
import com.example.multiple_recyclerview.model.NewsType
import com.example.multiple_recyclerview.databinding.ItemHugeBinding
import com.example.multiple_recyclerview.databinding.ItemMiddleBinding
import com.example.multiple_recyclerview.databinding.ItemShortBinding
import com.example.multiple_recyclerview.util.showToast

class NewsAdapter(
    val onClickAdapter: ((News) -> Unit)? = null,
) : BaseAdapter<News,RecyclerView.ViewHolder>(
    object : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.id == newItem.id
        }
    }
) {
    private lateinit var bindingItemShortBinding: ItemShortBinding
    private lateinit var bindingItemMiddleBinding: ItemMiddleBinding
    private lateinit var bindingItemHugeBinding: ItemHugeBinding

    override fun createView(
        context: Context,
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder =
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

    override fun bindView(holder: RecyclerView.ViewHolder, position: Int) {
        when (currentList[position].type) {
            NewsType.SHORT.value -> {
                (holder as ShortNewsViewHolder).bind(currentList[position]) {
                    holder.itemView.context showToast it.id.toString()
                    onClickAdapter?.let { it1 -> it1(it) }
                }
            }
            NewsType.MIDDLE.value -> {
                (holder as MiddleViewHolder).bind(currentList[position]) {
                    holder.itemView.context showToast it.id.toString()
                }
            }
            NewsType.HUGE.value -> {
                (holder as HugeViewHolder).bind(currentList[position]) {
                    holder.itemView.context showToast it.id.toString()
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (currentList[position].type) {
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