package com.example.demo

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

data class Employee(
        val name: String,
        @JsonDeserialize(using = DecryptedJsonDeserializer::class)
        val tel: String)

class DecryptedJsonDeserializer: JsonDeserializer<String>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): String {
        return "decrypt ${p.valueAsString}"
    }
}