import Libs.Androidx.implementAppLibraries

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.maktabplus"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementAppLibraries()

    implementation(Libs.Retrofit.GSON)
    implementation(Libs.Retrofit.GSON_CONVERTER)
    implementation(Libs.Retrofit.RETROFIT2)

    implementation(Libs.OkHttp.LOGGING_INTERCEPTOR)

    implementation(Libs.Kotlinx.COROUTINES_ANDROID)

    implementation(Libs.Glide.GLIDE)
    implementation(Libs.Glide.COMPILER)

}