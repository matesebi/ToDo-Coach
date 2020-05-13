package hu.aut.bme.matesebi.todocoach.network

class MockOAuthApi: OAuthApi {
    override fun authorize(queryParams: Map<String, String>) {
        TODO("Not yet implemented")
    }

    override suspend fun getAccessCode(clientId: String, clientSecret: String, code: String): OAuthApi.AccessToken {
        TODO("Not yet implemented")
    }

}