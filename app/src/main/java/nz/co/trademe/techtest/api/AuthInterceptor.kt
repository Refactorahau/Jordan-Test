package nz.co.trademe.techtest.api

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Adds application-level OAuth (PLAINTEXT) authorisation to every request.
 */
class AuthInterceptor(
    private val consumerKey: String,
    private val consumerSecret: String,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header(
                "Authorization",
                "OAuth oauth_consumer_key=\"$consumerKey\", " +
                    "oauth_signature_method=\"PLAINTEXT\", " +
                    "oauth_signature=\"$consumerSecret&\"",
            )
            .build()
        return chain.proceed(request)
    }
}
