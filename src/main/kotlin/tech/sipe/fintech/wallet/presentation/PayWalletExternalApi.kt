package tech.sipe.fintech.wallet.presentation

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.sipe.fintech.wallet.presentation.request.CreateWalletRequest
import tech.sipe.fintech.wallet.service.PayWalletService

@RestController
@RequestMapping("/wallet")
class PayWalletExternalApi(
	private val payWalletService: PayWalletService,
) {
	@PostMapping()
	fun create(
		@Valid @RequestBody createWalletRequest: CreateWalletRequest,
	): ResponseEntity<Void> {
		payWalletService.create(createWalletRequest)
		return ResponseEntity.status(HttpStatus.CREATED).build()
	}
}
