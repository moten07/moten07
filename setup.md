This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop (JVM), Server.

* [/composeApp](./app/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
    - [commonMain](./app/src/commonMain/kotlin) is for code that’s common for all targets.
    - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
      For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
      the [iosMain](./app/src/iosMain/kotlin) folder would be the right place for such calls.
      Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./app/src/jvmMain/kotlin)
      folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* [/server](./server/src/main/kotlin) is for the Ktor server application.

* [/shared](./shared/src) is for the code that will be shared between all targets in the project.
  The most important subfolder is [commonMain](./shared/src/commonMain/kotlin). If preferred, you
  can add code to the platform-specific folders here too.
---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack
channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [YouTrack](https://youtrack.jetbrains.com/newIssue?project=CMP).

### update gradle version

`./gradlew wrapper --gradle-version=9.1.0 --distribution-type=all`
Tencent Mirror Image:`https\://services.gradle.org/distributions/gradle-xxx.zip`

### clean

`gradle clean`

### Build and Run
* Application
    - Android
        + To build and run the development version of the Android app, use the run configuration from the run widget
          in your IDE’s toolbar or build it directly from the terminal:
          + Generate apk: `gradle -q :app:assembleRelease`
          + Generate aab: `gradle -q :app:bundleRelease`
    - ios
      + To build and run the development version of the iOS app, use the run configuration from the run widget
        in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.
    - Desktop
        + run: `gradle -q :app:run`
        + Generate AppImage: `gradle app:packageReleaseAppImage`
        + Generate exe: `gradle app:packageReleaseExe`
        + Generate dmg: `gradle app:packageReleaseDmg`
    - Server
        + run: `gradle -q :server:run`
        + Generate jar: `gradle -q :server:shadowJar`
    - web
        + run:
          - for the Wasm target (faster, modern browsers):`gradle :app:wasmJsBrowserDevelopmentRun`
          - for the JS target (slower, supports older browsers):`gradle :app:jsBrowserDevelopmentRun`
        + Generate artifacts: `gradle :app:wasmJsBrowserDistribution`
            * The generated artifacts are in the directory: `app/build/dist/wasmJs/productionExecutable`
            * can push it to GitHub pages
