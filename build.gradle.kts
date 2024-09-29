// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.composeCompiler) apply false
}

ext {
    set("TAPSELL_APP_ID", TapsellManifestPlaceholders.TAPSELL_APP_ID)
    set("ADMOB_APP_ID", TapsellManifestPlaceholders.ADMOB_APP_ID)
    set("TAPSELL_APP_NAME", TapsellManifestPlaceholders.TAPSELL_APP_NAME)
}

object TapsellManifestPlaceholders {
    const val TAPSELL_APP_NAME = "sample"
    const val TAPSELL_APP_ID = "76798342-99a7-4a5f-bf5a-60a088d5dcfb"
    const val ADMOB_APP_ID = "ca-app-pub-3940256099942544~3347511713"
}