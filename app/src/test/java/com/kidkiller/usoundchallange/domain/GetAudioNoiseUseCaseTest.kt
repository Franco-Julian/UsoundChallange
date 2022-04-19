package com.kidkiller.usoundchallange.domain

import com.kidkiller.usoundchallange.data.AudioNoiseRepository
import com.kidkiller.usoundchallange.domain.model.AudioNoise
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAudioNoiseUseCaseTest {

    @RelaxedMockK
    private lateinit var audioNoiseRepository: AudioNoiseRepository

    lateinit var getAudioNoiseUseCase: GetAudioNoiseUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getAudioNoiseUseCase = GetAudioNoiseUseCase(audioNoiseRepository)
    }

    @Test
    fun `when the api doesnt return anything then get values from database`() = runBlocking {
        //Given
        coEvery { audioNoiseRepository.getAudioNoiseFromApi() } returns emptyList()

        //When
        getAudioNoiseUseCase()

        //Then
        coVerify(exactly = 1) { audioNoiseRepository.getAudioNoiseFromDatabase() }
        coVerify(exactly = 0) { audioNoiseRepository.clearAudioNoise() }
        coVerify(exactly = 0) { audioNoiseRepository.insertAudioNoise(any()) }

    }

    @Test
    fun `when the api return something then get values from api`() = runBlocking {
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
            )
        )
        coEvery { audioNoiseRepository.getAudioNoiseFromApi() } returns myList

        //When
        val response = getAudioNoiseUseCase()

        //Then
        coVerify(exactly = 1) { audioNoiseRepository.clearAudioNoise() }
        coVerify(exactly = 1) { audioNoiseRepository.insertAudioNoise(any()) }
        coVerify(exactly = 0) { audioNoiseRepository.getAudioNoiseFromDatabase() }
        assert(myList == response)
    }
}
