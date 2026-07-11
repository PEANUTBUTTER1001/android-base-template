plugins {
    id("my.android.application")
    id("my.android.compose")
    id("my.android.hilt")
    id("my.android.navigation")
}

android {
    namespace = "com.peanutbutter1001.android_base_template"

    defaultConfig {
        applicationId = "com.peanutbutter1001.android_base_template"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    // Android Core & Lifecycle
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.core.splashscreen)

    implementation(libs.bundles.compose.core)
    debugImplementation(libs.bundles.compose.debug)

    // Navigation 3(Type-safe) 및 Hilt-Navigation 연동은 아래 convention 이 담당:
    //   my.android.navigation → serialization 플러그인 + Nav3 번들 + serialization-json
    //   my.android.hilt       → hilt-navigation-compose
}
