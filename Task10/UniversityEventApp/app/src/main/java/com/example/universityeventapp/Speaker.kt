package com.example.universityeventapp

import java.io.Serializable

data class Speaker(
    val name: String,
    val designation: String,
    val photoColor: Int
) : Serializable
