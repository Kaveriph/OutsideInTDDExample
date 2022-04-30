package com.kaveri.outsideintddexample.unittests

import com.kaveri.outsideintddexample.Car
import com.kaveri.outsideintddexample.Engine
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test

class CarShould {

    val engine: Engine = mock()
    private var car: Car

    init {
        runTest {
          whenever(engine.turnOn()).thenReturn(
              flow {
                  kotlinx.coroutines.delay(2000)
                  emit(25.0)
                  kotlinx.coroutines.delay(2000)
                  emit(50.0)
                  kotlinx.coroutines.delay(2000)
                  emit(95.0)
              }
          )
        }
        car = Car(5.0, engine)
    }

    @Test
    fun looseFuelWhenItTurnsOn() = runTest {
        car.turnOn()
        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runTest {
        car.turnOn()
        verify(engine, times(1)).turnOn()
    }
}