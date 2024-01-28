plugins {
//    alias(libs.plugins.androidApplication)
    id("com.android.library")
    kotlin("android")

}

android {
    namespace = "ir.tapsell.shared"
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        jvmToolchain(11)
    }
}
