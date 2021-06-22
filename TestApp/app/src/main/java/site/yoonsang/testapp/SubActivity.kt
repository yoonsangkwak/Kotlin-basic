package site.yoonsang.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        Log.d("checkkk", "Sub onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("checkkk", "Sub onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("checkkk", "Sub onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("checkkk", "Sub onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("checkkk", "Sub onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("checkkk", "Sub onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("checkkk", "Sub onRestart")
    }
}