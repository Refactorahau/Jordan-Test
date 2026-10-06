package nz.co.trademe.techtest.api

import kotlinx.serialization.json.Json
import nz.co.trademe.techtest.BuildConfig
import nz.co.trademe.techtest.api.model.LatestListingsRequest
import nz.co.trademe.techtest.api.model.LatestListingsResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

/**
 * Entry point for talking to the Trade Me API on a cute environment.
 *
 * The base URL and consumer credentials are read from `local.properties` (see README).
 */
class ApiManager(
    baseUrl: String = BuildConfig.TRADEME_API_BASE_URL,
    consumerKey: String = BuildConfig.TRADEME_CONSUMER_KEY,
    consumerSecret: String = BuildConfig.TRADEME_CONSUMER_SECRET,
) {

    private val json = Json { ignoreUnknownKeys = true }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(consumerKey, consumerSecret))
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val api: TradeMeApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(TradeMeApi::class.java)

    suspend fun getLatestListings(request: LatestListingsRequest): Result<LatestListingsResponse> =
        runCatching { api.getLatestListings(request.toQueryMap()) }
}
