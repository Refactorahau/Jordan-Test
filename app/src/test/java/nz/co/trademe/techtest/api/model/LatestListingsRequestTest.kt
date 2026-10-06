package nz.co.trademe.techtest.api.model

import org.junit.Assert.assertEquals
import org.junit.Test

class LatestListingsRequestTest {

    @Test
    fun `toQueryMap includes page and rows`() {
        val request = LatestListingsRequest(page = 2, rows = 50)

        assertEquals(mapOf("page" to "2", "rows" to "50"), request.toQueryMap())
    }
}
