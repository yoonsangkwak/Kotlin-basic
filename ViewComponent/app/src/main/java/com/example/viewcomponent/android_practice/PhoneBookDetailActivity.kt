package com.example.viewcomponent.android_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewcomponent.R
import kotlinx.android.synthetic.main.activity_phone_book_detail.*

class PhoneBookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)

        getPersonInfoDraw()

        back.setOnClickListener {
            onBackPressed()
        }
    }

    fun getPersonInfoDraw() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        person_detail_name.setText(name)
        person_detail_number.setText(number)
    }
}