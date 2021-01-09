package com.example.viewcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_listener.*

class Listener : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        // 뷰를 activity로 가져오는 방법
        // 1. 직접 찾아서 가져온다
//        val textView: TextView = findViewById(R.id.hello)
        // 2. xml을 import해서 가져온다
//        hello

        // 1. 람다 방식
        hello.setOnClickListener {
            Log.d("click", "Click!!")
        }

        // 2. 익명함수 방식
        hello.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")
            }
        })

        // 3. 익명함수 사용안할시 (이름이 필요한 경우)
        val click = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")
            }
        }
        hello.setOnClickListener(click)
    }
}