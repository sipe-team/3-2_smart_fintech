package tech.sipe.fintech.transfer.internal.service

import org.springframework.stereotype.Service
import tech.sipe.fintech.wallet.PayWalletApi

@Service
class TransferService(
	private val walletApi: PayWalletApi,
) {
	fun charge() {
	}

	fun withdraw() {
	}

	fun transfer() {
	}
}
