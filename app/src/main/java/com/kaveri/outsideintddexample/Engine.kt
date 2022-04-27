package com.kaveri.outsideintddexample

class Engine(var isTurnedOn:Boolean = false, var temperature:Double = 40.0) {

    fun turnOn() {
        isTurnedOn = true
        temperature = 95.0
    }
}