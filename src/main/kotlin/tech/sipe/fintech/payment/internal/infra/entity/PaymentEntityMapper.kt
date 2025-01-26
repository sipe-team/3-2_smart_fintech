package tech.sipe.fintech.payment.internal.infra.entity

import tech.sipe.fintech.payment.internal.domain.Payment
import java.math.BigDecimal

object PaymentEntityMapper {
	fun toEntity(payment: Payment): PaymentEntity =
		PaymentEntity(
			paymentRequestUserId = payment.paymentRequestUserId,
			paymentResponseUserId = payment.paymentResponseUserId,
			money = payment.money,
			currency = payment.currency,
			paymentMethod = payment.paymentMethod,
			paymentStatus = payment.paymentStatus,
		)

	fun toDomain(paymentEntity: PaymentEntity): Payment =
		Payment(
			paymentId = paymentEntity.id ?: 0L,
			paymentRequestUserId = paymentEntity.paymentRequestUserId,
			paymentResponseUserId = paymentEntity.paymentResponseUserId,
			money = paymentEntity.money ?: BigDecimal.ZERO,
			currency = paymentEntity.currency,
			paymentMethod = paymentEntity.paymentMethod,
			paymentStatus = paymentEntity.paymentStatus,
		)
}
