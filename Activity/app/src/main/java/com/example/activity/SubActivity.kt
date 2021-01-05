package com.example.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val param = intent.getStringExtra("param")
        Log.d("엑티비티", "param=$param")

        btnReturn.setOnClickListener {
            val intent = Intent()
            intent.putExtra("param2", "돌려드립니다.")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}