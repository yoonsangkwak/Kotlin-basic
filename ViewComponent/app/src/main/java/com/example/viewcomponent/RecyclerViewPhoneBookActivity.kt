package com.example.viewcomponent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.activity_recycler_view_phone_book.*

class RecyclerViewPhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_phone_book)

        with(recycler_phone) {
            this.adapter = PhoneBookRecyclerAdapter(
                phoneBookList = createFakePhoneBook(30),
                inflater = LayoutInflater.from(this@RecyclerViewPhoneBookActivity),
                activity = this@RecyclerViewPhoneBookActivity
            )
            this.layoutManager = LinearLayoutManager(this@RecyclerViewPhoneBookActivity)
        }
    }

    fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until fakeNumber) {
            val j: String = if (i < 10) "0" + i else i.toString()
            phoneBook.addPerson(
                Person(name = "홍길동" + i, number = "010-1234-56" + j)
            )
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phoneBookList: PhoneBook,
    val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView

        init {
            personName = itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener {
                val intent = Intent(activity, PhoneBookDetailActivity::class.java)
                intent.putExtra("name", phoneBookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phoneBookList.personList.get(adapterPosition).number)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_phone_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phoneBookList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return phoneBookList.personList.size
    }
}