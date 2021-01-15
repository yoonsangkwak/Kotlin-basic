package com.example.viewcomponent.android_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewcomponent.R

class Context : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        val context: Context = this
        val applicationContext = getApplicationContext()
    }
}