package tech.sipe.fintech.external.service

import org.springframework.stereotype.Component
import tech.sipe.fintech.external.ExternalTransferApi
import tech.sipe.fintech.transfer.internal.domain.TransferService

@Component
class ExternalTransferApiImpl(
	private val transferService: TransferService,
) : ExternalTransferApi {
	override fun transfer(
		sourceAccountNumber: String,
		destinationAccountNumber: String,
		amount: Long,
	) {
		transferService.transfer(
			sourceAccountNumber,
			destinationAccountNumber,
			amount,
		)
	}
}
