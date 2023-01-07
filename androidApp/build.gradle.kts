plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "studio.sekai.matterstatemachine.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "studio.sekai.matterstatemachine.android"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = DV.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("ru.kontur.mobile.visualfsm:visualfsm-core:${DV.visualfsm}")

    implementation("androidx.core:core-ktx:${DV.coreKTX}")
    implementation("androidx.compose.ui:ui:${DV.compose}")
    implementation("androidx.compose.material:material:${DV.compose}")
    implementation("androidx.compose.ui:ui-tooling-preview:${DV.compose}")
    implementation("androidx.activity:activity-compose:${DV.activityCompose}")

    testImplementation("junit:junit:${DV.junit}")
    testImplementation("ru.kontur.mobile.visualfsm:visualfsm-tools:${DV.visualfsm}")
}
