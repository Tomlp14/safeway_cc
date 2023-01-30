package com.example.acromine.repository

import com.example.acromine.model.Response
import com.example.acromine.util.DICTIONARY
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NetworkCall {
    @GET(DICTIONARY)
    suspend fun getAcronym(
        @QueryMap
    parameter : Map<String, String>
    ): List<Response>
}