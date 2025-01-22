package tech.sipe.fintech.wallet.presentation

import jakarta.validation.constraints.NotNull

data class CreateWalletRequest(
	@field:NotNull(message = "User ID cannot be null")
	val userId: Long,
)
