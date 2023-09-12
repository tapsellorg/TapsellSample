pluginManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
        maven("https://cboost.jfrog.io/artifactory/chartboost-mediation")
        maven("https://maven.wortise.com/artifactory/public")
        maven("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        maven("https://android-sdk.is.com")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://cboost.jfrog.io/artifactory/chartboost-mediation")
        maven("https://maven.wortise.com/artifactory/public")
        maven("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        maven("https://android-sdk.is.com")
    }
}

rootProject.name = "TapsellSample"
include(":sample-kotlin")
include(":sample-java")
include(":sample-jetpack-compose")
