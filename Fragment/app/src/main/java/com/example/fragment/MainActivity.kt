package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment()
    }

    fun setFragment() {
        // 1. 삽입할 프레그먼트 생성
        val fragment = ListFragment()
        // 2. 삽입 트랜잭션 시작
        val transaction = supportFragmentManager.beginTransaction()
        // 3. 트랜잭션을 통해서 프래그먼트를 삽입
        transaction.add(R.id.frameLayout, fragment)
        // 4. 커밋
        transaction.commit()
    }

    fun goDetail() {
        // 1. 삽입할 프레그먼트 생성
        val detail = DetailFragment()
        // 2. 삽입 트랜잭션 시작
        val transaction = supportFragmentManager.beginTransaction()
        // 3. 트랜잭션을 통해서 프래그먼트를 삽입
        transaction.add(R.id.frameLayout, detail)
        // 4. 뒤로가기 버튼을 사용하기 위한 처리
        transaction.addToBackStack("detail")
        // 5. 커밋
        transaction.commit()
    }

    fun goBack() {
        onBackPressed()
    }
}