plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.kaka.telegram"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.kaka.telegram"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField(
            "int",
            "TELEGRAM_API_ID",
            "0"
        )

        buildConfigField(
            "String",
            "TELEGRAM_API_HASH",
            "\"YOUR_API_HASH\""
        )
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")

    // TDLib Android
}
