# Trade Me Android Tech Test

A minimal, single-activity Android project with no UI. It contains starter code for calling the
Trade Me [latest listings](https://developer.trademe.co.nz/api-reference/listing-methods/retrieve-the-latest-listings)
API on a cute environment.

## Setup

1. Copy `local.properties.example` to `local.properties`.
2. Set `sdk.dir`, plus the cute environment base URL and consumer key/secret you were given.
3. Open the project in Android Studio and run the `app` configuration.

The app makes one request to the latest listings API on launch and logs the result. Filter Logcat
by `MainActivity` or `okhttp` to see it.

## Project layout

```
app/src/main/java/nz/co/trademe/techtest/
├── MainActivity.kt                    # Single activity, no UI
└── api/
    ├── ApiManager.kt                  # Builds the HTTP client and exposes API calls
    ├── AuthInterceptor.kt             # Adds OAuth (PLAINTEXT) consumer auth header
    ├── TradeMeApi.kt                  # Retrofit interface
    └── model/
        ├── LatestListingsRequest.kt   # Query parameters
        └── LatestListingsResponse.kt  # Response body (no fields yet)
```

## Stack

Kotlin, Coroutines, Retrofit, OkHttp, kotlinx.serialization.
