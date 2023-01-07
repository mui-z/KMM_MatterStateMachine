plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.google.devtools.ksp") version "1.7.20-1.0.7"
}

val visualfsmVersion = "1.2.1"


kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Base classes for Android, JVM and KMM projects (Feature and AsyncWorker coroutines edition)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("ru.kontur.mobile.visualfsm:visualfsm-core:$visualfsmVersion")

                // Add generated code to source code directories
                kotlin.srcDir("${buildDir.absolutePath}/generated/ksp/")
//
//                // Optional - Graph creation and analysis
//                implementation("ru.kontur.mobile.visualfsm:visualfsm-tools:$visualfsmVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "studio.sekai.matterstatemachine"
    compileSdk = 32
    defaultConfig {
        minSdk = 30
        targetSdk = 32
    }
}

dependencies {
    add("kspAndroid", "ru.kontur.mobile.visualfsm:visualfsm-compiler:$visualfsmVersion")
}
