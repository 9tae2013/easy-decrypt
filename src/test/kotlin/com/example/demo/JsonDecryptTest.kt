package com.example.demo

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.context.SpringBootTest

@JsonTest
class JsonDecryptTest {
    @Autowired
    lateinit var mapper: ObjectMapper

    @Test
    fun contextLoads() {
        val json = """{"name":"test","tel":"0811111111"}"""
        val result = mapper.readValue(json, Employee::class.java)

        assertThat(result.name).isEqualTo("test")
        assertThat(result.tel).isEqualTo("decrypt 0811111111")
    }

}
