package tech.sipe.fintech.payment.internal.domain

import tech.sipe.fintech.common.Currency
import java.math.BigDecimal

data class Payment(
	val paymentId: Long,
	val paymentRequestUserId: Long,
	val paymentResponseUserId: Long,
	val money: BigDecimal,
	val currency: Currency,
	val paymentMethod: PaymentMethod,
	val paymentStatus: PaymentStatus,
)
