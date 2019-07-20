package com.example.helloworld

import org.junit.Test

class KotlinClass {

    @Test
    fun personClass() {
//        val person = Person()
//        person.name = "Piruin"
//        person.address = "Thailand"
//        person.age = 31
//        person.height = 170.0
//        person.weight = 58.5

        val me = Person("Piruin Panicphol", "Thailand", 30, 58.0, 170.0)
        greeting(me)

        val you = Person("Piruin Panicphol", "Thailand", 30, 58.0, 170.0)
        assert(me == you)
    }

    fun greeting(p: Person) {
        println("Hi, ${p.name}. R u come from ${p.address}?")
    }

    data class Person(
            val name: String,
            var address: String?,
            var age: Int,
            var weight: Double,
            val height: Double
    )

}