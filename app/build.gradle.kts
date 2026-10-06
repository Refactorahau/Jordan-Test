import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.serialization)
}

val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) file.inputStream().use { load(it) }
}

fun localProperty(key: String, default: String = ""): String =
    localProperties.getProperty(key) ?: default

android {
    namespace = "nz.co.trademe.techtest"
    compileSdk = 37

    defaultConfig {
        applicationId = "nz.co.trademe.techtest"
        minSdk = 28
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "TRADEME_API_BASE_URL", "\"${localProperty("trademe.apiBaseUrl", "https://api.mobiletechtest.test.cutely.app/")}\"")
        buildConfigField("String", "TRADEME_CONSUMER_KEY", "\"${localProperty("trademe.consumerKey")}\"")
        buildConfigField("String", "TRADEME_CONSUMER_SECRET", "\"${localProperty("trademe.consumerSecret")}\"")
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    implementation(libs.androidx.activity)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.kotlinx.serialization)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    testImplementation(libs.junit)
}
