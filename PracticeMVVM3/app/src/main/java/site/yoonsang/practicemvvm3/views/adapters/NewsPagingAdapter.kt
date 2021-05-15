package site.yoonsang.practicemvvm3.views.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import site.yoonsang.practicemvvm3.databinding.ItemNewsBinding
import site.yoonsang.practicemvvm3.models.News

class NewsPagingAdapter(private val listener: OnItemClickListener): PagingDataAdapter<News, NewsPagingAdapter.ViewHolder>(NEWS_COMPARATOR) {

    companion object {
        private val NEWS_COMPARATOR = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem.link == newItem.link
            }

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.news = news
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            val newTitle = Html.fromHtml(currentItem.title, Html.FROM_HTML_MODE_LEGACY).toString()
            val newItem = News(
                currentItem.description,
                currentItem.link,
                currentItem.originallink,
                currentItem.pubDate,
                newTitle
            )
            holder.bind(newItem)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(news: News)
    }
}