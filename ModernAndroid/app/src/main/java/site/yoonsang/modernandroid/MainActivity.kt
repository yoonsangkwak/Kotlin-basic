package site.yoonsang.modernandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import site.yoonsang.modernandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()


        db.todoDao().getAll().observe(this, Observer { todos ->
            binding.resultText.text = todos.toString()
        })

        binding.btnAdd.setOnClickListener {
            db.todoDao().insert(Todo(binding.editTodo.text.toString()))
        }
    }
}