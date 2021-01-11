package com.example.viewcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_resource.*

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val ment = resources.getString(R.string.hello)
        Log.d("ment", "ment : " + ment)

        val ment2 = getString(R.string.hello)
        Log.d("ment", "ment2 : " + ment2)

        // SDK 버전에 따른 분기처리
        // getColor -> API 23 이상만 사용가능
        val color = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            button.setBackgroundColor(getColor(R.color.textview_color))
        } else {
            button.setBackgroundColor(resources.getColor(R.color.textview_color))
        }
        Log.d("ment", "color : " + color)

    }
}