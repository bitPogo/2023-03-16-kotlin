/*
 * Copyright (c) 2022 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */

package tech.antibytes.kmock.example

import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.time
import io.mockative.verify
import kotlin.js.JsName
import kotlin.test.Test
import tech.antibytes.kfixture.fixture
import tech.antibytes.kfixture.kotlinFixture

class InterfaceSpec {
    private val fixture = kotlinFixture()

    @Mock
    val mock: Interface = mock(classOf())

    @Test
    @JsName("fn0")
    fun `It runs Interface`() {
        // Given
        val arg0: Int = fixture.fixture()
        val arg1: Any = fixture.fixture()

        given(mock).invocation { doSomething() }.then { fixture.fixture() }
        given(mock).invocation { doSomethingElse(arg0, arg1) }.then { fixture.fixture() }
        given(mock).invocation { doAnything() }.then { fixture.fixture() }
        given(mock).invocation { doAnythingElse(arg0, arg1) }.then { fixture.fixture() }
        given(mock).invocation { doNothing() }.then { fixture.fixture() }

        // When
        mock.doSomething()
        mock.doSomethingElse(arg0, arg1)
        mock.doAnything()
        mock.doAnythingElse(arg0, arg1)
        mock.doNothing()

        // Then
        verify(mock).invocation { doSomething() }.wasInvoked(1.time)
        verify(mock).invocation { doSomethingElse(arg0, arg1) }.wasInvoked(1.time)
        verify(mock).invocation { doAnything() }.wasInvoked(1.time)
        verify(mock).invocation { doAnythingElse(arg0, arg1) }.wasInvoked(1.time)
        verify(mock).invocation { doNothing() }.wasInvoked(1.time)
    }
}
