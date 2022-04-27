package com.kaveri.outsideintddexample

import kotlinx.coroutines.delay

class Car(var fuel: Double,
    val engine: Engine) {

    suspend fun turnOn() {
        fuel -= 0.5
        println("turn on called on ${Thread.currentThread().name}")
        delay(6000)
        println("delay returned back to ${Thread.currentThread().name}")
        engine.turnOn()
    }

}