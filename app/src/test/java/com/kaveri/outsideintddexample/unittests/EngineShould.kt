package com.kaveri.outsideintddexample.unittests

import com.kaveri.outsideintddexample.Engine
import org.junit.Assert
import org.junit.Test

class EngineShould {

    val engine = Engine()
    @Test
    fun engineShouldTurnOn() {
        engine.turnOn()
        Assert.assertTrue(engine.isTurnedOn)
    }

    fun engineSHouldHeatUpOnTurnOn() {
        engine.turnOn()
        Assert.assertEquals(95.0, engine.temperature)
    }
}