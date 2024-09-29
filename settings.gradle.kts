pluginManagement {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.myket.ir")

        // Mintegral ads
        maven("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        // IronSource ads
        maven("https://android-sdk.is.com")

        // Yandex ads
        maven("https://dl.appnext.com")
        maven("https://sdk.tapjoy.com")

        // ChartBoost ads
        maven("https://cboost.jfrog.io/artifactory/chartboost-mediation")
        maven("https://cboost.jfrog.io/artifactory/chartboost-ads")

        // Wortise ads
        maven("https://maven.wortise.com/artifactory/public")
        maven("https://artifact.bytedance.com/repository/pangle")

    }
}

rootProject.name = "TapsellSample"
include(":sample-kotlin")
include(":sample-java")
include(":sample-jetpack-compose")
include(":shared")
