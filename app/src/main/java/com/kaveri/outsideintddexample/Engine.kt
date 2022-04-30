package com.kaveri.outsideintddexample

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Engine(var isTurnedOn:Boolean = false, var temperature:Double = 40.0) {

    suspend fun turnOn() : Flow<Double> {
        isTurnedOn = true
        return flow {
            delay(2000)
            temperature = 25.0
            emit(temperature)
            delay(2000)
            temperature = 50.0
            emit(temperature)
            delay(2000)
            temperature = 95.0
            emit(temperature)
            println("EWngine turned ON")
        }
    }
}