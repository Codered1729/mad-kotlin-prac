# Setup

### SDK / Compiler Version Setting
In `app/build.gradle.kts`:
```kotlin
android {
    compileSdk = 35  // Match installed SDK (34, 35, 36, or 37)

    defaultConfig {
        targetSdk = 35
    }
}
```
Click **Sync Now**.
