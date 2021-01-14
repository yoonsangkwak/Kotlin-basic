package com.example.viewcomponent

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_network.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkTask(
            recycler_person,
            LayoutInflater.from(this@NetworkActivity)
        ).execute()
    }
}

class NetworkTask(
    val recyclerView: RecyclerView,
    val inflater: LayoutInflater
): AsyncTask<Any?, Any?, Array<PersonFromServer>>() {

    override fun onPostExecute(result: Array<PersonFromServer>?) {
        // 여기는 UI 쓰레드에 접근가능하기 때문에 여기서 뷰를 그려준다
        val adapter = RecyclerViewNetworkAdapter(result!!, inflater)
        recyclerView.adapter = adapter
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: Any?): Array<PersonFromServer> {
        val urlString: String = "http://mellowcode.org/json/students/"
        val url: URL = URL(urlString)
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json")

        var buffer = ""
        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
        }

        val data = Gson().fromJson(buffer, Array<PersonFromServer>::class.java)

        return data
    }
}

class RecyclerViewNetworkAdapter(
    val personList: Array<PersonFromServer>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerViewNetworkAdapter.ViewHolder>() {

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
        holder.id.setText(personList.get(position).id.toString() + "번" ?: "")
        holder.name.setText(personList.get(position).name ?: "")
        holder.age.setText(personList.get(position).age.toString() + "세" ?: "")
        holder.intro.setText(personList.get(position).intro ?: "")
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}