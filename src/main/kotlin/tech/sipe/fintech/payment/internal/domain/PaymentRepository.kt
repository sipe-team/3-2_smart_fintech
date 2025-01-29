package tech.sipe.fintech.payment.internal.domain

interface PaymentRepository {
	fun save(payment: Payment): Payment

	fun findByPaymentId(paymentId: Long): Payment
}
