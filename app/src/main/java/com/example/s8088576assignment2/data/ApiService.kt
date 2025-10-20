package com.example.s8088576assignment2.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// --- Data classes for API requests and responses ---data class LoginRequest(val username: String, val password: String)

data class LoginResponse(val keypass: String)

data class DashboardResponse(
    val entities: List<Entity>,
    val entityTotal: Int
)

data class Entity(
    val property1: String,
    val property2: String,
    val description: String
) : java.io.Serializable // Implement Serializable to pass it between activities

// --- Retrofit API Service Interface ---

interface ApiService {

    @POST("{location}/auth")
    suspend fun login(
        @Path("location") location: String,
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getDashboardData(
        @Path("keypass") keypass: String
    ): Response<DashboardResponse>
}
