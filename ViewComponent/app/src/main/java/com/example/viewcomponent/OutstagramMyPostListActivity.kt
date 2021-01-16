package com.example.viewcomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_outstagram_my_post_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OutstagramMyPostListActivity : AppCompatActivity() {

    lateinit var myPostRecyclerView: RecyclerView
    lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outstagram_my_post_list)

        myPostRecyclerView = mypost_recycler_view
        glide = Glide.with(this@OutstagramMyPostListActivity)
        createList()

        all_list.setOnClickListener {
            startActivity(Intent(this, OutstagramPostListActivity::class.java))
        }

        upload.setOnClickListener {
            startActivity(Intent(this, OutstagramUploadActivity::class.java))
        }

        user_info.setOnClickListener {
            startActivity(Intent(this, OutstagramUserInfo::class.java))
        }
    }

    fun createList() {
        (application as MasterApplication).service.getUserPostList()
            .enqueue(object : Callback<ArrayList<Post>> {
                override fun onResponse(
                    call: Call<ArrayList<Post>>,
                    response: Response<ArrayList<Post>>
                ) {
                    if (response.isSuccessful) {
                        val myPostList = response.body()
                        val adapter = MyPostAdapter(myPostList!!, LayoutInflater.from(this@OutstagramMyPostListActivity), glide)
                        myPostRecyclerView.adapter = adapter
                        myPostRecyclerView.layoutManager = LinearLayoutManager(this@OutstagramMyPostListActivity)
                    }
                }

                override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                }
            }
        )
    }
}

class MyPostAdapter(
    var postList: ArrayList<Post>,
    val inflater: LayoutInflater,
    val glide: RequestManager
) : RecyclerView.Adapter<MyPostAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postOwner: TextView
        val postImage: ImageView
        val postContent: TextView

        init {
            postOwner = itemView.findViewById(R.id.post_owner)
            postImage = itemView.findViewById(R.id.post_img)
            postContent = itemView.findViewById(R.id.post_content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.outstagram_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postOwner.setText(postList.get(position).owner)
        holder.postContent.setText(postList.get(position).content)
        glide.load(postList.get(position).image).into(holder.postImage)
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
