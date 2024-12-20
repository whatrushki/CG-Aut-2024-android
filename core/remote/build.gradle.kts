plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.chillrate.remote"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    packaging {
        jniLibs.pickFirsts.apply {
            add("lib/x86/libc++_shared.so")
            add("lib/x86_64/libc++_shared.so")
            add("lib/armeabi-v7a/libc++_shared.so")
            add("lib/arm64-v8a/libc++_shared.so")

            add("lib/x86/libfilters.so")
            add("lib/x86_64/libfilters.so")
            add("lib/armeabi-v7a/libfilters.so")
            add("lib/arm64-v8a/libfilters.so")
        }
    }
}

dependencies {
    implementation(project(":core:foundation"))

    implementation(libs.brainllc.neurosdk)
    implementation(libs.brainllc.ecg)

    implementation(libs.androidx.datastore)
    implementation(libs.bundles.ktor)
    implementation(libs.koin.core)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}