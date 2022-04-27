package com.kaveri.outsideintddexample.acceptancetest

import com.kaveri.outsideintddexample.Car
import com.kaveri.outsideintddexample.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class CarFeature {

    val engine = Engine()
    val car = Car(6.0, engine)

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {
        car.turnOn()
        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIdTurningOnEngineAndIncreasingTemperature() {
        car.turnOn()
        assertTrue(car.engine.isTurnedOn)
        assertEquals(95.0, car.engine.temperature)
    }
}