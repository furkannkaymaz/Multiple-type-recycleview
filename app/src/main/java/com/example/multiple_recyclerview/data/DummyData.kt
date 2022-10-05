package com.example.multiple_recyclerview.data

import android.content.Context
import com.example.multiple_recyclerview.model.News
import com.example.multiple_recyclerview.model.NewsType

object DummyData {
    fun getTata(context: Context): List<News> {
        val newsList = arrayListOf<News>()

        val news = News(
            NewsType.SHORT.value,
            "Kısa tipte bir haber",
        )
        val news2 = News(
            NewsType.MIDDLE.value,
            "Orta tipte bir haber",
        )
        val news3 = News(
            NewsType.HUGE.value,
            "Uzun tipte bir haber",
        )

        newsList.add(news)
        newsList.add(news2)
        newsList.add(news3)
        newsList.add(news2)
        newsList.add(news2)
        newsList.add(news3)
        newsList.add(news)
        newsList.add(news3)
        newsList.add(news)
        newsList.add(news2)

        return newsList

    }
}