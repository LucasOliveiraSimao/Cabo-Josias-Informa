import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kapt)
    alias(libs.plugins.googleGmsGoogleServices)
    alias(libs.plugins.googleFirebaseCrashlytics)
}

val keystorePropertiesFile = rootProject.file("app/keystore.properties")
val keystoreProperties = Properties()
keystoreProperties.load(FileInputStream(keystorePropertiesFile))

android {
    namespace = "com.lucassimao.cabojosiasinforma"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lucassimao.cabojosiasinforma"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            keyAlias = keystoreProperties["keyAlias"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
            storeFile = file(keystoreProperties["storeFile"] as String)
            storePassword = keystoreProperties["storePassword"] as String
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            initWith(getByName("release"))
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
        create("beta") {
            initWith(getByName("release"))
            isMinifyEnabled = false
            applicationIdSuffix = ".beta"
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.viewModel)
    implementation(libs.liveData)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.database)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.messaging)

    implementation(libs.picasso)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}