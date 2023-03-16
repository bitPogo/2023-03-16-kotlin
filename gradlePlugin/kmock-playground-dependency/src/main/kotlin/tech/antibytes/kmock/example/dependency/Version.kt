/*
 * Copyright (c) 2022 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */

package tech.antibytes.kmock.example.dependency

object Version {

    val gradle = Gradle

    object Gradle {
        /**
         * [AnitBytes GradlePlugins](https://github.com/bitPogo/gradle-plugins)
         */
        const val antibytes = "9e2ffe9"

        /**
         * [Spotless](https://plugins.gradle.org/plugin/com.diffplug.gradle.spotless)
         */
        const val spotless = "6.11.0"
    }

    val antibytes = Antibytes

    object Antibytes {
        const val test = "9401af5"

        /**
         * [KMock](https://github.com/bitPogo/kmock)
         */
        const val kmock = "0.3.0-rc04"

        /**
         * [KFixture](https://github.com/bitPogo/kfixture)
         */
        const val kfixture = "0.3.1"
    }

    val mockmp = MocKMP

    object MocKMP {
        /**
         * https://github.com/Kodein-Framework/MocKMP/releases
         */
        const val core = "1.9.0"
    }

    val mockative = Mockative

    object Mockative {
        /**
         * https://github.com/mockative/mockative/releases
         */
        const val core = "1.2.6"
    }

    val google = Google

    object Google {
        /**
         * [KSP](https://github.com/google/ksp)
         */
        /**
         * [KSP DevTools on MavenCentral](https://mvnrepository.com/artifact/com.google.devtools.ksp/com.google.devtools.ksp.gradle.plugin)
         */
        const val ksp = "1.7.10-1.0.6"
    }
}
