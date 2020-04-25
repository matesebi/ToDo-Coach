package hu.aut.bme.matesebi.todocoach.network

import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface OAuthApi {

    @POST("authorize")
    @FormUrlEncoded
    fun authorize(@QueryMap queryParams: Map<String, String>)

    @POST("access_token")
    @FormUrlEncoded
    fun getAccessCode(@QueryMap queryParams: Map<String, String>)
}