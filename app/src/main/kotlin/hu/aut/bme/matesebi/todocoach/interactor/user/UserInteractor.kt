package hu.aut.bme.matesebi.todocoach.interactor.user

import android.util.Log
import hu.aut.bme.matesebi.todocoach.network.NetworkConfig
import hu.aut.bme.matesebi.todocoach.network.OAuthApi
import javax.inject.Inject

class UserInteractor @Inject constructor(private val oAuthApi: OAuthApi) {
    private val client_id = "f52924b6a02241bb94c248ca58648df3"
    private val client_secret = "29d1efb1ebb645af96862d6003c7145d"
    private val redirect_uri = "todocoach://callback"
    private val scope = "data:read_write"

    var authCode: String? = null

    var token: String? = null

    suspend fun getAuthorization(): String {
        if (token == null) {
            Log.d("auth", "Loading token from api")
            token = oAuthApi.getAccessCode(client_id, client_secret, authCode!!).accessToken
            Log.d("auth", "Loaded token: $token")
        }
        return "Bearer $token"
    }

    fun isAuthorized() = token != authCode

    fun getAuthorizationUrl() = "${NetworkConfig.OAUTH_URL}oauth/authorize?client_id=$client_id&scope=$scope&redirect_uri=$redirect_uri"
}