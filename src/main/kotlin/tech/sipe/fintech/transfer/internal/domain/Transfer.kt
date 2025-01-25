package tech.sipe.fintech.transfer.internal.domain

import tech.sipe.fintech.common.Currency

data class Transfer(
	val transferId: Long,
	val departureId: Long,
	val destinationId: Long,
	val amount: Long,
	val currency: Currency,
	val transferType: TransferType,
	val status: TransferStatus,
	val message: String? = null,
)
