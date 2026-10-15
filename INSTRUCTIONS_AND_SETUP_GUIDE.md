# Setup & Execution Guide

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

---

### Task 3: Hello World & Activity Lifecycle
1. Create new project -> **Empty Activity** (Jetpack Compose).
2. Match package name in line 1 to your project.
3. Click **Run**.
4. View output: Open **Logcat** window at bottom -> filter: `Lifecycle`.

---

### Task 4-1: Login Module Using Intent
1. Project folder -> right click -> **New** -> **Kotlin Class/File** -> name: `MainActivity2`.
2. Open `app/src/main/AndroidManifest.xml` -> inside `<application> ... </application>`, add:
```xml
<activity android:name=".MainActivity2" android:exported="false" />
```
3. Match package name in line 1 of both files.
4. Click **Run**.
5. Test credentials: Username `admin`, Password `1234`.

---

### Task 4-2: Dice Roller App
1. In `app/src/main/res/drawable/` -> add 6 images:
   `dice1.png`, `dice2.png`, `dice3.png`, `dice4.png`, `dice5.png`, `dice6.png`
2. Match package name in line 1.
3. Click **Run**.

---

### Task 5-1: Dwellings OOP Hierarchy
1. Open `Dwellings.kt`.
2. Click the green **▶** arrow next to `fun main()` on line 9 -> click **Run 'DwellingsKt'**.
3. Output displays in the Run console at the bottom.

---

### Task 5-2: Tip Calculator App
1. Match package name in line 1.
2. Click **Run**.

---

### Task 6-1: Affirmations App
1. In `app/src/main/res/drawable/` -> add 3 images:
   `img1.png`, `img2.png`, `img3.png`
2. Match package name in line 1.
3. Click **Run**.

---

### Task 6-2 & 7-1: Dictionary & Words App
1. Open `app/build.gradle.kts` -> inside `dependencies { ... }`, add:
```kotlin
implementation("androidx.navigation:navigation-compose:2.8.5")
```
2. Click **Sync Now**.
3. Match package name in line 1.
4. Click **Run**.

---

### Task 7-2: ViewModel & LiveData App
1. Open `app/build.gradle.kts` -> inside `dependencies { ... }`, add:
```kotlin
implementation("androidx.compose.runtime:runtime-livedata:1.7.6")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
```
2. Click **Sync Now**.
3. Project folder -> right click -> **New** -> **Kotlin Class/File** -> name: `CounterViewModel`.
4. Match package name in line 1 of both files.
5. Click **Run**.

---

### Task 8: Cupcake Ordering App
1. Match package name in line 1.
2. Click **Run**.

---

### Task 9: Android Trivia App
1. Open `app/build.gradle.kts` -> inside `dependencies { ... }`, add:
```kotlin
implementation("androidx.navigation:navigation-compose:2.8.5")
```
2. Click **Sync Now**.
3. Match package name in line 1.
4. Click **Run**.

---

### Task 11: Guess the Word App
1. Match package name in line 1.
2. Click **Run**.

---

### Task 12: Room SQLite Database App
1. Open `gradle/libs.versions.toml`:
   - Under `[versions]`:
     ```toml
     room = "2.8.5"
     ksp = "2.2.10-2.0.2"
     ```
   - Under `[libraries]`:
     ```toml
     androidx-room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "room" }
     androidx-room-ktx = { group = "androidx.room", name = "room-ktx", version.ref = "room" }
     androidx-room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "room" }
     ```
   - Under `[plugins]`:
     ```toml
     ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
     ```

2. Open `app/build.gradle.kts`:
   - Inside `plugins { ... }`:
     ```kotlin
     alias(libs.plugins.ksp)
     ```
   - Inside `dependencies { ... }`:
     ```kotlin
     implementation(libs.androidx.room.runtime)
     implementation(libs.androidx.room.ktx)
     ksp(libs.androidx.room.compiler)
     ```
3. Click **Sync Now**.
4. In the same folder as `MainActivity.kt` -> create 3 Kotlin files:
   - `Student.kt`
   - `StudentDao.kt`
   - `StudentDatabase.kt`
5. Match package name in line 1 of all 4 files.
6. Click **Run**.
7. View database table: Top menu -> **View** -> **Tool Windows** -> **App Inspection** -> **Database Inspector** -> select `student` table.
