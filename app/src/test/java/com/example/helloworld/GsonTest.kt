package com.example.helloworld

import com.google.gson.Gson
import org.junit.Test

class GsonTest {

    val gson = Gson()

    @Test
    fun toJson() {
        // Java to Json string
        val jsonString = gson.toJson(TestModel(1, "Test"))
        print(jsonString)
    }

    @Test
    fun fromJson() {
        val jsonString = """{"id":1,"description":"Test"}""";
        val testModel = gson.fromJson(jsonString, TestModel::class.java)
        println(testModel)
    }

    data class TestModel(
            val id: Int,
            val description: String
    )
}