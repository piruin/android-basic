package com.example.helloworld.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.helloworld.R
import kotlinx.android.synthetic.main.activity_retrofit.recyclerView
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StartGazerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(GitHubService::class.java)
        service.listStarGazer("piruin", "quickaction").enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                toast("Failure ${t.message}")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                with(response) {
                    if (isSuccessful) {
                        val stargazers = body()
                        if (stargazers.isNullOrEmpty())
                            toast("Not found stargazer!!")
                        else
                            showStarGazer(stargazers)
                    } else {
                        toast("Not success!")
                    }
                }
            }
        })
    }

    fun showStarGazer(repos: List<User>) {
        with(recyclerView) {
            adapter = StartGazerAdapater(repos)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}