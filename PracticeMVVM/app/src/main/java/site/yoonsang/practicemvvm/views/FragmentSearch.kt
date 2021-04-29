package site.yoonsang.practicemvvm.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import site.yoonsang.practicemvvm.viewmodels.CoronaViewModel
import site.yoonsang.practicemvvm.R
import site.yoonsang.practicemvvm.databinding.FragmentSearchBinding

class FragmentSearch : Fragment() {

    private lateinit var vm: CoronaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentSearchBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_search, container, false)
        vm = ViewModelProvider(this).get(CoronaViewModel::class.java)
        vm.viewInit(binding.fragmentRecycleView)
        vm.getNews()
        vm.uri.observe(viewLifecycleOwner, Observer { uri ->
            val intent = Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        })

        binding.coronaViewModel = vm
        binding.lifecycleOwner = this
        return binding.root
    }
}