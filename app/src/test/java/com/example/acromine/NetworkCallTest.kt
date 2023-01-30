package com.example.acromine

import com.example.acromine.repository.NetworkModule
import com.example.acromine.repository.Repository
import com.example.acromine.util.AB
import com.example.acromine.util.ANTIBODY
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class NetworkCallTest {
    private lateinit var repository: Repository
    @Before
    fun setUp() {
        repository = Repository(NetworkModule.provideNetworkCall(NetworkModule.provideRetrofit()))
    }
    @Test
    fun getAcronym() {
        runBlocking {
            val response = repository.getAcronym(AB)
            print(response)
            assertEquals(response[0].sf, AB)
        }
    }
    @Test
    fun getLongForm() {
        runBlocking {
            val response = repository.getLongForm(ANTIBODY)
            assertEquals(response[0].sf, AB)
        }
    }

}