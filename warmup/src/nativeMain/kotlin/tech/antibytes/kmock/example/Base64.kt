/*
 * Copyright (c) 2022 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */

package tech.antibytes.kmock.example

import io.matthewnelson.encoding.builders.Base64 as Encoder
import io.matthewnelson.encoding.core.Encoder.Companion.encodeToString

actual object Base64 {
    private val encoder = Encoder {
        isLenient = true
        lineBreakInterval = 64
        encodeToUrlSafe = true
        padEncoded = true
    }

    actual fun encode(data: ByteArray): String {
        return data.encodeToString(encoder)
    }
}
