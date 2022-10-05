package com.example.multiple_recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiple_recyclerview.data.DummyData
import com.example.multiple_recyclerview.adapter.NewsAdapter
import com.example.multiple_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.rvNews.adapter = NewsAdapter(DummyData.getTata(this))
        binding.rvNews.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}