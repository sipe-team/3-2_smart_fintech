package tech.sipe.fintech.account.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.sipe.fintech.account.presentation.request.CreateAccountRequest
import tech.sipe.fintech.account.service.AccountService

@RestController
@RequestMapping("/account")
class AccountExternalApi(
	private val accountService: AccountService,
) {
	@PostMapping
	fun createAccount(
		@RequestBody createAccountRequest: CreateAccountRequest,
	): ResponseEntity<Void> {
		accountService.create(createAccountRequest)
		return ResponseEntity.status(HttpStatus.CREATED).build()
	}
}
