package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.item.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val no = intent.getStringExtra("no")
        val title = intent.getStringExtra("title")
        val date = intent.getStringExtra("date")

        textNumber.text = no
        textTitle.text = title
        textDate.text = date
    }
}