package tech.sipe.fintech.transfer.internal.presentation

import org.springframework.context.ApplicationEventPublisher
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component
import tech.sipe.fintech.account.Account
import tech.sipe.fintech.external.ExternalBankTransferApi
import tech.sipe.fintech.payment.internal.domain.PaymentCompletedEvent
import tech.sipe.fintech.payment.internal.domain.PaymentFailedEvent
import tech.sipe.fintech.transfer.internal.domain.TransferRepository

@Component
class TransferEventListener(
	private val transferRepository: TransferRepository,
	private val externalBankTransferApi: ExternalBankTransferApi,
	private val eventPublisher: ApplicationEventPublisher,
) {
	@ApplicationModuleListener
	fun handle(event: PaymentCompletedEvent) {
		try {
			// FIXME account 조회 로직 필요
			val sourceAccount: Account
			val destinationAccount: Account
			val transferResult =
				externalBankTransferApi
					.transfer(
						sourceAccountNumber = sourceAccount.accountNumber,
						destinationAccountNumber = destinationAccount.accountNumber,
						amount = event.amount.toLong(),
					).result
			if (transferResult.not()) eventPublisher.publishEvent(PaymentFailedEvent(paymentId = event.paymentId))
			transferRepository.save(Transfer(transferResult))
		} catch (e: Exception) {
			eventPublisher.publishEvent(PaymentFailedEvent(paymentId = event.paymentId))
		}
	}
}
