package com.example.helloworld.retrofit

class Repo(
        val name: String,
        val full_name: String
) {
    var private = false
    var html_url: String? = null
    var forks_count: Int = 0
    var stargazers_count: Int = 0
    var watchers_count: Int = 0
    var size: Int = 0
    var topics: List<String> = listOf()
}