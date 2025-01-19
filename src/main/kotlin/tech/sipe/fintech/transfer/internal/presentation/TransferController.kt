package tech.sipe.fintech.transfer.internal.presentation

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tech.sipe.fintech.transfer.internal.service.TransferService

@RestController
class TransferController(
	private val transferService: TransferService,
) {
	@PostMapping("/transfers/charge")
	fun charge(
		@RequestParam memberId: Long,
	) {
		transferService.charge()
	}

	@PostMapping("/transfers/withdraw")
	fun withdraw(
		@RequestParam memberId: Long,
	) {
		transferService.withdraw()
	}

	@PostMapping("/transfers")
	fun transfer(
		@RequestParam memberId: Long,
	) {
		transferService.transfer()
	}
}
