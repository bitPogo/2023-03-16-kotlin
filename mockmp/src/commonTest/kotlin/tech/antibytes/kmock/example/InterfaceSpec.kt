/*
 * Copyright (c) 2022 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */

package tech.antibytes.kmock.example

import kotlin.js.JsName
import kotlin.test.Test
import org.kodein.mock.Mocker
import org.kodein.mock.UsesMocks
import tech.antibytes.kfixture.fixture
import tech.antibytes.kfixture.kotlinFixture

@UsesMocks(Interface::class)
class InterfaceSpec {
    private val fixture = kotlinFixture()

    @Test
    @JsName("fn0")
    fun `It runs Interface`() {
        // Given
        val mocker = Mocker()
        val instance = MockInterface(mocker)
        val arg0: Int = fixture.fixture()
        val arg1: Any = fixture.fixture()

        mocker.every { instance.doSomething() } returns fixture.fixture()
        mocker.every { instance.doSomethingElse(isAny(), isAny()) } returns fixture.fixture()
        mocker.every { instance.doAnything() } returns fixture.fixture()
        mocker.every { instance.doAnythingElse(isAny(), isAny()) } returns fixture.fixture()
        mocker.every { instance.doNothing() } returns fixture.fixture()

        // When
        instance.doSomething()
        instance.doSomethingElse(arg0, arg1)
        instance.doAnything()
        instance.doAnythingElse(arg0, arg1)
        instance.doNothing()

        // Then
        mocker.verify {
            instance.doSomething()
            instance.doSomethingElse(arg0, arg1)
            instance.doAnything()
            instance.doAnythingElse(arg0, arg1)
            instance.doNothing()
        }
    }
}
