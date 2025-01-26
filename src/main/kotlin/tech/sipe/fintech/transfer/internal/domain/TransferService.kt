package tech.sipe.fintech.transfer.internal.domain

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import tech.sipe.fintech.common.Currency
import tech.sipe.fintech.wallet.domain.PayWalletTransferredEvent

// 추상화 필요할 지?
@Service
class TransferService(
	private val transferRepository: TransferRepository,
	private val eventPublisher: ApplicationEventPublisher,
) {
	fun charge() {
	}

	fun transfer(
		sourceAccountNumber: String,
		destinationAccountNumber: String,
		amount: Long,
	): Transfer {
		val transfer =
			Transfer(
				transferId = null,
				departureId = sourceAccountNumber.toLong(),
				destinationId = destinationAccountNumber.toLong(),
				amount = amount.toBigDecimal(),
				currency = Currency.KRW,
				transferType = TransferType.WALLET_TO_WALLET,
				status = TransferStatus.REQUESTED,
			)
		return transferRepository.save(transfer).let {
			eventPublisher.publishEvent(PayWalletTransferredEvent(it.transferId!!))
			it
		}
	}
}
