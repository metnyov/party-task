plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.android.extensions")
    id("org.jetbrains.kotlin.kapt")
}

kapt {
    useBuildCache = true
}

androidExtensions {
    isExperimental = true
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    flavorDimensions("default")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        val options = this as? org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options?.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    defaultConfig {
        applicationId = AndroidConfig.ID
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets {
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${LibraryVersion.KOTLIN}")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersion.COROUTINES_ANDROID}")

    // AndroidX
    implementation("androidx.appcompat:appcompat:${LibraryVersion.APP_COMPACT}")
    implementation("androidx.core:core-ktx:${LibraryVersion.CORE_KTX}")
    implementation("androidx.fragment:fragment-ktx:${LibraryVersion.FRAGMENT_KTX}")

    // Widgets
    implementation("androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT}")
    implementation("androidx.recyclerview:recyclerview:${LibraryVersion.RECYCLER_VIEW}")

    // UI
    implementation("com.google.android.material:material:${LibraryVersion.MATERIAL}")

    // MVP Moxy
    implementation("com.github.moxy-community:moxy:${LibraryVersion.MOXY}")
    implementation("com.github.moxy-community:moxy-androidx:${LibraryVersion.MOXY}")
    implementation("com.github.moxy-community:moxy-material:${LibraryVersion.MOXY}")
    implementation("com.github.moxy-community:moxy-ktx:${LibraryVersion.MOXY}")
    kapt("com.github.moxy-community:moxy-compiler:${LibraryVersion.MOXY}")

    // Cicerone
    implementation("ru.terrakok.cicerone:cicerone:${LibraryVersion.CICERONE}")

    // Glide
    implementation("com.github.bumptech.glide:glide:${LibraryVersion.GLIDE}")
    implementation("com.github.bumptech.glide:okhttp3-integration:${LibraryVersion.GLIDE}")
    kapt("com.github.bumptech.glide:compiler:${LibraryVersion.GLIDE}")

    // Moshi
    implementation("com.squareup.moshi:moshi:${LibraryVersion.MOSHI}")
    implementation("com.squareup.moshi:moshi-kotlin:${LibraryVersion.MOSHI}")
    implementation("com.squareup.moshi:moshi-adapters:${LibraryVersion.MOSHI}")

    // Kodein
    implementation("org.kodein.di:kodein-di:${LibraryVersion.KODEIN}")
    implementation("org.kodein.di:kodein-di-framework-android-x:${LibraryVersion.KODEIN}")
}