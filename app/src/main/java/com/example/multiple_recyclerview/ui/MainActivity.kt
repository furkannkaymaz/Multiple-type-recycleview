package com.example.multiple_recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiple_recyclerview.data.DummyData
import com.example.multiple_recyclerview.adapter.NewsAdapter
import com.example.multiple_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val newsAdapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setAdapter()

        newsAdapter.setData(DummyData.getData())

        binding.btnAddMore.setOnClickListener {
            newsAdapter.setData(DummyData.getDataMore())
        }

    }

    private fun setAdapter() {

        binding.rvNews.adapter = newsAdapter
        binding.rvNews.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}