plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.chillrate"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.chillrate"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    packaging {
        jniLibs.pickFirsts.apply {
            add("lib/x86/libc++_shared.so")
            add("lib/x86_64/libc++_shared.so")
            add("lib/armeabi-v7a/libc++_shared.so")
            add("lib/arm64-v8a/libc++_shared.so")
            add("lib/arm64-v8a/libc++_shared.so")

            add("lib/x86/libfilters.so")
            add("lib/x86_64/libfilters.so")
            add("lib/armeabi-v7a/libfilters.so")
            add("lib/arm64-v8a/libfilters.so")
        }
    }
}

dependencies {
    implementation("com.github.BrainbitLLC:neurosdk2:1.0.6.17")
    implementation("com.github.BrainbitLLC:Emotional-state-artifacts:1.0.1")
    implementation("com.github.BrainbitLLC:SpectrumLib:1.0.0")
    implementation("com.github.BrainbitLLC:SignalFilters:1.0")
    implementation("com.github.BrainbitLLC:CallibriECG:1.0.0")

    implementation(libs.androidx.appcompat.v161)

    implementation(project(":core:ui"))
    implementation(project(":core:foundation"))
    implementation(project(":core:navigation"))
    implementation(project(":core:remote"))

    implementation(project(":features:main"))
    implementation(project(":features:auth"))
    implementation(project(":features:splash"))

    implementation(libs.bundles.koin)
    implementation(libs.androidx.datastore)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.ktor)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}