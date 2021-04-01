package site.yoonsang.databindingpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import site.yoonsang.databindingpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity
        setRcv()
    }

    fun btnClick(view: View) {
        Toast.makeText(this, "Button Click", Toast.LENGTH_SHORT).show()
    }

    private fun setRcv() {
        val profileAdapter = ProfileAdapter(this)
        binding.mainRcv.layoutManager = LinearLayoutManager(this)
        binding.mainRcv.adapter = profileAdapter
        profileAdapter.data = listOf(
            ProfileData(profile = "https://firebasestorage.googleapis.com/v0/b/softsquared-instaclone.appspot.com/o/douner.jpg?alt=media&token=55afba2e-2357-461a-acea-03f5cd4a294b", name = "Kang", age = 22),
            ProfileData(profile = "https://firebasestorage.googleapis.com/v0/b/softsquared-instaclone.appspot.com/o/michol.jpg?alt=media&token=76437ae3-c1e9-4c05-ba19-c5fbc65718d6", name = "Kwak", age = 26),
            ProfileData(profile = getString(R.string.img), name = "Kwak", age = 26),
        )
        profileAdapter.notifyDataSetChanged()
    }
}