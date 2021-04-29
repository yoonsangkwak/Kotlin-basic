package site.yoonsang.practicemvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import site.yoonsang.practicemvvm.R
import site.yoonsang.practicemvvm.views.adapter.VPAdapter
import site.yoonsang.practicemvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val vpAdapter: VPAdapter =
                VPAdapter(supportFragmentManager)
        binding.viewpager.adapter = vpAdapter
    }
}