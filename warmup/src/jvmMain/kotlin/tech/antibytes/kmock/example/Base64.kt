/*
 * Copyright (c) 2022 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */

package tech.antibytes.kmock.example

actual object Base64 {
    actual fun encode(data: ByteArray): String {
        return java.util.Base64.getEncoder().encodeToString(data)
    }
}
