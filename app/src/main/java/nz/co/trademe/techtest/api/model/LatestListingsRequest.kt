package nz.co.trademe.techtest.api.model

/**
 * Query parameters for `GET /v1/listings/latest.json`.
 */
data class LatestListingsRequest(
    val page: Int = 1,
    val rows: Int = 20,
) {

    fun toQueryMap(): Map<String, String> = mapOf(
        "page" to page.toString(),
        "rows" to rows.toString(),
    )
}
