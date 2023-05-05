package com.example.nasaimagesearch.dagger


import okhttp3.mockwebserver.MockWebServer
import retrofit2.converter.gson.GsonConverterFactory
import com.example.nasaimagesearch.api.NasaApi
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import retrofit2.Retrofit

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppModuleTest {


    private lateinit var mockWebServer: MockWebServer

    private lateinit var retrofit: Retrofit

    private lateinit var nasaApi: NasaApi

    @BeforeAll
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("https://images-api.nasa.gov/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        nasaApi = retrofit.create(NasaApi::class.java)
    }

    @AfterAll
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `provideRetrofit should create a Retrofit instance with the correct base URL`() {
        // Arrange
        val expectedBaseUrl: String = mockWebServer.url("/").toString()

        //Act
        val actualBaseUrl: String = AppModule.provideRetrofit().baseUrl().toString()

        //Assert
        assertEquals(
            expectedBaseUrl,
            actualBaseUrl,
            "Retrofit base URL should match the mock server URL"
        )
    }

    @Test
    fun `providesNasaApi should create an Api instance with the provided Retrofit instance`() {

        val actualNasaApi = AppModule.providesNasaApi(retrofit)
        // Assert
        assertNotNull(actualNasaApi.toString(), "NasaApi object should not be null")
        assertEquals(
            "https://images-api.nasa.gov/",
            "NasaApi.BASE_URL",
            "NasaApi base URL should match the provided instance"
        )
    }
}