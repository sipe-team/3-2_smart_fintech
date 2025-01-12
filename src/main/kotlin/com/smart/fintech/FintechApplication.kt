package com.smart.fintech

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FintechApplication

fun main(args: Array<String>) {
	runApplication<FintechApplication>(*args)
}
