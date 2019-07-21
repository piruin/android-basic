package com.example.helloworld.recycler

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.helloworld.R.layout
import kotlinx.android.synthetic.main.activity_datas.recyclerView

class DatasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_datas)

        val datas = listOf(
                Data("BKK", "Suvarnabhumi"),
                Data("DMK", "Don Mueang"),
                Data("CNX", "Chiang Mai")
        )

        with(recyclerView) {
            adapter = DataAdapter(datas)
            layoutManager = LinearLayoutManager(context!!)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}
