package tech.sipe.fintech.account

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountApi(
	private val accountService: AccountService
) {

	@PostMapping("/accounts/registration")
	fun register(
		@RequestParam memberId: Long
	) {
		accountService.register()
	}

	@PostMapping("/accounts/cancellation")
	fun cancel(
		@RequestParam memberId: Long
	) {
		accountService.cancel()
	}
}
