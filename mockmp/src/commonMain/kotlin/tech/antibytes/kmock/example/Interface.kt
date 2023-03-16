/*
 * Copyright (c) 2022 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */

package tech.antibytes.kmock.example

interface Interface {
    fun doSomething(): Int
    fun doSomethingElse(arg0: Int, arg1: Any): Int
    fun doAnything(): Any
    fun doAnythingElse(arg0: Int, arg1: Any): Any
    fun doNothing(): Unit
}
