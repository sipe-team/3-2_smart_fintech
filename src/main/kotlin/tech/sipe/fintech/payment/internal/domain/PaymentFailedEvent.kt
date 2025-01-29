package tech.sipe.fintech.payment.internal.domain

import tech.sipe.fintech.common.DomainEvent

class PaymentFailedEvent(
	val paymentId: Long,
) : DomainEvent()
