package tech.sipe.fintech.payment.internal.domain

import tech.sipe.fintech.common.DomainEvent
import java.math.BigDecimal

class PaymentCompletedEvent(
	val paymentId: Long,
	val amount: BigDecimal,
) : DomainEvent()
