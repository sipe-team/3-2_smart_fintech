package tech.sipe.fintech.account

import tech.sipe.fintech.account.presentation.response.GetAccountResponse
import java.math.BigDecimal

interface AccountInternalApi {
	fun deleteAccount(accountId: Long)

	fun getBalance(accountId: Long): BigDecimal

	fun getAccountByUserId(userId: Long): GetAccountResponse

	fun deposit(
		accountId: Long,
		amount: Long,
	)

	fun withdraw(
		accountId: Long,
		amount: Long,
	)
}
