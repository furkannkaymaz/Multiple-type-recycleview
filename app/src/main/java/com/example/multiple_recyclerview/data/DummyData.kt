package com.example.multiple_recyclerview.data

import android.content.Context
import com.example.multiple_recyclerview.model.News
import com.example.multiple_recyclerview.model.NewsType

object DummyData {
    fun getData(): List<News> {
        val newsList = arrayListOf<News>()

        val news = News(
            1,
            NewsType.SHORT.value,
            "Kısa tipte bir haber",
        )
        val news2 = News(
            2,
            NewsType.MIDDLE.value,
            "Orta tipte bir haber",
        )
        val news3 = News(
            3,
            NewsType.HUGE.value,
            "Uzun tipte bir haber",
        )

        newsList.add(news)
        newsList.add(news2)
        newsList.add(news3)


        return newsList

    }

    fun getDataMore(): List<News> {
        val newsList = arrayListOf<News>()

        val news = News(
            1,
            NewsType.SHORT.value,
            "Kısa tipte bir haber",
        )
        val news2 = News(
            2,
            NewsType.MIDDLE.value,
            "Orta tipte bir haber",
        )
        val news3 = News(
            3,
            NewsType.HUGE.value,
            "Uzun tipte bir haber",
        )
        val news4 = News(
            4,
            NewsType.HUGE.value,
            "Uzun tipte bir haber",
        )

        newsList.add(news)
        newsList.add(news2)
        newsList.add(news3)
        newsList.add(news4)


        return newsList

    }
}

