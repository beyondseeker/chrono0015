plugins {
    id(Plugins.com_android_application)
    id(Plugins.org_jetbrains_kotlin_android)
    id(Plugins.kotlin_android_extensions)
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
//    // TODO: マルチモジュールの時にやりたいなというネタのメモ
//    implementation(Project__kotlin)

    coreLibraryDesugaring(Deps.com_android_tools__desugar_jdk_libs)

    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(Deps.androidx_appcompat__appcompat)
    implementation(Deps.androidx_constraintlayout__constraintlayout)
    implementation(Deps.org_jetbrains_kotlin__kotlin_stdlib_jdk8)

    testImplementation(Deps.junit__junit)

    androidTestImplementation(Deps.androidx_test_espresso__espresso_core)
    androidTestImplementation(Deps.androidx_test_ext__junit)
}