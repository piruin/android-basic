package com.example.helloworld.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.helloworld.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(GitHubService::class.java)

        service.listRepos("piruin").enqueue(object : Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                toast("Failure ${t.message}")
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                with(response) {
                    if (isSuccessful) {
                        toast("success")
                        body()!!.let {
                            toast("Repo size = ${it.size}")
                            it.forEach { info { it.full_name } }
                        }
                    } else {
                        toast("Not success!")
                    }
                }
            }
        })
    }
}
