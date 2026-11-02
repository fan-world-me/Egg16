---
[![Telegram](https://img.shields.io/badge/Telegram-@fan__world__me-2CA5E0?style=flat-square&logo=telegram)](https://t.me/fan_world_me)   [![Discord](https://img.shields.io/badge/Discord-fan__world__me-5865F2?style=flat-square&logo=discord)](https://discord.com/users/1040301536036786248)   [![GitHub](https://img.shields.io/badge/GitHub-fan--world--me-181717?style=flat-square&logo=github)](https://github.com/fan-world-me)   [![Portfolio](https://img.shields.io/badge/Portfolio-fan--world--me.github.io-00e5ff?style=flat-square&logo=githubpages&logoColor=white)](https://fan-world-me.github.io/)

```
███████╗ ██████╗  ██████╗     ██╗ ██████╗
██╔════╝██╔════╝ ██╔════╝    ███║██╔════╝
█████╗  ██║  ███╗██║  ███╗   ╚██║███████╗
██╔══╝  ██║   ██║██║   ██║    ██║██╔══██║
███████╗╚██████╔╝╚██████╔╝    ██║╚██████╔╝
╚══════╝ ╚═════╝  ╚═════╝     ╚═╝ ╚═════╝
  Egg 16 — one-tap launcher for the Android 16 Easter Egg
```

A minimal Android launcher app (API 21+) that instantly opens the hidden **Android 16 Easter Egg** (`com.android.egg / landroid.MainActivity`) and immediately closes itself — no UI, no splash, no trace in recents.

[![Android](https://img.shields.io/badge/Android-5.0%2B-3DDC84?style=flat-square&logo=android&logoColor=white)](https://www.android.com/) [![Kotlin](https://img.shields.io/badge/Kotlin-2.0.0-7F52FF?style=flat-square&logo=kotlin&logoColor=white)](https://kotlinlang.org/) [![Gradle](https://img.shields.io/badge/Gradle-9.x-02303A?style=flat-square&logo=gradle&logoColor=white)](https://gradle.org/) [![License: GPL-3.0](https://img.shields.io/badge/License-GPL--3.0-blue?style=flat-square)](LICENSE)

> This app requires the `com.android.egg` package to be present on your device. It is included in stock Android 16 builds. Results may vary on custom ROMs or older Android versions.

## What does it do?

- Taps the **Egg 16** icon in your launcher.
- Immediately fires an explicit `Intent` targeting `com.android.egg / com.android.egg.landroid.MainActivity`.
- Calls `finish()` — the launcher app closes itself instantly.
- The Easter Egg game opens as if launched natively.
- The app is excluded from the recents screen (`android:excludeFromRecents="true"`).

## Download

Get the latest APK from **[GitHub Releases](../../releases)**.

## Requirements

- Android 5.0+ (API 21)
- Stock Android 16 (or any ROM that ships `com.android.egg` with `landroid.MainActivity`)

## Build from source

### Requirements

- JDK 17+
- Android SDK Platform 34
- Gradle 8+ (or use the system-installed Gradle)

### Build a release APK

Windows:
```bat
gradle assembleRelease
```

Linux / macOS:
```bash
./gradlew assembleRelease
```

Output:
```
app/build/outputs/apk/release/app-release.apk
```

### Signing

Set these environment variables before building to sign with your own key:

```
KEYSTORE_PATH     — path to your .jks file
KEYSTORE_PASSWORD
KEY_ALIAS
KEY_PASSWORD
```

Do not commit keystores or passwords to the repository.

## Repository layout

```text
.
├── app/
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── kotlin/com/example/egglauncher/
│       │   └── MainActivity.kt        # fires the intent and finishes
│       └── res/
│           ├── drawable/              # Easter Egg vector drawables
│           ├── drawable-v26/          # adaptive icon (API 26+)
│           └── values/
│               ├── strings.xml
│               └── colors.xml
├── build.gradle
├── app/build.gradle
├── settings.gradle
└── local.properties                   # not committed (SDK path)
```

## How it works

```kotlin
val intent = Intent().apply {
    component = ComponentName(
        "com.android.egg",
        "com.android.egg.landroid.MainActivity"
    )
    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
}
startActivity(intent)
finish()
```

That's the entire app logic. No permissions, no services, no background work.

## Disclaimer

This project is provided **as is**, without warranty. It is an independent community project, not affiliated with Google or AOSP. The Easter Egg activity is an undocumented system component and may change or be removed in future Android versions.

## License

[GNU General Public License v3.0](LICENSE).

---

Made with 🩵 in Ukraine 🇺🇦

[![Telegram](https://img.shields.io/badge/Telegram-@fan__world__me-2CA5E0?style=flat-square&logo=telegram)](https://t.me/fan_world_me)   [![Discord](https://img.shields.io/badge/Discord-fan__world__me-5865F2?style=flat-square&logo=discord)](https://discord.com/users/1040301536036786248)   [![Portfolio](https://img.shields.io/badge/Portfolio-fan--world--me.github.io-00e5ff?style=flat-square&logo=githubpages&logoColor=white)](https://fan-world-me.github.io/)
