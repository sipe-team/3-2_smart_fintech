package com.smart.fintech

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules

class ModularityTest {
    private val modules: ApplicationModules = ApplicationModules.of(FintechApplication::class.java)

    @Test
    fun verifyModularity() {
        println(modules.toString())

        modules.verify()
    }
}