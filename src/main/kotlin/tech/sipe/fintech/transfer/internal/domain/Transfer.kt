package tech.sipe.fintech.transfer.internal.domain

import tech.sipe.fintech.common.Currency
import java.math.BigDecimal

data class Transfer(
	val transferId: Long?,
	val departureId: Long,
	val destinationId: Long,
	val amount: BigDecimal,
	val currency: Currency,
	val transferType: TransferType,
	val status: TransferStatus,
	val message: String? = null,
)
