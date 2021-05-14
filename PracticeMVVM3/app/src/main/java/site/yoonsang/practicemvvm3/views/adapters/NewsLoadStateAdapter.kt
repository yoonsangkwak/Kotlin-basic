package site.yoonsang.practicemvvm3.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import site.yoonsang.practicemvvm3.databinding.NewsLoadStateFooterBinding

class NewsLoadStateAdapter() : LoadStateAdapter<NewsLoadStateAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: NewsLoadStateFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        val binding =
            NewsLoadStateFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }
}