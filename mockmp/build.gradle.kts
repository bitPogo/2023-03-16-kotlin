/*
 * Copyright (c) 2022 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */

import tech.antibytes.gradle.configuration.apple.ensureAppleDeviceCompatibility
import tech.antibytes.gradle.configuration.sourcesets.setupAndroidTest
import tech.antibytes.gradle.configuration.sourcesets.iosx

plugins {
    alias(antibytesCatalog.plugins.gradle.antibytes.kmpConfiguration)
    alias(antibytesCatalog.plugins.gradle.antibytes.androidLibraryConfiguration)

    alias(libs.plugins.ksp)
}

val projectPackage = "tech.antibytes.kmock.example"

android {
    namespace = projectPackage

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

kotlin {
    android()

    js(IR) {
        nodejs()
        browser()
    }

    jvm()

    iosx()
    ensureAppleDeviceCompatibility()

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
                optIn("kotlinx.coroutines.DelicateCoroutinesApi")
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(antibytesCatalog.common.kotlin.stdlib)
            }
        }
        val commonTest by getting {
            // kotlin.srcDir("build/generated/ksp/jvm/jvmTest/kotlin")
            dependencies {
                implementation(antibytesCatalog.common.test.kotlin.core)
                implementation(libs.testUtils.core)
                implementation(libs.testUtils.annotations)
                implementation(libs.kfixture)

                implementation(libs.mockmp.runtime)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(antibytesCatalog.jvm.kotlin.stdlib.jdk8)
            }
        }

        setupAndroidTest()
        val androidTest by getting {
            dependencies {
                implementation(antibytesCatalog.android.test.junit.core)
                implementation(antibytesCatalog.jvm.test.kotlin.junit4)
                implementation(antibytesCatalog.android.test.ktx)
                implementation(antibytesCatalog.android.test.robolectric)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(antibytesCatalog.jvm.kotlin.stdlib.jdk)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(antibytesCatalog.jvm.test.kotlin.core)
                implementation(antibytesCatalog.jvm.test.junit.junit4)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(antibytesCatalog.js.kotlin.stdlib)
                implementation(antibytesCatalog.js.kotlinx.nodeJs)

            }
        }

        val jsTest by getting {
            dependencies {
                implementation(antibytesCatalog.js.test.kotlin.core)
            }
        }
    }
}

dependencies {
    add("kspJvmTest", libs.mockmp.processor.get())
    add("kspAndroidTest", libs.mockmp.processor.get())
    add("kspJsTest", libs.mockmp.processor.get())
    add("kspIosX64Test", libs.mockmp.processor.get())
    add("kspIosSimulatorArm64Test", libs.mockmp.processor.get())
}
