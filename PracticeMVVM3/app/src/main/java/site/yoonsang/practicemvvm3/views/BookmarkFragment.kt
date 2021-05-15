package site.yoonsang.practicemvvm3.views

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import site.yoonsang.practicemvvm3.R
import site.yoonsang.practicemvvm3.databinding.FragmentBookmarkBinding
import site.yoonsang.practicemvvm3.models.News
import site.yoonsang.practicemvvm3.viewmodels.BookmarkViewModel
import site.yoonsang.practicemvvm3.views.adapters.BookmarkAdapter

@AndroidEntryPoint
class BookmarkFragment : Fragment() {

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<BookmarkViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BookmarkAdapter(BookmarkAdapter.NewsClickListener { bookmarkNews ->
            val news = News(
                bookmarkNews.description,
                bookmarkNews.link,
                bookmarkNews.originalLink,
                bookmarkNews.pubDate,
                bookmarkNews.title
            )
            findNavController().navigate(
                BookmarkFragmentDirections.actionBookmarkFragmentToDetailFragment(news)
            )
        })
        binding.libraryRecyclerView.adapter = adapter

        viewModel.news.observe(viewLifecycleOwner) { data ->
            adapter.submitList(data)
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.bindingAdapterPosition
                val news = adapter.currentList[position]
                viewModel.delete(news)

                Snackbar.make(binding.root, "북마크에서 제거되었습니다", Snackbar.LENGTH_LONG)
                    .setAction("취소") {
                        viewModel.insert(news)
                    }
                    .show()
            }
        }).attachToRecyclerView(binding.libraryRecyclerView)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.bookmark_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_delete_all -> deleteAllItem()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllItem() {
        AlertDialog.Builder(requireContext())
            .setTitle("전체 삭제")
            .setMessage("북마크에 내용을 전체 삭제하시겠습니까?")
            .setPositiveButton("확인") { dialog, _ ->
                viewModel.deleteAll()
                dialog.dismiss()
            }
            .setNegativeButton("취소") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}