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

-dontwarn com.google.ads.interactivemedia.v3.api.Ad
-dontwarn com.google.ads.interactivemedia.v3.api.AdDisplayContainer
-dontwarn com.google.ads.interactivemedia.v3.api.AdError
-dontwarn com.google.ads.interactivemedia.v3.api.AdErrorEvent$AdErrorListener
-dontwarn com.google.ads.interactivemedia.v3.api.AdErrorEvent
-dontwarn com.google.ads.interactivemedia.v3.api.AdEvent$AdEventListener
-dontwarn com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType
-dontwarn com.google.ads.interactivemedia.v3.api.AdEvent
-dontwarn com.google.ads.interactivemedia.v3.api.AdsLoader$AdsLoadedListener
-dontwarn com.google.ads.interactivemedia.v3.api.AdsLoader
-dontwarn com.google.ads.interactivemedia.v3.api.AdsManager
-dontwarn com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent
-dontwarn com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
-dontwarn com.google.ads.interactivemedia.v3.api.AdsRequest
-dontwarn com.google.ads.interactivemedia.v3.api.CompanionAdSlot
-dontwarn com.google.ads.interactivemedia.v3.api.ImaSdkFactory
-dontwarn com.google.ads.interactivemedia.v3.api.ImaSdkSettings
-dontwarn com.google.ads.interactivemedia.v3.api.player.AdMediaInfo
-dontwarn com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider
-dontwarn com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer$VideoAdPlayerCallback
-dontwarn com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
-dontwarn com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate
-dontwarn com.google.android.exoplayer2.ExoPlayerLibraryInfo
-dontwarn com.google.android.exoplayer2.Player$Listener
-dontwarn com.google.android.exoplayer2.Player
-dontwarn com.google.android.exoplayer2.Timeline$Period
-dontwarn com.google.android.exoplayer2.Timeline$Window
-dontwarn com.google.android.exoplayer2.Timeline
-dontwarn com.google.android.exoplayer2.Tracks
-dontwarn com.google.android.exoplayer2.source.ads.AdPlaybackState$AdGroup
-dontwarn com.google.android.exoplayer2.source.ads.AdPlaybackState
-dontwarn com.google.android.exoplayer2.source.ads.AdsLoader$EventListener
-dontwarn com.google.android.exoplayer2.source.ads.AdsLoader
-dontwarn com.google.android.exoplayer2.source.ads.AdsMediaSource$AdLoadException
-dontwarn com.google.android.exoplayer2.ui.StyledPlayerView
-dontwarn com.google.android.exoplayer2.util.Assertions
-dontwarn com.google.android.exoplayer2.util.Log
-dontwarn com.google.android.exoplayer2.util.Util
-dontwarn com.google.common.collect.BiMap
-dontwarn com.google.common.collect.ImmutableList
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