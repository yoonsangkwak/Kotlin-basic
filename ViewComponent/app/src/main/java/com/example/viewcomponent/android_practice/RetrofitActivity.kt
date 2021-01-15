package com.example.viewcomponent.android_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.viewcomponent.R
import com.example.viewcomponent.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        // http://mellowcode.org/json/students/
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        // GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>> {
            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if (response.isSuccessful) {
                    val personList = response.body()
                    Log.d("retrofitt", "res : " + personList?.get(0)?.age)

                    val code = response.code()
                    Log.d("retrofitt", "code : " + code)

                    val error = response.errorBody()
                    Log.d("retrofitt", "errorbody : " + error)
                    val header = response.headers()
                    Log.d("retrofitt", "header : " + header)
                }
            }

            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "ERROR")
            }
        })

        // POST 요청 - 1
//        val params = HashMap<String, Any>()
//        params.put("name", "홍길동")
//        params.put("age", 28)
//        params.put("intro", "안녕 날 소개하지")
//        service.createStudents(params).enqueue(object : Callback<PersonFromServer> {
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if (response.isSuccessful) {
//                    val person = response.body()
//                    Log.d("retrofitt", "name : " + person?.name)
//                }
//            }
//
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//            }
//        })

        // POST 요청 - 2
        val person = PersonFromServer(name = "신짱구", age = 5, intro = "부리부리부리")
        service.createStudentsEasy(person).enqueue(object : Callback<PersonFromServer> {
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if (response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "name : " + person?.name)
                }
            }

            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
            }
        })
    }
}