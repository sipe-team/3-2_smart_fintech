package tech.sipe.fintech.external

interface ExternalBankTransferApi {
	/**
	 * 계좌간 이체
	 */
	fun transfer(
		sourceAccountNumber: String,
		destinationAccountNumber: String,
		amount: Long,
	): ExternalBankTransferResult
}
