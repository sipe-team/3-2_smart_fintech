package tech.sipe.fintech.wallet.presentation.response

import java.math.BigDecimal

data class GetBalanceResponse(
	val balance: BigDecimal,
)
