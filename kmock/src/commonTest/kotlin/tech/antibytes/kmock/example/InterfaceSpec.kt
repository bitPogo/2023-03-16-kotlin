/*
 * Copyright (c) 2022 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */

package tech.antibytes.kmock.example

import kotlin.js.JsName
import kotlin.test.Test
import tech.antibytes.kfixture.fixture
import tech.antibytes.kfixture.kotlinFixture
import tech.antibytes.kmock.MockCommon
import tech.antibytes.kmock.verification.Asserter
import tech.antibytes.kmock.verification.assertOrder

interface Interface2 {
    fun doSomething(): Int
    fun doSomethingElse(arg0: Int, arg1: Any): Int
    fun doAnything(): Any
    fun doAnythingElse(arg0: Int, arg1: Any): Any
    fun doNothing(): Unit
}

@MockCommon(Interface2::class)
class InterfaceSpec {
    private val fixture = kotlinFixture()

    @Test
    @JsName("fn0")
    fun `It runs Interface`() {
        // Given
        val asserter = Asserter()
        val instance: Interface2Mock = kmock(collector = asserter)
        val arg0: Int = fixture.fixture()
        val arg1: Any = fixture.fixture()

        instance._doSomething.returnValue = fixture.fixture()
        instance._doSomethingElse.sideEffect = { _, _ ->
            23
        }
        instance._doAnything.returnValue = fixture.fixture()
        instance._doAnythingElse.returnValue = fixture.fixture()
        instance._doNothing.returnValue = fixture.fixture()

        // When
        instance.doSomething()
        instance.doSomethingElse(42, arg1)
        instance.doAnything()
        instance.doAnythingElse(arg0, arg1)
        instance.doNothing()

        // Then
        asserter.assertOrder {
            instance._doSomething.hasBeenStrictlyCalledWith()
            instance._doSomethingElse.hasBeenStrictlyCalledWith(42, arg1)
            instance._doAnything.hasBeenStrictlyCalledWith()
            instance._doAnythingElse.hasBeenStrictlyCalledWith(arg0, arg1)
            instance._doNothing.hasBeenStrictlyCalledWith()
        }
    }
}
