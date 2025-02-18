import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    id("com.google.devtools.ksp") version "1.9.23-1.0.20"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.23"
    id("de.jensklingenberg.ktorfit") version "2.0.0-beta1"
}

val ktorfit = "2.0.0-beta1"
val ktor = "2.3.10"

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    jvmToolchain(8)
    jvm("desktop")
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(compose.material3)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.lifecycle.viewmodel)
            implementation(libs.navigation.compose)
            implementation(libs.image.loader)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation("io.ktor:ktor-client-logging:$ktor")

            implementation("io.ktor:ktor-client-auth:$ktor")
            implementation("de.jensklingenberg.ktorfit:ktorfit-lib:$ktorfit")
            implementation("io.ktor:ktor-client-serialization:$ktor")
            implementation("io.ktor:ktor-client-content-negotiation:$ktor")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor")
            implementation("de.jensklingenberg.ktorfit:ktorfit-converters-response:$ktorfit")
            implementation("de.jensklingenberg.ktorfit:ktorfit-converters-call:$ktorfit")
            implementation("de.jensklingenberg.ktorfit:ktorfit-converters-flow:$ktorfit")

            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

android {
    namespace = "com.khrystynasika.movievision"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.khrystynasika.movievision"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

dependencies {
    implementation(libs.androidx.material3.android)
    add("kspCommonMainMetadata", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfit")
    add("kspAndroid","de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfit")
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.khrystynasika.movievision"
            packageVersion = "1.0.0"
        }
    }
}
