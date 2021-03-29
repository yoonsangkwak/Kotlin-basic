package site.yoonsang.modernandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


        binding.resultText.text = db.todoDao().getAll().toString()

        binding.btnAdd.setOnClickListener {
            db.todoDao().insert(Todo(binding.editTodo.text.toString()))
            binding.resultText.text = db.todoDao().getAll().toString()
        }
    }
}