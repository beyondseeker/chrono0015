plugins {
    id("com.android.application")
    // TODO: この extension って逆にわかりづらい気がする。
    kotlin("android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "com.objectfanatics.chrono0015"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        coreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.0.10")

    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${versions.kotlin}")

    testImplementation("junit:junit:4.12")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
}