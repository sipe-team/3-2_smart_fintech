package tech.sipe.fintech.payment.internal.presentation

import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component
import tech.sipe.fintech.payment.internal.domain.PaymentFailedEvent
import tech.sipe.fintech.payment.internal.service.PaymentService

@Component
class PaymentEventListener(
	private val paymentService: PaymentService,
) {
	@ApplicationModuleListener
	fun handle(event: PaymentFailedEvent) {
		paymentService.compensatePayment(paymentId = event.paymentId)
	}
}
