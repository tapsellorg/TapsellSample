# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#
#-dontwarn com.google.common.collect.BiMap
#-dontwarn com.google.common.collect.ImmutableList
-dontwarn com.vungle.warren.AdConfig$AdSize
-dontwarn com.vungle.warren.AdConfig
-dontwarn com.vungle.warren.BannerAdConfig
-dontwarn com.vungle.warren.Banners
-dontwarn com.vungle.warren.BaseAdConfig
-dontwarn com.vungle.warren.InitCallback
-dontwarn com.vungle.warren.LoadAdCallback
-dontwarn com.vungle.warren.NativeAd
-dontwarn com.vungle.warren.NativeAdLayout
-dontwarn com.vungle.warren.NativeAdListener
-dontwarn com.vungle.warren.PlayAdCallback
-dontwarn com.vungle.warren.Plugin
-dontwarn com.vungle.warren.Vungle
-dontwarn com.vungle.warren.VungleApiClient$WrapperFramework
-dontwarn com.vungle.warren.VungleBanner
-dontwarn com.vungle.warren.VungleSettings$Builder
-dontwarn com.vungle.warren.VungleSettings
-dontwarn com.vungle.warren.error.VungleException
-dontwarn com.vungle.warren.ui.view.MediaView