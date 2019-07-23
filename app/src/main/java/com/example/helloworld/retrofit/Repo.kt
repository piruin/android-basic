package com.example.helloworld.retrofit

class Repo(
        val name: String,
        val full_name: String
) {
    var private = false
    var html_url: String? = null
    val open_issues: Int = 0
    var description: String? = null
    var stargazers_count: Int = 0
    var watchers_count: Int = 0
    var language: String? = null
    var size = 0
    var forks = 0
    var watchers = 0
    var topics: List<String> = listOf()
    var license: License? = null
}
