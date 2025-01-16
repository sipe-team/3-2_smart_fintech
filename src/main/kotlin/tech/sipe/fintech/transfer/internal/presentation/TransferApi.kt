package tech.sipe.fintech.transfer.internal.presentation

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tech.sipe.fintech.transfer.internal.domain.TransferService
import tech.sipe.fintech.wallet.PayWalletApi

@RestController
@RequestMapping("/transfer")
class TransferApi(
	private val transferService: TransferService,
	private val payWalletApi: PayWalletApi,
) {
	@PostMapping("/charge")
	fun charge(
		@RequestParam memberId: Long,
	) {
		val balance = payWalletApi.getBalance(123)
		transferService.charge()
	}

	@PostMapping("/withdrawal")
	fun withdraw(
		@RequestParam memberId: Long,
	) {}

	@PostMapping
	fun transfer(
		@RequestParam memberId: Long,
	) {
		transferService.transfer()
	}
}
