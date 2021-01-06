package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val DB_NAME = "sqlite.sql"
    val DB_VERSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helper = SqliteHelper(this, DB_NAME, DB_VERSION)
        val adapter = RecyclerAdapter()

        val memos = helper.selectMemo()
        adapter.listData.addAll(memos)

        recyclerMemo.adapter = adapter
        recyclerMemo.layoutManager = LinearLayoutManager(this)

        buttonSave.setOnClickListener {
            val content = editMemo.text.toString()
            if (content.isNotEmpty()) {
                val memo = Memo(null, content, System.currentTimeMillis())
                helper.insertMemo(memo)
                // 기존 작성글 삭제
                editMemo.setText("")
                // 목록 갱신
                adapter.listData.clear()
                adapter.listData.addAll(helper.selectMemo())
                adapter.notifyDataSetChanged()
            }
        }
    }
}