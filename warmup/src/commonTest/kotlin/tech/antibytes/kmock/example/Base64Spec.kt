package tech.antibytes.kmock.example

import tech.antibytes.kfixture.fixture
import tech.antibytes.kfixture.kotlinFixture
import tech.antibytes.util.test.annotations.RobolectricConfig
import tech.antibytes.util.test.annotations.RobolectricTestRunner
import tech.antibytes.util.test.annotations.RunWithRobolectricTestRunner
import tech.antibytes.util.test.isNot
import tech.antibytes.util.test.mustBe
import kotlin.js.JsName
import kotlin.test.Test

@RobolectricConfig(manifest = "--none")
@RunWithRobolectricTestRunner(RobolectricTestRunner::class)
// "The quick brown fox jumps over the lazy dog"
// "VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wcyBvdmVyIHRoZSBsYXp5IGRvZw=="
class Base64Spec {
    private val fixture = kotlinFixture()

    @Test
    @JsName("fn0")
    fun `Given encode is called bytearray it returns its result base64 encoded`() {
        // Given
        val payload = "The quick brown fox jumps over the lazy dog".encodeToByteArray()
        val expected = "VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wcyBvdmVyIHRoZSBsYXp5IGRvZw=="
        // When
        val actual = Base64.encode(payload)

        // Then
        actual mustBe expected
        actual isNot fixture.fixture<String>()
    }

}
