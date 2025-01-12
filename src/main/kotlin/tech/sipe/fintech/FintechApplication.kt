package tech.sipe.fintech

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.modulith.Modulithic

@Modulithic
@SpringBootApplication
class FintechApplication

fun main(args: Array<String>) {
	runApplication<FintechApplication>(*args)
}
