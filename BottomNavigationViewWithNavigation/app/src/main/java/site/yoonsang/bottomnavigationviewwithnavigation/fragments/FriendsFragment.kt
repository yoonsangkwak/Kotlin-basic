package site.yoonsang.bottomnavigationviewwithnavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import site.yoonsang.bottomnavigationviewwithnavigation.databinding.FragmentFriendsBinding
import site.yoonsang.bottomnavigationviewwithnavigation.databinding.FragmentHomeBinding

class FriendsFragment: Fragment() {

    private var mBinding: FragmentFriendsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFriendsBinding.inflate(inflater, container, false)

        mBinding = binding

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}