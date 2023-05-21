plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "ir.tapsell.sample"
    compileSdk = 33

    defaultConfig {
        applicationId = "ir.tapsell.sample"
        minSdk = 19
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        multiDexEnabled = true

        addManifestPlaceholders(
            mapOf(
                "TapsellMediationAppKey" to "76798342-99a7-4a5f-bf5a-60a088d5dcfb",
                "TapsellMediationAdmobAdapterSignature" to "ca-app-pub-3940256099942544~3347511713",
                "TapsellMediationApplovinAdapterSignature" to
                        "5WfZLCGTQmDr6Mf7BBEf5blVwrf8VBMJSmwUSq9-1q5bPpCH_OGAWEP2z2lRkmonLgPzG6gbL4DlvUF9frFmt6",
            )
        )
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
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

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.tapsell)
    implementation(libs.adapter.tapsell)
    implementation(libs.adapter.admob)
    implementation(libs.adapter.unityads)
    implementation(libs.adapter.adcolony)
    // implementation(libs.adapter.mintegral)
    // implementation(libs.adapter.chartboost)
    // implementation(libs.adapter.wortise)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}