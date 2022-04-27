package com.kaveri.outsideintddexample.unittests

import com.kaveri.outsideintddexample.Car
import com.kaveri.outsideintddexample.Engine
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CarShould {

    val engine :Engine = mock()
    private val car: Car = Car(5.0, engine)
    @Test
    fun looseFuelWhenItTurnsOn() {
        car.turnOn()
        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()
        verify(engine, times(1)).turnOn()
    }
}