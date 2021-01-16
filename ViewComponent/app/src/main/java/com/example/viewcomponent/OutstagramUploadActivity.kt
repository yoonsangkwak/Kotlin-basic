package com.example.viewcomponent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import kotlinx.android.synthetic.main.activity_outstagram_upload.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class OutstagramUploadActivity : AppCompatActivity() {

    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outstagram_upload)

        view_pictures.setOnClickListener {
            getPicture()
        }

        upload_post.setOnClickListener {
            uploadPost()
        }

        my_list.setOnClickListener {
            startActivity(Intent(this, OutstagramMyPostListActivity::class.java))
        }

        user_info.setOnClickListener {
            startActivity(Intent(this, OutstagramUserInfo::class.java))
        }

        all_list.setOnClickListener {
            startActivity(Intent(this, OutstagramPostListActivity::class.java))
        }
    }

    fun getPicture() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")
        startActivityForResult(intent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            // 상대경로
            val uri: Uri = data!!.data!!
            filePath = getImageFilePath(uri)
            Log.d("pathh", "path : " + filePath)
        }
    }

    // 실제 파일이 위치한 경로 찾기 (절대경로)
    fun getImageFilePath(contentUri: Uri): String {
        var columnIndex = 0
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(contentUri, projection, null, null, null)
        if (cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }

    fun uploadPost() {
        val file = File(filePath)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val part = MultipartBody.Part.createFormData("image", file.name, fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"), getContent())

        (application as MasterApplication).service.uploadPost(
            part, content
        ).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    finish()
                    startActivity(
                        Intent(
                            this@OutstagramUploadActivity,
                            OutstagramMyPostListActivity::class.java
                        )
                    )
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("pathh", "ERROR")
            }
        })
    }

    fun getContent(): String {
        return content_input.text.toString()
    }
}