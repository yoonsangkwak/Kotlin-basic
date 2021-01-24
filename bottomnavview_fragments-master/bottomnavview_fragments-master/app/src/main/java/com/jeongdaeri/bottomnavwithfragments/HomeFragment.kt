package com.jeongdaeri.bottomnavwithfragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jeongdaeri.bottomnavwithfragments.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // 뷰가 사라질 때 즉 메모리에서 날라갈 때 같이 날리기 위해 따로 빼두기
    private var fragmentHomeBinding: FragmentHomeBinding? = null

    var count: Int = 0

    companion object {
        const val TAG : String = "로그"

        fun newInstance() : HomeFragment {
            return HomeFragment()
        }

    }

    // 메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomeFragment - onCreate() called")
    }

    // 프레그먼트를 안고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "HomeFragment - onAttach() called")
    }

    // 뷰가 생성되었을 때
    // 프레그먼트와 레이아웃을 연결시켜주는 부분이다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        Log.d(TAG, "HomeFragment - onCreateView() called")

        // 뷰 바인딩 가져오기
        // 홈 프레그먼트 -> 프레그먼트 홈 바인딩
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        fragmentHomeBinding = binding

        fragmentHomeBinding?.homeFragmentBtn?.setOnClickListener {
            Log.d(TAG, "HomeFragment - 홈프레그먼트 버튼이 클릭되었다 called")

            count += 1
            fragmentHomeBinding?.homeFragmentTextView?.text = "홈 $count"
        }

        return fragmentHomeBinding!!.root
    }

    override fun onDestroyView() {
        fragmentHomeBinding = null
        super.onDestroyView()
    }
}
