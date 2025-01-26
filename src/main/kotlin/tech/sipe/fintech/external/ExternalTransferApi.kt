package tech.sipe.fintech.external

interface ExternalTransferApi {
	/**
	 * 계좌간 이체
	 */
	fun transfer(
		sourceAccountNumber: String,
		destinationAccountNumber: String,
		amount: Long,
	)
}
