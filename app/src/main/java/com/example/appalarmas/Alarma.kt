package com.example.appalarmas

import java.io.Serializable

data class Alarma(
    var name:String?="",
    var hora:String?="",
    var reto:String?="",
    var tono:String?="",
) : Serializable
