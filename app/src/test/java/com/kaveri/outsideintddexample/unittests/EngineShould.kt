package com.kaveri.outsideintddexample.unittests

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import com.kaveri.outsideintddexample.Engine
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class EngineShould {

    val engine = Engine()

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun engineShouldTurnOn() = runTest{
        engine.turnOn()
        Assert.assertTrue(engine.isTurnedOn)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun engineSHouldHeatUpOnTurnOnGradually() = runTest {
        val flow = engine.turnOn()
        val list = flow.toList()
        Assert.assertEquals(listOf(25.0, 50.0, 95.0), list)
        /*coroutinesTestRule.testScheduler.advanceTimeBy(2001)
        Assert.assertEquals(25.0, engine.temperature, 0.0)

        coroutinesTestRule.advanceTimeBy(2001)
        Assert.assertEquals(50.0, engine.temperature, 0.0)

        coroutinesTestRule.advanceTimeBy(2001)
        Assert.assertEquals(95.0, engine.temperature, 0.0)*/
    }
}