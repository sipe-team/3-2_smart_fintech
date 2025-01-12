package tech.sipe.fintech.transfer

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TransferApi(
	private val transferService: TransferService
) {

	@PostMapping("/transfers/charge")
	fun charge(
		@RequestParam memberId: Long
	) {
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
