package tech.sipe.fintech.payment.internal.presentation

import org.springframework.stereotype.Component
import tech.sipe.fintech.payment.PaymentInternalApi
import tech.sipe.fintech.payment.internal.domain.Payment
import tech.sipe.fintech.payment.internal.domain.PaymentRepository

@Component
class PaymentInternalApiImpl(
	private val paymentRepository: PaymentRepository,
) : PaymentInternalApi {
	override fun getPaymentByPaymentId(paymentId: Long): Payment = paymentRepository.findByPaymentId(paymentId)
}
