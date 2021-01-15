package com.example.viewcomponent.android_practice

import java.io.Serializable

class PersonFromServer(
    var id: Int? = null,
    var name: String? = null,
    var age: Int? = null,
    var intro: String? = null
): Serializable