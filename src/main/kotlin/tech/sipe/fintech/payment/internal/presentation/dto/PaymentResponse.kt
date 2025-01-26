package tech.sipe.fintech.payment.internal.presentation.dto

import tech.sipe.fintech.payment.internal.domain.Payment
import tech.sipe.fintech.payment.internal.domain.PaymentStatus

data class PaymentResponse(
	val paymentId: Long,
	val status: PaymentStatus,
) {
	companion object {
		fun from(payment: Payment): PaymentResponse =
			PaymentResponse(
				paymentId = payment.paymentId,
				status = payment.paymentStatus,
			)
	}
}
