package com.example.helloworld.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.helloworld.R
import kotlinx.android.synthetic.main.activity_retrofit.recyclerView
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
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
                        body()!!.let { showRepo(it) }
                    } else {
                        toast("Not success!")
                    }
                }
            }
        })
    }

    fun showRepo(repos: List<Repo>) {
        with(recyclerView) {
            adapter = RepoAdapater(repos) {
                startActivity<StartGazerActivity>("repo" to it.full_name)
            }
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}
