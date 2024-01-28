plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "ir.tapsell.sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "ir.tapsell.sample"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        multiDexEnabled = true

        addManifestPlaceholders(
            mapOf(
                "TapsellMediationAppMarket" to "CafeBazaar",
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

    signingConfigs {
        create("release") {
            if (project.hasProperty("MYAPP_RELEASE_STORE_FILE")) {
                keyAlias = project.property("MYAPP_RELEASE_KEY_ALIAS").toString()
                keyPassword = project.property("MYAPP_RELEASE_KEY_PASSWORD").toString()
                storeFile = file(project.property("MYAPP_RELEASE_STORE_FILE").toString())
                storePassword = project.property("MYAPP_RELEASE_STORE_PASSWORD").toString()
            }
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    splits {
        abi {
            isEnable = true
            isUniversalApk = true
            reset()
            include("x86", "x86_64", "armeabi-v7a", "arm64-v8a")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    lint {
        checkReleaseBuilds = false
        abortOnError = false
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
    implementation(libs.coil)
    implementation(project(":shared"))

    implementation(libs.tapsell)
    implementation(libs.adapter.legacy)
    implementation(libs.adapter.legacy.ima.extension)
    implementation(libs.adapter.admob)
    implementation(libs.adapter.unityads)
    implementation(libs.adapter.adcolony)
    implementation(libs.adapter.applovin)
    implementation(libs.adapter.ironsource)
    implementation(libs.adapter.liftoff)
    implementation(libs.adapter.mintegral)
    // implementation(libs.adapter.chartboost)
    // implementation(libs.adapter.wortise)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    debugImplementation(libs.leakcanary)
}
