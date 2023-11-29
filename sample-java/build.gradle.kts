plugins {
    alias(libs.plugins.androidApplication)
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

        buildConfigField(
            "String",
            "TAPSELL_REWARDED_VIDEO",
            "\"1d710cc7-5e96-46ac-a3e9-8463300333e6\""
        )
        buildConfigField(
            "String",
            "TAPSELL_INTERSTITIAL",
            "\"b3972749-f62a-475a-9ff2-cfc9e2a40f87\""
        )
        buildConfigField(
            "String",
            "TAPSELL_NATIVE_BANNER",
            "\"d217e3e6-0070-4120-925d-5d39d0298893\""
        )
        buildConfigField(
            "String",
            "TAPSELL_STANDARD_BANNER",
            "\"e3d5999c-5990-4e31-8ce9-642ce040a7f4\""
        )

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
    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

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
}
