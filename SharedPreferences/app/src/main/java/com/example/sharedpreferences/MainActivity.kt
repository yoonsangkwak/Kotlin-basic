package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val SP_NAME = "my_sp_storage"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        writeSharedPreference("name", "마이클")
        val value = readSharedPreference("name")
        Log.d("프리퍼런스", "name=$value")
    }

    fun writeSharedPreference(key: String, value: String) {
        val sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun readSharedPreference(key: String) : String {
        val sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        return sp.getString("name", "") ?: ""
    }
}