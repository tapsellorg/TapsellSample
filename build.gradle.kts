// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinJvm) apply false
}

ext {
    set("TAPSELL_APP_ID", TapsellManifestPlaceholders.TAPSELL_APP_ID)
    set("TAPSELL_APP_MARKET", TapsellManifestPlaceholders.TAPSELL_MARKET)
    set("ADMOB_APP_ID", TapsellManifestPlaceholders.ADMOB_APP_ID)
    set("APPLOVIN_APP_ID", TapsellManifestPlaceholders.APPLOVIN_APP_ID)
}

object TapsellManifestPlaceholders {
    const val TAPSELL_APP_ID = "76798342-99a7-4a5f-bf5a-60a088d5dcfb"
    const val TAPSELL_MARKET = "CafeBazaar"
    const val ADMOB_APP_ID = "ca-app-pub-3940256099942544~3347511713"
    const val APPLOVIN_APP_ID = "5WfZLCGTQmDr6Mf7BBEf5blVwrf8VBMJSmwUSq9-1q5bPpCH_OGAWEP2z2lRkmonLgPzG6gbL4DlvUF9frFmt6"
}