import Libs.Androidx.implementAppLibraries

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    hilt {
        enableAggregatingTask = true
    }
}

dependencies {

    implementAppLibraries()
    implementation(Libs.Androidx.Lifecycle.RUNTIME)

    implementation (Libs.Androidx.ACTIVITY_KTX)
    implementation (Libs.Androidx.LEGACY_SUPPORT)
    implementation (Libs.Androidx.FRAGMENT_KTX)
    implementation(Libs.Androidx.Lifecycle.VIEW_MODEL_KTX)
    implementation(Libs.Androidx.Lifecycle.LIVEDATA_KTX)

    implementation(Libs.Retrofit.GSON)
    implementation(Libs.Retrofit.GSON_CONVERTER)
    implementation(Libs.Retrofit.RETROFIT2)

    implementation(Libs.OkHttp.OKHTTP3)
    implementation(Libs.OkHttp.LOGGING_INTERCEPTOR)

    implementation(Libs.Kotlinx.COROUTINES_ANDROID)

    implementation(Libs.Glide.GLIDE)
    implementation(Libs.Glide.COMPILER)

    implementation ("com.google.dagger:hilt-android:2.41")
    kapt ("com.google.dagger:hilt-compiler:2.41")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0")
    implementation(Libs.Androidx.Navigation.FRAGMENT_KTX)
    implementation(Libs.Androidx.Navigation.RUNTIME_KTX)
    implementation(Libs.Androidx.Navigation.UI_KTX)

    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.LIFECYCLE}")
//    implementation ("androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE}")

}

kapt {
    correctErrorTypes = true
}