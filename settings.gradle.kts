/*
 * Copyright (c) 2022 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */
import tech.antibytes.gradle.dependency.settings.localGithub

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        val antibytesPlugins = "^tech\\.antibytes\\.[\\.a-z\\-]+"
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {
            setUrl("https://raw.github.com/bitPogo/maven-snapshots/main/snapshots")
            content {
                includeGroupByRegex(antibytesPlugins)
            }
        }
        maven {
            setUrl("https://raw.github.com/bitPogo/maven-dev/main/dev")
            content {
                includeGroupByRegex(antibytesPlugins)
            }
        }
        maven {
            setUrl("https://raw.github.com/bitPogo/maven-rolling-releases/main/rolling")
            content {
                includeGroupByRegex(antibytesPlugins)
            }
        }
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        getByName("antibytesCatalog") {
            version("gradle-ksp-plugin-dependency", "1.7.22-1.0.8")
            version("gradle-ksp-runtime", "1.7.22-1.0.8")
            version("gradle-ksp-plugin-plugin", "1.7.22-1.0.8")

            version("kotlin-android", "1.7.22")
            version("kotlin-jvm", "1.7.22")
            version("kotlin-kotlin-dependency", "1.7.22")
            version("kotlin-kotlin-plugin", "1.7.22")
            version("kotlin-language", "1.7.22")
            version("kotlin-multiplatform", "1.7.22")
            version("kotlin-reflect", "1.7.22")
            version("kotlin-stdlib-common", "1.7.22")
            version("kotlin-stdlib-jdk", "1.7.22")
            version("kotlin-stdlib-jdk8", "1.7.22")
            version("kotlin-stdlib-js", "1.7.22")
            version("kotlin-test-annotations", "1.7.22")
            version("kotlin-test-core-common", "1.7.22")
            version("kotlin-test-core-js", "1.7.22")
            version("kotlin-test-core-jvm", "1.7.22")
            version("kotlin-test-core-wasm", "1.7.22")
            version("kotlin-test-junit4", "1.7.22")
            version("kotlin-test-junit5", "1.7.22")
        }
    }
}

plugins {
    id("tech.antibytes.gradle.dependency.settings") version "52dc3b1"
}

includeBuild("setup")

include(
    ":warmup",
    ":mockactive",
    ":mockmp",
    ":kmock"
)

buildCache {
    localGithub()
}
rootProject.name = "meetup-20230316-kotlin-kmock"
