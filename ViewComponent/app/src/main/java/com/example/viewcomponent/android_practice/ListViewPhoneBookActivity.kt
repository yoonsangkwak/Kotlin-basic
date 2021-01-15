package com.example.viewcomponent.android_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.viewcomponent.R
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.activity_list_view_phone_book.*

class ListViewPhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_phone_book)

        val phoneList = ArrayList<PhoneList>()

        for (i in 0 until 20) {
            val j: String = if (i < 10) "0" + i else i.toString()
            phoneList.add(PhoneList("홍길동" + i, "010-1234-56" + j))
        }

        val adapter =
            ListViewPhoneAdapter(phoneList, LayoutInflater.from(this@ListViewPhoneBookActivity))
        list_phone_book.adapter = adapter
        list_phone_book.setOnItemClickListener { parent, view, position, id ->
            val name = (adapter.getItem(position) as PhoneList).name
            val number = (adapter.getItem(position) as PhoneList).number

            Toast.makeText(this@ListViewPhoneBookActivity,name + " : " + number,Toast.LENGTH_SHORT).show()
            val intent = Intent(this@ListViewPhoneBookActivity, PhoneBookDetailActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("number", number)
            startActivity(intent)
        }
    }
}

class ListViewPhoneAdapter(val phoneList: ArrayList<PhoneList>, val layoutInflater: LayoutInflater) :
    BaseAdapter() {

    override fun getCount(): Int {
        // 그리고자 하는 아이템 리스트의 전체 개수
        return phoneList.size
    }

    override fun getItem(position: Int): Any {
        // 그리고자 하는 아이템 리스트의 하나 (포지션에 해당하는)
        return phoneList.get(position)
    }

    override fun getItemId(position: Int): Long {
        // 해당 포지션에 위치해 있는 아이템뷰의 아이디 설정
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val holder: PhoneViewHolder

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_phone_book, null)
            holder = PhoneViewHolder()
            holder.name = view.findViewById(R.id.person_name)
            holder.number = view.findViewById(R.id.person_number)

            view.tag = holder
        } else {
            holder = convertView.tag as PhoneViewHolder
            view = convertView
        }

        holder.name?.setText(phoneList.get(position).name)
        holder.number?.setText(phoneList.get(position).number)

        return view
    }
}

class PhoneViewHolder {
    var name: TextView? = null
    var number: TextView? = null
}

class PhoneList(val name: String, val number: String) {

}