package com.example.helloworld

import org.junit.Test

class KotlinBasic {

    @Test
    fun defineVariable() {
        val name: String = "Piruin Panichphol"
        val address = "Phathumtani, Thailand"
        val age = 30 //Int
        val weight = 68.5 //Double
        val height: Double? = 170.0
    }

    @Test
    fun callFun() {
        greeting("Piruin")
        assert(sum(8 , 1) == 9)
    }

    fun greeting(name: String) {
        println("Hi, $name.")
    }

    fun sum(a: Int, b: Int) = a + b

    @Test
    fun mutableAndImmutable() {
        val citizenId = "1-1011-01148-44-5"
        //citizenId = "0-0000-00000-00-1" //ERR!! val can't re-assign

        var name = "Piruin Panichphol"
        name = "Pirat Panichphol"
        greeting(name) // Hi, Pirat Panichphol

    }

    @Test
    fun nullSafety() {
        //val birthday: String = null //ERR!! can't assign null to non-null variable
        var gender: String? = null
        gender = "male"
        gender = null

        fun printGender(gender: String) {
            println("gender is $gender")
        }
        //printGender(gender) //ERR!! printGender() accept only non-null String

        //Using nullable variable
        if (gender != null) {
            printGender(gender)
        }
        gender?.let { printGender(it) }
    }
}