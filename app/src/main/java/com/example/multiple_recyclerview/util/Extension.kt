package com.example.multiple_recyclerview.util

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import com.example.multiple_recyclerview.model.News

infix fun Context.showToast(message : String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
