package site.yoonsang.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import site.yoonsang.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

//        viewModel.num.observe(this) {
//            binding.num.text = it.toString()
//        }
//
//        binding.btn.setOnClickListener {
//            startActivity(Intent(this, SubActivity::class.java))
//        }

        var count = 1
        binding.numBtn.setOnClickListener {
            count++
            binding.num.text = (count + 1).toString()
        }

        Log.d("checkkk", "main onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("checkkk", "main onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("checkkk", "main onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("checkkk", "main onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("checkkk", "main onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("checkkk", "main onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("checkkk", "main onRestart")
    }
}