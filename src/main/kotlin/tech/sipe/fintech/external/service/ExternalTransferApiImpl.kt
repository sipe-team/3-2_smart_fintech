package tech.sipe.fintech.external.service

import org.springframework.stereotype.Component
import tech.sipe.fintech.external.ExternalTransferApi

@Component
class ExternalTransferApiImpl : ExternalTransferApi {
	override fun transfer(
		sourceAccountNumber: String,
		destinationAccountNumber: String,
		amount: Long,
	) {
		TODO("Not yet implemented")
	}
}
