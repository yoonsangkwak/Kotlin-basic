package com.example.viewcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_retrofit_recycler.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_recycler)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>> {
            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if (response.isSuccessful) {
                    val personList = response.body()
                    val adapter = RetrofitAdapter(personList!!, LayoutInflater.from(this@RetrofitRecyclerActivity))
                    retrofit_recyclerview.adapter = adapter
                    retrofit_recyclerview.layoutManager = LinearLayoutManager(this@RetrofitRecyclerActivity)
                }
            }

            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("check", "ERROR")
            }
        })
    }
}

class RetrofitAdapter(
    val personList: ArrayList<PersonFromServer>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RetrofitAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val id: TextView
        val name: TextView
        val age: TextView
        val intro: TextView

        init {
            id = itemView.findViewById(R.id.network_person_id)
            name = itemView.findViewById(R.id.network_person_name)
            age = itemView.findViewById(R.id.network_person_age)
            intro = itemView.findViewById(R.id.network_person_intro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_person, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.setText(personList.get(position).id.toString() + "번")
        holder.name.setText(personList.get(position).name)
        holder.age.setText(personList.get(position).age.toString() + "세")
        holder.intro.setText(personList.get(position).intro)
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}