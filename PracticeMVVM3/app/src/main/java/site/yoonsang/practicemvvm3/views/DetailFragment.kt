package site.yoonsang.practicemvvm3.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import site.yoonsang.practicemvvm3.R
import site.yoonsang.practicemvvm3.databinding.FragmentDetailBinding
import site.yoonsang.practicemvvm3.models.BookmarkNews
import site.yoonsang.practicemvvm3.viewmodels.DetailViewModel

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val viewModel by viewModels<DetailViewModel>()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = DetailFragmentArgs.fromBundle(requireArguments())
        val news = args.news

        binding.lifecycleOwner = this
        binding.news = news

        var _isChecked = false
        CoroutineScope(Dispatchers.Main).launch {
            val count = viewModel.checkNews(news.hashCode().toString())

            withContext(Dispatchers.Main) {
                if (count > 0) {
                    binding.detailSaveToggleButton.isChecked = true
                    _isChecked = true
                } else {
                    binding.detailSaveToggleButton.isChecked = false
                    _isChecked = false
                }
            }
        }

        binding.detailSaveToggleButton.setOnClickListener {
            _isChecked = !_isChecked
            if (_isChecked) {
                viewModel.addToBookmark(
                    BookmarkNews(
                        news.hashCode(),
                        news.description,
                        news.link,
                        news.originallink,
                        news.pubDate,
                        news.title
                    )
                )
                Toast.makeText(requireContext(), "북마크에 추가되었습니다", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.removeFromBookmark(news.title)
                Toast.makeText(requireContext(), "북마크에서 제거되었습니다", Toast.LENGTH_SHORT).show()
            }
            binding.detailSaveToggleButton.isChecked = _isChecked
        }

        binding.detailLinkButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(news.link))
            startActivity(intent)
        }

        binding.detailOriginalLinkButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(news.originallink))
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}