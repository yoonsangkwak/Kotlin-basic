package com.example.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import java.text.SimpleDateFormat

class CustomAdapter : RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return Holder(itemView)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, SubActivity::class.java)
            intent.putExtra("no", itemView.textNumber.text)
            intent.putExtra("title", itemView.textTitle.text)
            intent.putExtra("date", itemView.textDate.text)
            itemView.context.startActivity(intent)
        }
    }

    fun setMemo(memo: Memo) {
        itemView.textNumber.text = "${memo.no}"
        itemView.textTitle.text = memo.title

        val sdf = SimpleDateFormat("yyyy/MM/dd")
        val date = sdf.format(memo.timestamp)
        itemView.textDate.text = date
    }
}