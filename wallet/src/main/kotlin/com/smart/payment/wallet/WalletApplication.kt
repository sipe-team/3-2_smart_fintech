package com.smart.payment.wallet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WalletApplication

fun main(args: Array<String>) {
	runApplication<WalletApplication>(*args)
}
