package com.hfad.android.navel.utils

import android.widget.Button
import androidx.compose.material.Button
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {

    val numbers = mapOf(0 to "zero" , 1 to "one" )
    val people = listOf(Person("Bob", 45), Person("Ash", 23))
    val list = listOf(1, 2, 4, 5, 6, 8, 2, 4, 5, 6, 8, 2, 4, 5, 6, 8, 2, 4, 5, 6, 8, 2, 4, 5, 6, 8, 2, 4, 5, 6, 8, 2, 4, 5, 6, 8).asSequence()
    println(measureTimeMillis { list.filter { it% 2 == 0 }.map { it * it }.toList()} )

    postponeComputation(1000) {
        println("")
    }


    val type = with(people){
        toMutableList()
        takeLast(5)
        this.lastIndex
        this[0].name
    }

}

fun postponeComputation(delay: Int , computation: Runnable){}
class HandleComputation(val id: String) : Runnable {
    override fun run() {
        println( id)
    }
}
fun handleComputation(id: String) {
    postponeComputation( 1000 , HandleComputation(id))
}



suspend fun loadImg() {
    delay(2000)
    println("img")
}

suspend fun loadData() {
    delay(2000)
    println("data")
}


class Sum(val a: Int, val b: Int) {

    companion object {
        val m: String = ""
        fun stat1111() {

        }
    }

    object Summer {
        fun funSummer() {

        }
    }
}


class Person(val name: String, val age: Int)



















