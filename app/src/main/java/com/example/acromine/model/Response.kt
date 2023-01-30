package com.example.acromine.model

import com.google.gson.annotations.SerializedName

data class Response (
    @SerializedName("sf"  ) var sf  : String?        = null,
    @SerializedName("lfs" ) var lfs : ArrayList<Lfs> = arrayListOf()
)