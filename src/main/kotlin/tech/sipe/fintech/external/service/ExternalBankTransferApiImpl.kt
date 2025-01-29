package tech.sipe.fintech.external.service

import org.springframework.stereotype.Component
import tech.sipe.fintech.external.ExternalBankTransferApi
import tech.sipe.fintech.external.ExternalBankTransferResult

@Component
class ExternalBankTransferApiImpl : ExternalBankTransferApi {
	override fun transfer(
		sourceAccountNumber: String,
		destinationAccountNumber: String,
		amount: Long,
	): ExternalBankTransferResult {
		TODO("Not yet implemented")
	}
}
