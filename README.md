[![Maven Central](https://img.shields.io/maven-central/v/ir.tapsell.mediation/tapsell)](https://search.maven.org/artifact/ir.tapsell.mediation/tapsell)

# Tapsell Mediation

Tapsell Mediation, is a Mediated solution helping businesses increase their mobile apps' revenue with the inclusion of other supported Programmatic & Mediated Ad Solutions.

## ADs UI

| Rewarded Video             | Interstitial Banner    | Native Banner | Standard Banner|
| ----------------- | -------------- | -----------   | -----------     |
| <img width="300" src="https://github.com/tapsellorg/TapsellSample/assets/38072572/728fa523-5822-44d2-93db-e7184e256fa4" />    | <img width="300" src="https://github.com/tapsellorg/TapsellSample/assets/38072572/181fe3e9-9ffd-4c3c-b1c1-3b5dbecf399d" />   | <img width="300" src="https://github.com/tapsellorg/TapsellSample/assets/38072572/1025cfca-f8f6-4528-819d-1d23109363e3" /> | <img width="300" src="https://github.com/tapsellorg/TapsellSample/assets/38072572/84249840-4103-446d-821f-a7c5481b4f00" /> |

## Getting Started

Integrating the Tapsell SDK into your app is the first step toward displaying ads and earning revenue.
Once you've integrated the SDK, you can choose an ad format (such as native or rewarded video) and follow the steps to implement it.

### Before You Begin

To prepare your app, complete the following steps:

- Make sure that your module's app-level `build.gradle` file uses a `compileSdkVersion` of 31 or higher
- Make sure you have set up your app as an Tapsell Mediation app and have your unique Tapsell App ID
  that is needed later in this guide.

### Configure Your App

1. Add the dependencies for the Tapsell Mediation SDK to your module's app-level `build.gradle`:

```groovy
dependencies {
    def tapsellVersion = "1.0.0-beta03"
    implementation "ir.tapsell.mediation:tapsell:$tapsellVersion" // Mediation
    implementation "ir.tapsell.mediation.adapter:legacy:$tapsellVersion" // Tapsell Adapter
}
```

2. Add a manifest placeholder inside your module's app-level `build.gradle` providing your Tapsell App ID collected from your dashboard:

```groovy
android {
    defaultConfig {
        manifestPlaceholders = [
                TapsellMediationAppKey: "YOUR_APP_ID",
        ]
    }
}
```

No additional configuration or code is needed to initialize the SDK.

### Add Mediation Adapters

The Tapsell Mediation SDK currently supports the following 3rd-party programmatic & mediated partner SDKs:

* AdColony
* AdMob
* Applovin
* Chartboost
* Mintegral
* UnityAds

To integrate, add the adapter dependency you need to your module's app-level `build.gradle`:

```groovy
implementation "ir.tapsell.mediation.adapter:adcolony:$tapsellVersion"
implementation "ir.tapsell.mediation.adapter:admob:$tapsellVersion"
implementation "ir.tapsell.mediation.adapter:applovin:$tapsellVersion"
implementation "ir.tapsell.mediation.adapter:chartboost:$tapsellVersion"
implementation "ir.tapsell.mediation.adapter:mintegral:$tapsellVersion"
implementation "ir.tapsell.mediation.adapter:unityads:$tapsellVersion"
```

#### Additional Configuration

- AdColony

No additional configuration needed.

- Admob

Add a manifest placeholder inside your module's app-level `build.gradle` providing your Admob app signature.
(Contact Tapsell support for more information):

```groovy
android {
    defaultConfig {
        manifestPlaceholders = [
                TapsellMediationAdmobAdapterSignature: "YOUR_APP_SIGNATURE",
        ]
    }
}
```

- Applovin

Add a manifest placeholder inside your module's app-level `build.gradle` providing your Applovin app signature.
(Contact Tapsell support for more information):

```groovy
android {
    defaultConfig {
        manifestPlaceholders = [
                TapsellMediationApplovinAdapterSignature: "YOUR_APP_SIGNATURE",
        ]
    }
}
```

- Chartboost

In your project-level `build.gradle` file, include Chartboost Maven repository:

```groovy
allprojects {
    repositories {
        maven { url "https://cboost.jfrog.io/artifactory/chartboost-mediation" }
    }
}
```

- Mintegral

In your project-level `build.gradle` file, include Mintegral Maven repository:

```groovy
allprojects {
    repositories {
      maven { url 'https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea' }
    }
}
```

- UnityAds

No additional configuration needed.


### Set Initialization Listener

You can set a listener to be notified of the SDK's initialization. The `onInitializationComplete` will
be called once all the mediation adapters are initialized.

```java
import ir.tapsell.mediation.Tapsell;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tapsell.setInitializationListener(() -> {
            // initialization Completed
        });
    }
}
```

<br/>

## Implementing Ad Formats
---

The Tapsell SDK is now imported and you're ready to implement an ad. Tapsell offers a number of
different ad formats, so you can choose the one that best fits your app's user experience.

Make sure you have created the ad placements (zones) in your app's dashboard and have the unique id
for each zone needed later in this guide.

### Banner

Rectangular ads that appear on the device screen usually at the top or bottom.
Banner ads stay on screen while users are interacting with the app, and can refresh automatically
after a certain period of time. If you're new to mobile advertising, they're a great place to start.

This guide shows you how to integrate banner ads from Tapsell into your Android app.

#### Add Tapsell Banner Ad Container To Your Layout

The first step toward displaying a banner is to place a `BannerContainer` in the layout of
the Activity or Fragment in which you'd like to display it. The easiest way to do this is to add
one to the corresponding XML layout file. Here's an example that shows an activity's `BannerContainer`:

```xml
<!-- main_activity.xml-->
<!--...-->
    <ir.tapsell.mediation.ad.views.banner.BannerContainer
      android:id="@+id/bannerContainerView"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:layout_centerHorizontal="true"
      android:layout_alignParentBottom="true">
    </ir.tapsell.mediation.ad.views.banner.BannerContainer>
<!--...-->
```

You can alternatively create a `BannerContainer` programmatically:

```java
import ir.tapsell.mediation.Tapsell;
import ir.tapsell.mediation.ad.views.banner.BannerContainer;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BannerContainer container = new BannerContainer(this);
        // TODO: Add adView to your view hierarchy.
    }
}
```

#### Load A Banner Ad

Once the `BannerContainer` is in place, the next step is to load an ad.
That's done with the `requestBannerAd()` static method in Tapsell class.

```java
public static void requestBannerAd(String zoneId, BannerSize bannerSize, RequestResultListener listener)
```

BannerSize is an optional enum parameter determining the size of the shown ad, with the following values:

```java
enum BannerSize {
    BANNER_320_50, // Default value if the parameter is not provided
    BANNER_320_90,
    BANNER_320_100,
    BANNER_250_250,
    BANNER_300_250,
    BANNER_468_60,
    BANNER_728_90,
    BANNER_160_600
}
```

You need to provide a class implementing the `RequestResultListener` interface to get the ad load result overriding the success and failure methods:

```java
interface RequestResultListener {
    // Called when the ad is successfully loaded; providing the ad id needed to show the ad 
    void onSuccess(String adId);
    // Called when there is no ad available
    void onFailure();
}
```

> **_NOTE:_**  
> If you intent to load banner ads from `UnityAds` ad-network, you also need to pass an activity
> instance using the method below:
> ```java
> public static void requestBannerAd(String zoneId, BannerSize bannerSize, Activity activity, RequestResultListener listener)
> ```

Here's an example that shows how to load an ad in the onCreate() method of an Activity:

```java
import ir.tapsell.mediation.ad.request.BannerSize;
import ir.tapsell.mediation.ad.request.RequestResultListener;
import ir.tapsell.mediation.ad.views.banner.BannerContainer;
import ir.tapsell.mediation.Tapsell;

public class MainActivity extends AppCompatActivity {
    private BannerContainer mBannerContainer;
    private static final String BANNER_AD_ZONE_ID = "SampleZoneId";
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBannerContainer = findViewById(R.id.bannerContainer);
        Tapsell.requestBannerAd(BANNER_AD_ZONE_ID, BannerSize.BANNER_320_90, new RequestResultListener() {
            @Override
            public void onSuccess(@NonNull String adId) {
                // Ad loaded
                // TODO: Show the ad
            }

            @Override
            public void onFailure() {
                // Ad not available
            }
        });
    }
}
```

#### Show The Loaded Banner Ad

Once the banner ad is successfully loaded, the next step is to show the ad.
That's done with the `showBannerAd()` static method in Tapsell class passing
the `adId` received in `onSuccess` method of the `RequestResultListener` and
the `BannerContainer` view added to your layout in which you intend to show the ad.

```java
public static void showBannerAd(String adId, BannerContainer container, Activity activity, AdStateListener.Banner listener)
```

The `AdStateListener.Banner` optional parameter can be passed to monitor and handle events
related to displaying your banner ad. The interface has the following implementation:

```java
AdStateListener.Banner listener = new AdStateListener.Banner() {
    @Override
    public void onAdImpression() {
        // Code to be executed when an impression is recorded for the ad.
    }
    
    @Override
    public void onAdClicked() {
        // Code to be executed when the user clicks on the ad.
    }

    @Override
    public void onAdFailed(String message) {
        // Code to be executed when the ad show fails.
    }
);
```

#### Destroy Banner Ad

When you are done showing your banner ad, you should destroy it so that the ad is properly garbage collected.
The example below shows the destroy call in the onDestroy() method of an activity:

```java
import ir.tapsell.mediation.Tapsell;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onDestroy() {
        Tapsell.destroyBannerAd(adId);
        super.onDestroy();
    }
}
```

### Interstitial

Interstitial ads are full-screen ads that cover the interface of their host app.
They're typically displayed at natural transition points in the flow of an app, such as between
activities or during the pause between levels in a game. When an app shows an interstitial ad,
the user has the choice to either tap on the ad and continue to its destination or close it and
return to the app.

This guide shows you how to integrate interstitial ads from Tapsell into your Android app.

#### Load An Interstitial Ad

To load an interstitial ad, call the `requestInterstitialAd` static method of Tapsell class
passing in the zone identifier and a `RequestResultListener` to receive the loaded ad id
or possible failure notice.

```java
public static void requestInterstitialAd(String zoneId, RequestResultListener listener)
```

The `RequestResultListener` interface has the following implementation:

```java
interface RequestResultListener {
    // Called when the ad is successfully loaded; providing the ad id needed to show the ad 
    void onSuccess(String adId);
    // Called when there is no ad available
    void onFailure();
}
```

> **_NOTE:_**  
> If you intent to load interstitial ads from `Applovin` ad-network, you also need to pass an activity
> instance using the method below:
> ```java
> public static void requestInterstitialAd(String zoneId, Activity activity, RequestResultListener listener)
> ```

Here's an example that shows how to load an ad in the onCreate() method of an Activity:

```java
import ir.tapsell.mediation.ad.request.RequestResultListener;
import ir.tapsell.mediation.Tapsell;

public class MainActivity extends AppCompatActivity {
    private static final String INTERSTITIAL_AD_ZONE_ID = "SampleZoneId";
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tapsell.requestInterstitialAd(INTERSTITIAL_AD_ZONE_ID, new RequestResultListener() {
            @Override
            public void onSuccess(@NonNull String adId) {
                // Ad loaded
                // TODO: Save the loaded ad id to be shown when the time is right
            }

            @Override
            public void onFailure() {
                // Ad not available
            }
        });
    }
}
```

#### Show The Loaded Interstitial Ad

Once the interstitial ad is successfully loaded, the next step is to show the ad.
Interstitial ads should be displayed during natural pauses in the flow of an app. Between levels of a game is a good example, or after the user completes a task.
To do so simply call the `showInterstitialAd()` static method in Tapsell class
passing the `adId` received in `onSuccess` method of the `RequestResultListener`.

```java
public static void showInterstitialAd(String adId, Activity activity, AdStateListener.Interstitial listener)
```

The `AdStateListener.Interstitial` optional parameter can be passed to monitor and handle events
related to displaying your interstitial ad. The interface has the following implementation:

```java
AdStateListener.Interstitial listener = new AdStateListener.Interstitial() {
    @Override
    public void onAdImpression() {
        // Code to be executed when an impression is recorded for the ad.
    }

    @Override
    public void onAdClicked() {
        // Code to be executed when the user clicks on the ad.
    }

    @Override
    public void onAdClosed(AdShowCompletionState completionState) {
        // Code to be executed when the full-screen ad is clicked by the user.
    }
    
    @Override
    public void onAdFailed(String message) {
        // Code to be executed when the ad show fails.
    }
);
```

The `AdShowCompletionState` passed in `onAdClosed` callback, indicates whether the ad has been shown completely
or skipped by the user before completion.

```java
enum AdShowCompletionState {
    COMPLETED,
    SKIPPED,
    UNKNOWN
}
```

### Rewarded

Rewarded ads are full-screen ads that reward users for watching short videos and interacting with
playable ads and surveys. They are used for monetizing free-to-play apps.

This guide shows you how to integrate rewarded ads from Tapsell into your Android app.

#### Load A Rewarded Ad

Rewarded ads are loaded by calling the `requestRewardedVideoAd` static method of the Tapsell class;
passing in the zone identifier and a `RequestResultListener` to receive the loaded ad id
or possible failure notice.
This is usually done in the onCreate() method of an Activity.

```java
public static void requestRewardedVideoAd(String zoneId, RequestResultListener listener)
```

The `RequestResultListener` interface has the following implementation:

```java
interface RequestResultListener {
    // Called when the ad is successfully loaded; providing the ad id needed to show the ad 
    void onSuccess(String adId);
    // Called when there is no ad available
    void onFailure();
}
```

> **_NOTE:_**  
> If you intent to load rewarded ads from `Applovin` ad-network, you also need to pass an activity
> instance using the method below:
> ```java
> public static void requestRewardedVideoAd(String zoneId, Activity activity, RequestResultListener listener)
> ```

Here's an example that shows how to load an ad in the onCreate() method of an Activity:

```java
import ir.tapsell.mediation.ad.request.RequestResultListener;
import ir.tapsell.mediation.Tapsell;

public class MainActivity extends AppCompatActivity {
    private static final String REWARDED_AD_ZONE_ID = "SampleZoneId";
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tapsell.requestRewardedAd(REWARDED_AD_ZONE_ID, new RequestResultListener() {
            @Override
            public void onSuccess(@NonNull String adId) {
                // Ad loaded
                // TODO: Save the loaded ad id to be shown when the time is right
            }

            @Override
            public void onFailure() {
                // Ad not available
            }
        });
    }
}
```

#### Show The Loaded Rewarded Ad

Once the rewarded ad is successfully loaded, the next step is to show the ad.
To do so simply call the `showRewardedVideoAd()` static method in Tapsell class
passing the `adId` received in `onSuccess` method of the `RequestResultListener`.

```java
public static void showRewardedVideoAd(String adId, Activity activity, AdStateListener.Rewarded listener)
```

The `AdStateListener.Rewarded` optional parameter can be passed to monitor and handle events
related to displaying your rewarded ad; specially when the user should be rewarded.
The interface has the following implementation:

```java
AdStateListener.Rewarded listener = new AdStateListener.Rewarded() {
    @Override
    public void onAdImpression() {
        // Code to be executed when an impression is recorded for the ad.
    }
        
    @Override
    public void onAdClicked() {
        // Code to be executed when the user clicks on the ad.
    }

    @Override
    public void onAdClosed(AdShowCompletionState completionState) {
        // Code to be executed when the full-screen ad is clicked by the user.
    }
    
    @Override
    public void onRewarded() {
        // Code to be executed when the user has earned the reward.
    }
    
    @Override
    public void onAdFailed(String message) {
        // Code to be executed when the ad show fails.
    }
);
```

The `AdShowCompletionState` passed in `onAdClosed` callback, indicates whether the ad has been shown completely
or skipped by the user before completion.

```java
enum AdShowCompletionState {
    COMPLETED,
    SKIPPED,
    UNKNOWN
}
```

### Native

Native ads are ad assets that are presented to users through UI components that are native to the platform.
They are shown using the same types of views with which you are already building your layouts,
and can be formatted to match your app's visual design.

This guide shows you how to integrate native ads from Tapsell into your Android app.

#### Add Tapsell Native Views To Your Layout

The first step toward displaying a native ad is to create your ad layout using the same views you use in your application. Note that the design and format of the ad layout is completely in your own hands to match your app's design. The only thing you need to consider in your
layout design is that you must put all your ad layout views inside a `NativeAdViewContainer`, provided by Tapsell SDK:

- ir.tapsell.mediation.ad.views.ntv.**NativeAdViewContainer**

  A custom Android `FrameLayout` that must be used as the parent view of the native ad item views. All your ad views providing the content of the ad,
  like title view, logo view and so on, must be placed inside a `NativeAdViewContainer` view.

Here's an example that shows an ad layout inside the activity layout:

```xml
<!----------------------- activity_main.xml -------------------------->

        ... 

<!-- container -->
<ir.tapsell.mediation.ad.views.ntv.NativeAdViewContainer
    android:id="@+id/tapsell_native_ad_container"
    ... >

    <!-- ad layout (a layout of your choice) -->
    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <!-- logo view -->
        <ImageView
            android:id="@+id/tapsell_native_ad_logo"
            ... />
        
        <!-- title view -->  
        <TextView
            android:id="@+id/tapsell_native_ad_title"
            ... />

        <!-- description view -->
        <TextView
            android:id="@+id/tapsell_native_ad_description"
            ... />

        <!-- sponsored text view -->
        <TextView
            android:id="@+id/tapsell_native_ad_sponsored"
            ... />

        <!-- CTA button view -->
        <Button
            android:id="@+id/tapsell_native_ad_cta"
            ... />
        
        <!-- media view -->
        <FrameLayout
            android:id="@+id/tapsell_native_ad_media"
            ... />
      
    </RelativeLayout>

</ir.tapsell.mediation.ad.views.ntv.NativeAdViewContainer>
```

As an alternative to adding the ad layout directly to the activity layout, you can only place the `NativeAdViewContainer` and have your ad layout in a separate layout file, attaching it programmatically. See the sample below:

```xml
<!----------------------- activity_main.xml -------------------------->

        ... 

<!-- container -->
<ir.tapsell.mediation.ad.views.ntv.NativeAdViewContainer
    android:id="@+id/tapsell_native_ad_container"
    ... />

<!----------------------- native_ad.xml -------------------------->

<!-- ad layout (a layout of your choice) -->
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">

<!--  ad content views  -->

</RelativeLayout>
```

```java
import ir.tapsell.mediation.Tapsell;
import ir.tapsell.mediation.ad.views.ntv.NativeAdViewContainer;

public class MainActivity extends AppCompatActivity {
    private NativeAdViewContainer mNativeAdViewContainer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNativeAdViewContainer = findViewById(R.id.tapsell_native_ad_container);
        getLayoutInflater().inflate(R.layout.native_ad, mNativeAdViewContainer, true);
    }
}
```

#### Load A Native Ad

Once the layout is ready, the next step is to load an ad.
That's done with the `requestNativeAd()` static method in Tapsell class.

```java
public static void requestNativeAd(String zoneId, RequestResultListener listener)
```

You need to provide a class implementing the `RequestResultListener` interface to get the ad load result overriding the success and failure methods:

```java
interface RequestResultListener {
    // Called when the ad is successfully loaded; providing the ad id needed to show the ad 
    void onSuccess(String adId);
    // Called when there is no ad available
    void onFailure();
}
```

Here's an example that shows how to load an ad in the onCreate() method of an Activity:

```java
import ir.tapsell.mediation.ad.request.RequestResultListener;
import ir.tapsell.mediation.Tapsell;

public class MainActivity extends AppCompatActivity {
    private BannerContainer mBannerContainer;
    private static final String NATIVE_AD_ZONE_ID = "SampleZoneId";
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tapsell.requestNativeAd(NATIVE_AD_ZONE_ID, new RequestResultListener() {
            @Override
            public void onSuccess(@NonNull String adId) {
                // Ad loaded
                // TODO: Show the ad
            }

            @Override
            public void onFailure() {
                // Ad not available
            }
        });
    }
}
```

#### Show The Loaded Native Ad

Once the native ad is successfully loaded, the next step is to show the ad.
That's done with the `showNativeAd()` static method in Tapsell class
passing the `adId` received in `onSuccess` method of the `RequestResultListener` and an instance
of `NativeAdView` populated with the ad views you used in your layout.

```java
public static void showNativeAd(String adId, NativeAdView view, Activity activity, AdStateListener.Native listener)
```

The `NativeAdView` is a class you need to instantiate and populate with your ad views using the `Builder` pattern.
Review the sample below for more details:

```java
NativeAdView.Builder(YOUR_CONTAINER_VIEW) // NativeAdViewContainer
    .withLogo(YOUR_LOGO_VIEW) // ImageView
    .withTitle(YOUR_TITLE_VIEW) // TextView
    .withSponsored(YOUR_SPONSORED_TEXT_VIEW) // TextView
    .withDescription(YOUR_DESCRIPTION_VIEW) // TextView
    .withCtaButton(YOUR_CTA_VIEW) // Button
    .withMedia(YOUR_MEDIA_VIEW) // FrameLayout
    .build()
```

Note that depending on your ad design you can only include and provide a subset of the possible ad items.

The `AdStateListener.Native` optional parameter can be passed to monitor and handle events
related to displaying your native ad.
The interface has the following implementation:

```java
AdStateListener.Native listener = new AdStateListener.Native() {
    @Override
    public void onAdImpression() {
        // Code to be executed when an impression is recorded for the ad.
    }
    
    @Override
    public void onAdClicked() {
        // Code to be executed when the user clicks on the ad.
    }

    @Override
    public void onAdFailed(String message) {
        // Code to be executed when the ad show fails.
    }
);
```

#### Destroy Native Ad

When you are done showing your native ad, you should destroy it so that the ad is properly garbage collected.
The example below shows the destroy call in the onDestroy() method of an activity:

```java
import ir.tapsell.mediation.Tapsell;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onDestroy() {
        Tapsell.destroyNativeAd(adId);
        super.onDestroy();
    }
}
```
