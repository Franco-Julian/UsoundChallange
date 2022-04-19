package com.kidkiller.usoundchallange.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kidkiller.usoundchallange.domain.GetAudioNoiseUseCase
import com.kidkiller.usoundchallange.domain.model.AudioNoise
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeScreenViewModelTest {
    @RelaxedMockK
    private lateinit var getAudioNoiseUseCase: GetAudioNoiseUseCase

    private lateinit var viewModel: HomeScreenViewModel

    @get:Rule
    var rule:InstantTaskExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        viewModel= HomeScreenViewModel(getAudioNoiseUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created, get all Audio Noise and set the values`() = runTest {
        //Given
        val myList = listOf(
            AudioNoise(
            1,
            "a",
            true,
            2,
            "2",
            0.3F,
            0.2F,
            0.4F,
            0.4F,
            1.2F,
            2.4F,
            "test",
            "10/3/2022",
            2
        ),AudioNoise(
                1,
                "a",
                true,
                2,
                "2",
                0.3F,
                0.2F,
                0.4F,
                0.4F,
                1.2F,
                2.4F,
                "test",
                "10/3/2022",
                2
            )
        )
        coEvery { getAudioNoiseUseCase() } returns myList

        //When
        viewModel.onCreate()

        //Then
        assert(viewModel.audioNoiseList.value == myList)
    }

    @Test
    fun `if getAudioNoiseUseCase returns null keep the last value`() = runTest {
        //Given
        val myList = listOf(
            AudioNoise(
                1,
                "a",
                true,
                2,
                "2",
                0.3F,
                0.2F,
                0.4F,
                0.4F,
                1.2F,
                2.4F,
                "test",
                "10/3/2022",
                2
            ),AudioNoise(
                1,
                "a",
                true,
                2,
                "2",
                0.3F,
                0.2F,
                0.4F,
                0.4F,
                1.2F,
                2.4F,
                "test",
                "10/3/2022",
                2
            )
        )
        viewModel._audioNoiseList.value = myList
        coEvery { getAudioNoiseUseCase() } returns emptyList()

        //When
        viewModel.onCreate()

        //Then
        assert(viewModel.audioNoiseList.value == myList)

    }
}