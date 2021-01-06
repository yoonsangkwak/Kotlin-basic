package com.example.sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*
import java.text.SimpleDateFormat

class RecyclerAdapter : RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setMemo(memo: Memo) {
        itemView.textNumber.text = "${memo.num}"
        itemView.textContent.text = "${memo.content}"
        val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
        val datetime = sdf.format(memo.datetime)
        itemView.textDatetime.text = "${datetime}"
    }
}