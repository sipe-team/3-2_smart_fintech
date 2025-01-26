package tech.sipe.fintech.account.presentation.request

import tech.sipe.fintech.account.domain.BankName

data class CreateAccountRequest(
	val userId: Long,
	val bankName: BankName,
	val iban: Long,
	val accountHolderName: String,
)
