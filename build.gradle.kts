buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.gms.google-services") version "4.3.15" apply false
}

allprojects {
    ext {
        set("activity_version","1.7.2")
        set("fragment_version", "1.6.1")
        set("lifecycle_version", "2.6.1")
        set("navigation_version","2.7.4")
        set("core_ktx_version", "1.12.0")
        set("bom_date", "2023.10.00")
        set("junit_version","4.13.2")
        set("junit_ktx_version", "1.1.5")
        set("junit_monitor_version", "1.6.1")
    }

    ext{
        set("jvm_target", "17")
        set("kotlin_compiler_extension_version", "1.4.3")
        set("java_version", JavaVersion.VERSION_17)
    }
}

