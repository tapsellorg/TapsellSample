pluginManagement {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven("https://android-sdk.is.com")
        maven("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        maven("https://cboost.jfrog.io/artifactory/chartboost-mediation")
        maven("https://maven.wortise.com/artifactory/public")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven("https://android-sdk.is.com")
        maven("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        maven("https://cboost.jfrog.io/artifactory/chartboost-mediation")
        maven("https://maven.wortise.com/artifactory/public")

    }
}

rootProject.name = "TapsellSample"
include(":sample-kotlin")
include(":sample-java")
include(":sample-jetpack-compose")
include(":shared")
