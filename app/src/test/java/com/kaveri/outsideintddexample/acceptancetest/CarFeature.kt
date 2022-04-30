package com.kaveri.outsideintddexample.acceptancetest

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import com.kaveri.outsideintddexample.Car
import com.kaveri.outsideintddexample.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class CarFeature {

    val engine = Engine()
    val car = Car(6.0, engine)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() = runTest {
        car.turnOn()
        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIdTurningOnEngineAndIncreasingTemperatureGradually() = runBlocking {
        car.turnOn()
        coroutinesTestRule.advanceTimeBy(2001)
        assertEquals(25.0, car.engine.temperature)

        coroutinesTestRule.advanceTimeBy(2001)
        assertEquals(50.0, car.engine.temperature)

        coroutinesTestRule.advanceTimeBy(2001)
        assertEquals(95.0, car.engine.temperature)
    }
}