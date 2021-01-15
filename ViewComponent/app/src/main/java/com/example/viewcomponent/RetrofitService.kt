package com.example.viewcomponent

import com.example.viewcomponent.android_practice.PersonFromServer
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET("json/students/")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>

    @POST("json/students/")
    fun createStudents(
        @Body params: HashMap<String, Any>
    ): Call<PersonFromServer>

    @POST("json/students/")
    fun createStudentsEasy(
        @Body person: PersonFromServer
    ): Call<PersonFromServer>

    @POST("user/signup/")
    @FormUrlEncoded
    fun register(
        @Field("username") username: String,
        @Field("password1") password1: String,
        @Field("password2") password2: String,
    ): Call<User>
}