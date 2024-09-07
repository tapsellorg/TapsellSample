plugins {
    id("com.android.library")
    kotlin("android")

}

android {
    namespace = "ir.tapsell.shared"
    compileSdk = 35
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        jvmToolchain(11)
    }
}
