# Android Studio Execution Steps

### SDK / Compiler Version Setting
In `app/build.gradle.kts`:
```kotlin
android {
    compileSdk = 35  // Change to 34, 35, 36, or 37 as required

    defaultConfig {
        targetSdk = 35  // Match compileSdk value
    }
}
```
Click **Sync Now**.

---

### Task 3: Hello World & Activity Lifecycle
1. Create new project with **Empty Activity** (Jetpack Compose).
2. Open `MainActivity.kt`.
3. Paste code from `Task_03_HelloWorld_Lifecycle/MainActivity.kt`.
4. Match package name in line 1 to your project.
5. Click **Run**.
6. Open **Logcat** window at bottom, filter: `Lifecycle`.

---

### Task 4-1: Login Module Using Intent
1. Open `MainActivity.kt` and paste code from `Task_04_1_Login_Intent/MainActivity.kt`.
2. In the same folder, right click -> **New** -> **Kotlin Class/File** -> name: `MainActivity2`.
3. Paste code from `Task_04_1_Login_Intent/MainActivity2.kt`.
4. Open `app/src/main/AndroidManifest.xml`, inside `<application> ... </application>` add:
```xml
<activity android:name=".MainActivity2" android:exported="false" />
```
5. Match package name in line 1 of both files.
6. Click **Run**.
7. Credentials: Username `admin`, Password `1234`.

---

### Task 4-2: Dice Roller App
1. Open `MainActivity.kt` and paste code from `Task_04_2_Dice_Roller/MainActivity.kt`.
2. Match package name in line 1.
3. In `app/src/main/res/drawable/`, place 6 image files named:
   `dice1.png`, `dice2.png`, `dice3.png`, `dice4.png`, `dice5.png`, `dice6.png`
4. Click **Run**.

---

### Task 5-1: Dwellings OOP Hierarchy
1. In Android Studio, open `Task_05_1_Dwellings_OOP/Dwellings.kt`.
2. Click the green **▶** arrow next to `fun main()` on line 9.
3. Click **Run 'DwellingsKt'**.
4. Output displays in the Run console window at the bottom.

---

### Task 5-2: Tip Calculator App
1. Open `MainActivity.kt` and paste code from `Task_05_2_Tip_Calculator/MainActivity.kt`.
2. Match package name in line 1.
3. Click **Run**.

---

### Task 6-1: Affirmations App
1. Open `MainActivity.kt` and paste code from `Task_06_1_Affirmations/MainActivity.kt`.
2. Match package name in line 1.
3. In `app/src/main/res/drawable/`, place 3 image files named:
   `img1.png`, `img2.png`, `img3.png`
4. Click **Run**.

---

### Task 6-2 & 7-1: Dictionary & Words App
1. Open `app/build.gradle.kts`. Under `dependencies { ... }`, add:
```kotlin
implementation("androidx.navigation:navigation-compose:2.8.5")
```
2. Click **Sync Now**.
3. Open `MainActivity.kt` and paste code from `Task_06_2_and_07_1_Dictionary_Words/MainActivity.kt`.
4. Match package name in line 1.
5. Click **Run**.

---

### Task 7-2: ViewModel & LiveData App
1. Open `app/build.gradle.kts`. Under `dependencies { ... }`, add:
```kotlin
implementation("androidx.compose.runtime:runtime-livedata:1.7.6")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
```
2. Click **Sync Now**.
3. In project folder, right click -> **New** -> **Kotlin Class/File** -> name: `CounterViewModel`.
4. Paste code from `Task_07_2_ViewModel_LiveData/CounterViewModel.kt`.
5. Open `MainActivity.kt` and paste code from `Task_07_2_ViewModel_LiveData/MainActivity.kt`.
6. Match package name in line 1 of both files.
7. Click **Run**.

---

### Task 8: Cupcake Ordering App
1. Open `MainActivity.kt` and paste code from `Task_08_Cupcake_Order/MainActivity.kt`.
2. Match package name in line 1.
3. Click **Run**.

---

### Task 9: Android Trivia App
1. Open `app/build.gradle.kts`. Under `dependencies { ... }`, add:
```kotlin
implementation("androidx.navigation:navigation-compose:2.8.5")
```
2. Click **Sync Now**.
3. Open `MainActivity.kt` and paste code from `Task_09_Android_Trivia/MainActivity.kt`.
4. Match package name in line 1.
5. Click **Run**.

---

### Task 11: Guess the Word App
1. Open `MainActivity.kt` and paste code from `Task_11_Guess_The_Word/MainActivity.kt`.
2. Match package name in line 1.
3. Click **Run**.

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
4. Create 3 Kotlin files in the same folder as `MainActivity.kt`:
   - `Student.kt` -> paste from `Task_12_Room_Database/Student.kt`
   - `StudentDao.kt` -> paste from `Task_12_Room_Database/StudentDao.kt`
   - `StudentDatabase.kt` -> paste from `Task_12_Room_Database/StudentDatabase.kt`
5. Open `MainActivity.kt` -> paste from `Task_12_Room_Database/MainActivity.kt`.
6. Match package name in line 1 of all 4 files.
7. Click **Run**.
8. View inserted data: Top menu -> **View** -> **Tool Windows** -> **App Inspection** -> **Database Inspector** -> select `student` table.
