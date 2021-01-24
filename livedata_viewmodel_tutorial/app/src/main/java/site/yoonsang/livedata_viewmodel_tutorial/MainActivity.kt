package site.yoonsang.livedata_viewmodel_tutorial

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import site.yoonsang.livedata_viewmodel_tutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    companion object {
        const val TAG: String = "로그"
    }

    // 나중에 값이 설정될거라고 lateinit으로 설정
    lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 뷰 모델 프로바이더를 통해 뷰모델 가져오기
        // 라이프사이클을 가지고 있는 녀석을 넣어줌, 즉 자기 자신
        // 우리가 가져오고 싶은 뷰모델 클래스를 넣어서 뷰모델을 가져오기
        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        // 뷰모델이 가지고 있는 값의 변경사항을 관찰할 수 있는 라이브 데이터를 옵저빙한다
        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "MainActivity - myNumberViewModel - currentValue 라이드 데이터 값 변경: $it")
            binding.numberTextview.text = it.toString()
        })

        // 리스너 연결
        binding.plusBtn.setOnClickListener(this)
        binding.minusButton.setOnClickListener(this)
    }

    // 클릭
    override fun onClick(view: View?) {
        val userInput = binding.userinputEdittext.text.toString().toInt()

        // 뷰모델에 라이브데이터 값을 변경하는 메소드 실행
        when (view) {
            binding.plusBtn ->
                myNumberViewModel.updateValue(ActionType.PLUS, userInput)
            binding.minusButton ->
                myNumberViewModel.updateValue(ActionType.MINUS, userInput)
        }
    }
}