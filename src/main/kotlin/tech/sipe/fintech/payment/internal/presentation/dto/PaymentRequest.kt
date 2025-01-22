package tech.sipe.fintech.payment.internal.presentation.dto

import tech.sipe.fintech.common.Currency
import tech.sipe.fintech.payment.internal.domain.PaymentMethod
import java.math.BigDecimal

data class PaymentRequest(
	val paymentRequestUserId: Long,
	val paymentResponseUserId: Long,
	val money: BigDecimal,
	val currency: Currency,
	val paymentMethod: PaymentMethod,
)
