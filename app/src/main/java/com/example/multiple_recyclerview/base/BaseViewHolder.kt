package com.example.multiple_recyclerview.base

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


open class BaseViewHolder<D>(bindingBase : ViewBinding): RecyclerView.ViewHolder(bindingBase.root) {
    open fun bind(data: D, onItemClick: ((D) -> Unit)? = null) {}
}

