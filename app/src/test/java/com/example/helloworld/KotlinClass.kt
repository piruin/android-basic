package com.example.helloworld

import org.junit.Test

class KotlinClass {

    @Test
    fun personClass() {
        val person = Person()
        person.name = "Piruin"
        person.address = "Thailand"
        person.age = 31
        person.height = 170.0
        person.weight = 58.5
    }

    class Person {
        var name: String? = null
        var address: String =  ""
        var age: Int? = null
        var weight: Double? = null
        var height: Double? = null
    }
}