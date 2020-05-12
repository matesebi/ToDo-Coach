package hu.aut.bme.matesebi.todocoach.network

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.*

interface OAuthApi {

    @POST("authorize")
    @FormUrlEncoded
    fun authorize(@QueryMap queryParams: Map<String, String>)

    @POST("access_token")
    @FormUrlEncoded
    @Headers("Accept: application/json")
    fun getAccessCode(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String
    ): Call<AccessToken>

    class AccessToken(@SerializedName("access_token") val accessToken: String)
}