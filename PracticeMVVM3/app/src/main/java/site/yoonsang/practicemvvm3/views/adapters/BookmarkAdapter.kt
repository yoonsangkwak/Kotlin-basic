package site.yoonsang.practicemvvm3.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import site.yoonsang.practicemvvm3.databinding.ItemBookmarkNewsBinding
import site.yoonsang.practicemvvm3.models.BookmarkNews

class BookmarkAdapter(val clickListener: NewsClickListener): ListAdapter<BookmarkNews, BookmarkAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback: DiffUtil.ItemCallback<BookmarkNews>() {
        override fun areItemsTheSame(oldItem: BookmarkNews, newItem: BookmarkNews): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: BookmarkNews, newItem: BookmarkNews): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding: ItemBookmarkNewsBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(bookmarkNews: BookmarkNews) {
            binding.bookmarkNews = bookmarkNews
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBookmarkNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickListener.onClick(item)
        }
    }

    class NewsClickListener(val clickListener: (bookmarkNews: BookmarkNews) -> Unit) {
        fun onClick(bookmarkNews: BookmarkNews) = clickListener(bookmarkNews)
    }
}