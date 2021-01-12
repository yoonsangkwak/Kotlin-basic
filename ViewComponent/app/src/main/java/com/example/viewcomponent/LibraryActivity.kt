package com.example.viewcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library.*

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        Glide.with(this@LibraryActivity)
            .load("https://image.laftel.net/items/thumbs/large/f3203d2d-13e7-43fc-afb0-a43a9a5fe56b.jpg")
            .centerCrop()
            .into(glide)

        Glide.with(this@LibraryActivity)
            .load("https://image.laftel.net/items/thumbs/large/f3203d2d-13e7-43fc-afb0-a43a9a5fe56b.jpg")
            .into(glide2)
    }
}