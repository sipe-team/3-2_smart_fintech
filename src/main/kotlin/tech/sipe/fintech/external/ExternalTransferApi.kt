package tech.sipe.fintech.external

import tech.sipe.fintech.transfer.internal.domain.Transfer

interface ExternalTransferApi {
	/**
	 * 계좌간 이체
	 */
	fun transfer(
		sourceAccountNumber: String,
		destinationAccountNumber: String,
		amount: Long,
	): Transfer
}
