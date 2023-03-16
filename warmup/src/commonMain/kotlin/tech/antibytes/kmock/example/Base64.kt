package tech.antibytes.kmock.example

expect object Base64 {
    fun encode(data: ByteArray): String
}
