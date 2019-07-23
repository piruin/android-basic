package com.example.helloworld.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>

    @GET("repos/{user}/{repo}/stargazers")
    fun listStarGazer(@Path("user") user: String, @Path("repo") repo: String): Call<List<User>>
}