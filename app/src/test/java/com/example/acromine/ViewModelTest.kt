@file:OptIn(ExperimentalCoroutinesApi::class)

package com.example.acromine

import com.example.acromine.repository.NetworkModule
import com.example.acromine.repository.Repository
import com.example.acromine.util.AB
import com.example.acromine.util.AB_CAPITAL
import com.example.acromine.viewmodel.AcromineViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.Test


class ViewModelTest{

    private lateinit var repository: Repository
    private lateinit var viewModel: AcromineViewModel


    @Before
    fun setUp() {
        repository = Repository(NetworkModule.provideNetworkCall(NetworkModule.provideRetrofit()))
        viewModel = AcromineViewModel(repository)
    }


    @Test
    fun testViewModel() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)

        try {
            viewModel.searchAcronym(AB)
            advanceUntilIdle()
            //not sure advance until idle is not working
            print(viewModel.lDisplayList.value)
            viewModel.lDisplayList.value?.let {
                assertEquals(it[0].acronyms, AB_CAPITAL)
            }
        } finally {
            Dispatchers.resetMain()
        }

    }
}