package tech.sipe.fintech.payment.internal.presentation

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.sipe.fintech.payment.internal.presentation.dto.PaymentRequest
import tech.sipe.fintech.payment.internal.presentation.dto.PaymentResponse
import tech.sipe.fintech.payment.internal.service.PaymentService

@RestController
@RequestMapping("/payment")
class PaymentApi(
	private val paymentService: PaymentService,
) {
	@PostMapping("/request")
	fun requestPayment(
		@RequestBody @Valid paymentRequest: PaymentRequest,
	): ResponseEntity<PaymentResponse> {
		val paymentResponse = paymentService.processPayment(paymentRequest)
		return ResponseEntity.ok(paymentResponse)
	}
}
