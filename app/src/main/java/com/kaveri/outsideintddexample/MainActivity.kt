package com.kaveri.outsideintddexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var car = Car(200.0, Engine())
        CoroutineScope(Dispatchers.Main).launch {
            car.turnOn()
        }
        setContentView(R.layout.activity_main)
    }
}