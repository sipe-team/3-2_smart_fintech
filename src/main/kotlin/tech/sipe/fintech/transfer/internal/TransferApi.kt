package tech.sipe.fintech.transfer.internal

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tech.sipe.fintech.wallet.PayWalletApi

@RestController
class TransferApi(
	private val transferService: TransferService,
	private val payWalletApi: PayWalletApi
) {

	@PostMapping("/transfers/charge")
	fun charge(
		@RequestParam memberId: Long
	) {
		val balance = payWalletApi.getBalance(123)
		transferService.charge()
	}

	@PostMapping("/transfers/withdrawal")
	fun withdraw(
		@RequestParam memberId: Long
	) {}

	@PostMapping("/transfers")
	fun transfer(
		@RequestParam memberId: Long
	) {
		transferService.transfer()
	}

}
