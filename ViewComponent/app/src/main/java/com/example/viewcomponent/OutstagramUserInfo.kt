package com.example.viewcomponent

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_outstagram_post_list.all_list
import kotlinx.android.synthetic.main.activity_outstagram_post_list.my_list
import kotlinx.android.synthetic.main.activity_outstagram_post_list.upload
import kotlinx.android.synthetic.main.activity_outstagram_user_info.*

class OutstagramUserInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outstagram_user_info)

        my_list.setOnClickListener {
            startActivity(Intent(this, OutstagramMyPostListActivity::class.java))
        }

        upload.setOnClickListener {
            startActivity(Intent(this, OutstagramUploadActivity::class.java))
        }

        all_list.setOnClickListener {
            startActivity(Intent(this, OutstagramPostListActivity::class.java))
        }

        logout.setOnClickListener {
            val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("login_sp", "null")
            editor.commit()
            (application as MasterApplication).createRetrofit()
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}