package nz.co.trademe.techtest.api

import nz.co.trademe.techtest.api.model.LatestListingsResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface TradeMeApi {

    @GET("v1/listings/latest.json")
    suspend fun getLatestListings(@QueryMap query: Map<String, String>): LatestListingsResponse
}
