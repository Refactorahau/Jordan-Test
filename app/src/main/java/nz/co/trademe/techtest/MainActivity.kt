package nz.co.trademe.techtest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import nz.co.trademe.techtest.api.ApiManager
import nz.co.trademe.techtest.api.model.LatestListingsRequest

class MainActivity : ComponentActivity() {

    private val apiManager = ApiManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            apiManager.getLatestListings(LatestListingsRequest())
                .onSuccess { Log.d(TAG, "Latest listings: $it") }
                .onFailure { Log.e(TAG, "Failed to fetch latest listings", it) }
        }
    }

    private companion object {
        const val TAG = "MainActivity"
    }
}
