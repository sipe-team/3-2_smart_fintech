package tech.sipe.fintech.payment

import tech.sipe.fintech.payment.internal.domain.Payment

interface PaymentInternalApi {
	fun getPaymentByPaymentId(paymentId: Long): Payment
}
