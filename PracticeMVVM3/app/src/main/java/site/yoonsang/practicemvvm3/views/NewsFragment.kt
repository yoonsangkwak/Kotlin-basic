package site.yoonsang.practicemvvm3.views

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import site.yoonsang.practicemvvm3.R
import site.yoonsang.practicemvvm3.databinding.FragmentNewsBinding
import site.yoonsang.practicemvvm3.viewmodels.NewsViewModel
import site.yoonsang.practicemvvm3.views.adapters.NewsLoadStateAdapter
import site.yoonsang.practicemvvm3.views.adapters.NewsPagingAdapter

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = NewsPagingAdapter()
        binding.newsRecyclerView.adapter = adapter
//        binding.newsRecyclerView.apply {
//            adapter = adapter.withLoadStateHeaderAndFooter(
//                header = NewsLoadStateAdapter {  },
//                footer = NewsLoadStateAdapter {  }
//            )
//        }

        viewModel.searchNews.observe(viewLifecycleOwner) { data ->
            adapter.submitData(viewLifecycleOwner.lifecycle, data)
        }

        binding.newsSearchEditText.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                binding.newsRecyclerView.scrollToPosition(0)
                val query = binding.newsSearchEditText.text.toString()
                viewModel.getSearchNews(query)
                binding.newsSearchEditText.clearFocus()
                return@setOnKeyListener true
            }
            false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}