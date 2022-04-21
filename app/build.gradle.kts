import Libs.Androidx.implementAppLibraries

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.example.maktabplus"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = Versions.VERSION_CODE
        versionName = Versions.versionName

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
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.activity:activity-ktx:1.4.0")
    implementation("androidx.fragment:fragment-ktx:1.4.1")
    implementation(Libs.Androidx.Lifecycle.RUNTIME)

    implementation(Libs.Androidx.Lifecycle.VIEW_MODEL_KTX)
    implementation(Libs.Androidx.Lifecycle.LIVEDATA_KTX)
    implementation(Libs.Retrofit.GSON)
    implementation(Libs.Retrofit.GSON_CONVERTER)
    implementation(Libs.Retrofit.RETROFIT2)

    implementation(Libs.OkHttp.LOGGING_INTERCEPTOR)

    implementation(Libs.Kotlinx.COROUTINES_ANDROID)

    implementation(Libs.Glide.GLIDE)
    implementation(Libs.Glide.COMPILER)

    implementation(Libs.Hilt.HILT_ANDROID)
    kapt(Libs.Hilt.COMPILER)

    implementation(Libs.Androidx.Navigation.FRAGMENT_KTX)
    implementation(Libs.Androidx.Navigation.LIVEDATA_KTX)
    implementation(Libs.Androidx.Navigation.UI_KTX)

}

kapt {
    correctErrorTypes = true
}