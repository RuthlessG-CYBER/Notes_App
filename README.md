# 📝 **Note_App**

ComposeNotes is a minimalist and elegant note-taking app built using Jetpack Compose in Android Studio. Designed to be simple, fast, and easy to use, it allows users to jot down notes with a beautiful and responsive UI.

<p align="left">
  <img src="https://upload.wikimedia.org/wikipedia/commons/7/74/Kotlin_Icon.png" alt="Kotlin" width="30"/>
  <strong style="vertical-align: middle; margin-left: 15px;">Kotlin</strong>
</p>

---

## **Features:**
  1. Create, edit, and view notes.
  2. Each note includes an auto-generated timestamp.
  3. Clean and intuitive UI built using Jetpack Compose.
  4. Notes are stored in memory (temporary storage only).
  5. Fully responsive and adaptable for different screen sizes.

---

## 📸 **Screenshots**

| Splash Screen | Add Note | Notes List | Saved Note | Extra View |
|---------------|----------|------------|------------|------------|
| ![Splash](https://github.com/user-attachments/assets/63801753-7a9d-47f9-a705-f7faffb54678) | ![Add](https://github.com/user-attachments/assets/df6a9c7b-7838-4ec2-b48f-7d3766ea2e6a) | ![List](https://github.com/user-attachments/assets/134a5249-4e0f-4bfe-a007-a16db1267874) | ![Saved](https://github.com/user-attachments/assets/9ea4f071-f10d-4072-a8d6-ad94c46a4cc6) | ![Extra](https://github.com/user-attachments/assets/c167caf3-1f9f-401d-8a48-a911aac29889) |

---

## **Built With:**
- 🧠 **MVVM Architecture**
- 💻 **Android Studio**
- 🧑‍💻 **Kotlin + Jetpack Compose**
- 🧩 **Material Design 3 Components**
- 🧪 **In-memory ViewModel-based data storage (no database yet)**

---

## 🚀 **Getting Started**

To run this project locally:

1. Clone this repository:
    ```bash
    git clone https://github.com/RuthlessG-CYBER/Notes_App.git
    ```

2. Open the project in Android Studio Hedgehog or newer.
3. Make sure all Compose dependencies are installed.
4. Add these dependencies to your `build.gradle`:

    ```kotlin
    // Core AndroidX
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")

    // Jetpack Compose
    implementation("androidx.compose.ui:ui:1.5.4")
    implementation("androidx.compose.ui:ui-graphics:1.5.4")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.4")
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.1")

    // Debugging
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.4")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.4")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.4")
    ```

5. Connect an emulator or device and hit **Run** ▶️.

---

## 📌 **Roadmap**
- 💾 Add persistent storage using Room or DataStore
- 🗑️ Note deletion and editing support
- 🔍 Add search functionality
- 🌙 Add light/dark mode toggle

---

## 🤝 **Contributing**
Feel free to fork this repo and submit pull requests. Ideas and improvements are always welcome!

---

## 📬 **Contact**
For any questions, ideas, or collaborations — feel free to reach out to the author:

**Soumya Panda**

⚠️ **Note**: This version does not implement persistent data storage. All notes are stored temporarily in memory and will be lost when the app closes.
