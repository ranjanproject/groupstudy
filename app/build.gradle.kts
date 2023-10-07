plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}


private val jvmTargetVersion =  ext.get("jvm_target") as String
private val ktCompilerExtensionVersion =
    ext.get("kotlin_compiler_extension_version") as String
private val javaVersion = ext.get("java_version") as JavaVersion


android {
    namespace = "live.groupstudy.gs"
    compileSdk = 34

    defaultConfig {
        applicationId = "live.groupstudy.gs"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }



    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    kotlinOptions {
        jvmTarget = jvmTargetVersion
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ktCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


private val fragmentVersion = ext.get("fragment_version") as String
private val lifecycleVersion = ext.get("lifecycle_version") as String
private val activityVersion = ext.get("activity_version") as String
private val coreKtxVersion = ext.get("core_ktx_version") as String
private val navigationVersion = ext.get("navigation_version") as String
private val bomDate = ext.get("bom_date") as String

dependencies {
    implementation(platform("androidx.compose:compose-bom:${bomDate}"))
    implementation("androidx.activity:activity-compose:${activityVersion}")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.runtime:runtime")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.core:core-ktx:${coreKtxVersion}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:${lifecycleVersion}")
    implementation("androidx.navigation:navigation-compose:${navigationVersion}")

    debugImplementation("androidx.compose.ui:ui-test-manifest")
    debugImplementation("androidx.compose.ui:ui-tooling")
}